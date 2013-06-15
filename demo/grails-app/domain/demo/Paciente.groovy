package demo

class Paciente {
    Contacto contacto
    Date fechaNacimiento
    String ocupacion

    static constraints = {
        ocupacion(blank: false)
        contacto(nullable: false)
        fechaNacimiento(nullable: false)
        fechaNacimiento validator: {val->
            val.before(new Date())
        }
    }
    //TODO: Método para obtener edad
}
