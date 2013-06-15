package demo

import groovy.time.TimeCategory

class Cita {
    Medico medico
    Paciente paciente
    Date fechaInicio
    Date fechaFin
    EstadoCita estado = EstadoCita.AGENDADA

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
