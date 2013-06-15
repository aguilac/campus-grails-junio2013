package demo

import groovy.time.TimeCategory

class Cita {
    Medico medico
    Paciente paciente
    Date fechaInicio
    Date fechaFin

    static constraints = {
        medico(nullable: false)
        paciente(nullable: false)
        fechaInicio(nullable: false)
        fechaFin(nullable: false)

        fechaInicio validator: { val, obj ->
             val.before(obj.fechaFin)
        }
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
