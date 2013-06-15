package demo
import org.joda.time.*
import org.jadira.usertype.dateandtime.joda.*

class Horario {

    Dia dia
    TimeOfDay horaInicio
    TimeOfDay horaFin

    static belongsTo = [medico:Medico]

    static constraints = {
        dia(unique: ['medico'], nullable: false)
        horaInicio(nullable: false)
        horaFin(nullable: false)
    }

    static mapping = {
        table 'horarios'
        horaInicio type: PersistentTimeOfDay
        horaFin type: PersistentTimeOfDay
        medico column: 'medico_id'
        cache: true
    }
}
