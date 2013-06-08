<%@ page import="curso.test.Persona" %>



<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'apellidos', 'error')} ">
	<label for="apellidos">
		<g:message code="persona.apellidos.label" default="Apellidos" />
		
	</label>
	<g:textField name="apellidos" value="${personaInstance?.apellidos}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="persona.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${personaInstance?.nombre}"/>
</div>

