<!DOCTYPE html>
<html>
	<head>
		<title>test project for jenkins plugin</title>
		<meta name="layout" content="main">
		
	</head>
	<body>
	<h1>Button that triggers tag lib to jenkins websocket connection</h1>
<g:form action="index2">
    <input type="hidden" name="goahead" value="yes">
    <input type="submit" value="Build Jenkins job">
</g:form>

<g:if test="${goahead.equals('yes') }">
    <jen:connect divId="firstId" 
    jenserver="localhost" 
    jensport="9090"
     
    jensuser="cc" jenspass="" 
    jensjob="vv" jensprefix="" jensfolder="job"
     
    jenschoice="build" hideButtons="no" 
    
    customParams="[appId: '123', appName: 'crazyApp', appEnv: 'test' ]"
     />

   
</g:if>
</body>
</html>