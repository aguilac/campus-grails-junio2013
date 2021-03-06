package demo

import org.joda.time.DateMidnight
import org.joda.time.DateTime
import org.joda.time.Years

class Paciente extends Usuario {
    Date fechaNacimiento
    String ocupacion

    static transients = ['edad']

    static constraints = {
        ocupacion(blank: false)
        fechaNacimiento(nullable: false)
        fechaNacimiento validator: {val->
            val.before(new Date())
        }
    }

    static mapping = {
        table 'pacientes'
        fechaNacimiento column: 'fecha_nac'
    }


    def getEdad() {
        DateMidnight birthdate = new DateMidnight(fechaNacimiento)
        DateTime now = new DateTime(new Date())
        Years age = Years.yearsBetween(birthdate, now)
        return age?.years
    }
}
