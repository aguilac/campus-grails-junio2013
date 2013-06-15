package demo

class Usuario {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false
    String nombreCompleto
    Contacto contacto

	static constraints = {
		username blank: false, unique: true
		password blank: false
        nombreCompleto(blank: false)
        contacto(nullable: false)
	}

	static mapping = {
		password column: '`password`'
        tablePerHierarchy false
    }

	Set<Rol> getAuthorities() {
		UsuarioRol.findAllByUsuario(this).collect { it.rol } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
