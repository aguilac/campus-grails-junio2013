package demo

class Pago {
    FormaPago formaPago
    Cita cita
    Double costo = cita?.medico?.costoCita
    Double extras = 0
    EstadoPago estadoPago = EstadoPago.PENDIENTE
    String notas
    Double total
    Date dateCreated
    Date lastUpdated

    static constraints = {
        formaPago(nullable: false)
        cita(nullable: false)
        costo(nullable: false)
        extras(nullable: false)
        estadoPago(nullable: false)
        notas(blank: true)
    }

    static mapping = {
        //Propiedades derivadas
        total formula: 'COSTO + EXTRAS'
        sort dateCreated: 'asc'
    }

}
