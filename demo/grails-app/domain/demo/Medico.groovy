package demo

class Medico {
    Contacto contacto
    Double costoCita
    Integer duracionCita

    static hasMany = [especialidades: Especialidad, horarios: Horario]

    static constraints = {
        contacto(nullable: false)
        costoCita(nullable: false, minSize: 0)
        duracionCita(nullable: false)
    }
}
