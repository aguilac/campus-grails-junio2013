package demo

import grails.validation.Validateable

class Contacto {
    String calle
    Integer numeroInterior
    Integer numeroExterior
    String codigoPostal
    String estado
    String pais
    String telefono
    String email

    static constraints = {
        calle(blank: false)
        numeroInterior(nullable: true)
        numeroExterior(nullable: false)
        codigoPostal(nullable: true)
        estado(blank: false)
        pais(blank: false)
        telefono(matches: '\\d{3}\\-\\d{7}')
        email(blank: false, email: true)
    }
}
