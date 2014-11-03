<!DOCTYPE html>
<html>
	<head>
		<title>test project for jenkins plugin</title>
		<meta name="layout" content="main">
		
	</head>
	<body>
	<h1>Button that triggers tag lib to jenkins websocket connection</h1>
	
	
	<jen:asyncBuild
	url="http://192.168.1.6:9090/job/my_build"
	
	customParams="[appId:'MyCurrentJob', appDetails: 'Something']"
	jensuser="cc"
	processurl="http://localhost:8080/testjenkins/test/parseJenPlugin"
	/>
	
	
	</body>
	</html>