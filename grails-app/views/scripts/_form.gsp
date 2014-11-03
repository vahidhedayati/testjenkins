<%@ page import="testjenkins.Scripts" %>



<div class="fieldcontain ${hasErrors(bean: scriptsInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="scripts.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${scriptsInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: scriptsInstance, field: 'script', 'error')} required">
	<label for="script">
		<g:message code="scripts.script.label" default="Script" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="script" required="" value="${scriptsInstance?.script}"/>

</div>

