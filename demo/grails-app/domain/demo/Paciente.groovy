package demo

class Paciente {
    String nombreCompleto
    Contacto contacto
    Date fechaNacimiento
    String ocupacion

    static embedded = ['contacto']

    static constraints = {
        ocupacion(blank: false)
        contacto(nullable: false)
        fechaNacimiento(nullable: false)
        fechaNacimiento validator: {val->
            val.before(new Date())
        }
    }

    static mapping = {
        table 'pacientes'
        fechaNacimiento column: 'fecha_nac'
    }
    //TODO: Método para obtener edad
}
