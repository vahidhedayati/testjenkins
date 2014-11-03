
<%@ page import="testjenkins.Scripts" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'scripts.label', default: 'Scripts')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-scripts" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-scripts" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'scripts.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="script" title="${message(code: 'scripts.script.label', default: 'Script')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${scriptsInstanceList}" status="i" var="scriptsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${scriptsInstance.id}">${fieldValue(bean: scriptsInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: scriptsInstance, field: "script")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${scriptsInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
