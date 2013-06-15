package demo

enum EstadoCita {
    AGENDADA("AGENDADA"), CANCELADA("CANCELADA"), ATENDIDO("ATENDIDO")

    private final String value

    EstadoCita(String val) { this.value = val  }

    String value() { return value }

    String getMessageCode() { return "${getClass().name}.${name()}" }

    public static final list() { [AGENDADA, CANCELADA, ATENDIDO] }
}
