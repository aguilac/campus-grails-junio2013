package demo

class Horario {

    Dia dia
    String horaInicio
    String horaFin

    static belongsTo = [medico:Medico]

    static constraints = {
        dia(unique: ['medico'], nullable: false)
        horaInicio(nullable: false, matches: ('([01]?[0-9]|2[0-3]):[0-5][0-9]'))
        horaFin(nullable: false, matches: ('([01]?[0-9]|2[0-3]):[0-5][0-9]'))
    }

    static mapping = {
        table 'horarios'
        medico column: 'medico_id'
        cache: true
    }
}
