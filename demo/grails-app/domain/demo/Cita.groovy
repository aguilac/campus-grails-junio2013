package demo

import groovy.time.TimeCategory

class Cita {
    Medico medico
    Paciente paciente
    Date fechaInicio
    Date fechaFin
    EstadoCita estado = EstadoCita.AGENDADA

    //Autotimestamp
    Date dateCreated
    Date lastUpdated

    static constraints = {
        medico(nullable: false)
        paciente(nullable: false)
        fechaInicio(nullable: false)
        fechaFin(nullable: false)

        fechaInicio validator: { val, obj ->
             val.before(obj.fechaFin)
        }
        estado(nullable: false)
    }

    static mapping = {
        table 'medicos'
        sort 'fechaInicio'
    }

    def beforeInsert() {
        calcularFechaFin()
    }

    def beforeUpdate() {
        calcularFechaFin()
    }


    def calcularFechaFin() {
        use(TimeCategory) {
            fechaFin = fechaInicio?.plus(medico?.duracionCita?.minutes)
        }
    }

    //TODO: aplicar verificación de horarios de citas
    //TODO: verificación de horarios conforme al médico
}
