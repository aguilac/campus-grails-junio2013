package curso.test

import org.springframework.dao.DataIntegrityViolationException

class PersonaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def scaffold = true

    def index() {
        redirect(action: "list", params: params)
    }

}
