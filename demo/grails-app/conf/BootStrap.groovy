import demo.Contacto
import demo.Medico
import demo.Paciente
import demo.Requestmap
import demo.Rol
import demo.Usuario
import demo.UsuarioRol

class BootStrap {

    def init = { servletContext ->
        //Inserción de datos
        Rol rolMedico = new Rol(authority: "ROLE_MEDICO").save(flush: true, failOnError: true)
        Rol rolPaciente = new Rol(authority: "ROLE_PACIENTE").save(flush: true, failOnError: true)
        Rol rolAdmin = new Rol(authority: "ROLE_ADMIN").save(flush: true, failOnError: true)

        Contacto contacto = new Contacto(
                calle: 'Calle 1',
                numeroInterior: 4,
                numeroExterior: 149,
                codigoPostal: "72180",
                estado: 'Puebla',
                pais: 'México',
                telefono: '222-1233223',
                email: 'pr@manoderecha.mx'
        ).save(flush: true, failOnError: true)

        Usuario admin = new Usuario(
                username: 'admin',
                password: 'admin',
                contacto: contacto,
                nombreCompleto: 'Administrador'

        ).save(flush: true, failOnError: true)

        Medico medico = new Medico(
                username: 'medico',
                password: 'medico',
                contacto: contacto,
                nombreCompleto: 'Médico',
                costoCita: 500,
                duracionCita: 15
        ).save(flush: true, failOnError: true)

        Paciente paciente = new Paciente(
                username: 'paciente',
                password: 'paciente',
                contacto: contacto,
                nombreCompleto: 'Paciente',
                fechaNacimiento: new Date() - 1,
                ocupacion: 'N/A'
        ).save(flush: true, failOnError: true)

        new UsuarioRol(usuario: medico, rol: rolMedico).save(flush: true, failOnError: true)
        new UsuarioRol(usuario: admin, rol: rolAdmin).save(flush: true, failOnError: true)
        new UsuarioRol(usuario: paciente, rol: rolPaciente).save(flush: true, failOnError: true)


        new Requestmap(
                configAttribute: 'ROLE_ADMIN',
                url: '/medico/**'
        ).save(flush: true, failOnError: true)

        new Requestmap(
                configAttribute: 'ROLE_ADMIN,ROLE_PACIENTE,ROL_MEDICO',
                url: '/cita/**'
        ).save(flush: true, failOnError: true)

        new Requestmap(
                configAttribute: 'ROLE_ADMIN',
                url: '/especialidad/**'
        ).save(flush: true, failOnError: true)

        new Requestmap(
                configAttribute: 'ROLE_ADMIN',
                url: '/usuario/**'
        ).save(flush: true, failOnError: true)

        new Requestmap(
                configAttribute: 'ROLE_ADMIN',
                url: '/rol/**'
        ).save(flush: true, failOnError: true)


        new Requestmap(
                configAttribute: 'ROLE_ADMIN',
                url: '/requestmap/**'
        ).save(flush: true, failOnError: true)


    }
    def destroy = {
    }
}
