package demo;


public enum FormaPago {

	EFECTIVO("Efectivo"),  TARJETA("TARJETA"), PAYPAL("PAYPAL")

    private final String value

    FormaPago(String val) { this.value = val  }

    String value() { return value }
}
