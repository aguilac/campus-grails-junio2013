package demo

class Medico {
    String nombreCompleto
    Contacto contacto
    Double costoCita
    Integer duracionCita

    static hasMany = [especialidades: Especialidad, horarios: Horario]

    static constraints = {
        nombreCompleto(blank: false)
        contacto(nullable: false)
        costoCita(nullable: false, minSize: 0)
        duracionCita(nullable: false)
    }
}
