package demo

class Paciente {
    String nombreCompleto
    Contacto contacto
    Date fechaNacimiento
    String ocupacion

    static constraints = {
        nombreCompleto(blank: false)
        ocupacion(blank: false)
        contacto(nullable: false)
        fechaNacimiento(nullable: false)
        fechaNacimiento validator: {val->
            val.before(new Date())
        }
    }
    //TODO: Método para obtener edad
}
