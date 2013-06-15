package demo

class Pago {
    FormaPago formaPago
    Cita cita
    Double costo = cita?.medico?.costoCita
    Double extras = 0
    EstadoPago estadoPago = EstadoPago.PENDIENTE
    String notas

    static constraints = {
        formaPago(nullable: false)
        cita(nullable: false)
        costo(nullable: false)
        extras(nullable: false)
        estadoPago(nullable: false)
        notas(blank: true)
    }


}
