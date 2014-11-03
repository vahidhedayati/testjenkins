<!DOCTYPE html>
<html>
	<head>
		<title>test project for jenkins plugin</title>
		<meta name="layout" content="main">
		<g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
	</head>
	<body>
<g:form >
    <input type="hidden" name="goahead" value="yes">
    <input type="submit" value="Build Jenkins job">
</g:form>

<g:if test="${goahead.equals('yes') }">
    <jen:connect divId="firstId" jenserver="localhost" jensport="9090" jensuser="" jenspass="" 
    jensjob="my_build" jensprefix="" jensfolder="job" jenschoice="build" hideButtons="no"  />

    <jen:connect divId="secondId" jenserver="localhost" jensport="9090" jensuser="" jenspass="" 
    jensjob="vv" jensprefix="" jensfolder="job" jenschoice="build" hideButtons="no" />
</g:if>
</body>
</html>