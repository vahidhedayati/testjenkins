<!DOCTYPE html>
<html>
	<head>
		<title>test project for jenkins plugin</title>
		<meta name="layout" content="main">
		
	</head>
	<body>
	
	<jssh:socketconnect hostname="localhost" 
	username="mx1"
	password="" 
userCommand="${scriptcontent }"
divId="logs2"
hideWhatsRunning="NO"
hideDiscoButton="NO"
hidePauseControl="NO"
/>

<div id="logs2"></div>
	</body>
	
	
	</html>