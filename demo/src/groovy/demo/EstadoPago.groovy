package demo

enum EstadoPago {
    PAGADO("PAGO"), PENDIENTE("PENDIENTE")

    private final String value

    EstadoPago(String val) { this.value = val  }

    String value() { return value }

    String getMessageCode() { return "${getClass().name}.${name()}" }

    public static final list() { [PAGADO,PENDIENTE] }
}
