package demo

public enum Dia {

    LUNES("LUNES", 1), MARTES("MARTES", 2),
    MIERCOLES("LUNES", 3), JUEVES("MARTES", 4),
    VIERNES("LUNES", 5), SABADO("MARTES", 6),
    DOMINGO("LUNES", 7)

    int id
    String name

    Dia(String name, int id) {
        this.name = name
        this.id = id
    }

    public static Dia getByName(final String name) {
        for(Dia fulfillmentMethod : Dia.values()){
            def nameEnum = fulfillmentMethod.getName().toUpperCase()
            def nameToCompare = (name?: "").toUpperCase().trim()
            if(nameEnum.equals(nameToCompare)){
                return  fulfillmentMethod
            }
        }
        return null
    }

    public static final list() { [LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO] }

    static def getById(Long id){
        Dia?.list()?.find { it.id == id }
    }
}
