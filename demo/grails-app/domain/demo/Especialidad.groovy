package demo

class Especialidad {
    String nombre

    static constraints = {
        nombre(blank: false, unique: true)
    }

    static mapping = {
        //Cache (read-write)
        cache: true
    }
}
