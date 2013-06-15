package demo

class Medico {
    String nombreCompleto
    Contacto contacto
    Double costoCita
    Integer duracionCita

    static hasMany = [especialidades: Especialidad, horarios: Horario]

    static constraints = {
        contacto(nullable: false)
        costoCita(nullable: false, minSize: 0)
        duracionCita(nullable: false)
    }

    static mapping = {
        table 'medicos'
        especialidades joinTable: [ name: 'medicos_especialidades',
                key: 'medico_id',
                column: 'especialidades_id'
        ]
        //Cache sobre asociaciones
        horarios cache: true
        especialidades cache: true
        //Sorting
        sort "nombreCompleto"
    }
}
