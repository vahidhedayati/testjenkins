package testjenkins

import grails.converters.JSON

class TestController {


	// Multiple builds on one page
	def index() {
		def goahead=params.goahead
		[goahead:goahead]
	}
	
	
	// one build that builds grails job.
	// provides a correct second page  that calls
	// jsshconnect which loads in jssh websocket plugin 
	// ssh across to localhost and scps file to a folder....
	def index2() {
		def goahead = params.goahead
		[goahead:goahead]
	}
	
	// Non websocket async build job that then calls a process url 
	// which can do something based on result aka. parseJenPlugin
	def index3() {
		def goahead = params.goahead
		[goahead:goahead]
	}

	def parseJenPlugin() {
		println ":::> ${params} <:::"
		def pp=params.customParams
		def apps
		if (pp) {
			def data = JSON.parse(params.customParams)
			def appId=data?.appId
			def appName=data?.appName
			def appEnv=data?.appEnv
			println "--- Our Custom values passed from initial taglib call are:"
			print " AppID: $appId | AppName: $appName | AppEnv: $appEnv"
			/*
			 *    <jen:connect divId="firstId" 
			 .....
			 customParams="[appId: '123', appName: 'crazyApp', appEnv: 'test' ]"
			 />
			 * 
			 */


		}
		render ""
	}

	def jsshconnect() {
		String result=params.result

		// You will have to write a parser to grab file from below buildUrl
		// something I may look into...... could be very custom tbh.. hence maybe not..
	//	String file="testwschat-0.1.war"
	
		// File was previously defined since this a now a more recent feature:
		
		
		
		// This is an example itterating through files:
		// files:{"type":"WAR","name":"target/testmodaldynamix-0.1.war"}
		// where key will be type or name
		// value will by type of file and file name as per jenkins output in the build logs.
		// you may wish to set :
		// jenkins.parseBuildingWorkSpace = false
		//jenkins.parseBuilding = false
		// in config.groovy so that Building files also do not appear in :
		//jenkins.parseDoneCreating = true

		if (params.files) {
			JSONObject files1=JSON.parse(params.files)
				
			files1.each { k,v->
				println "-- FILE_TYPE: $k ||| FILE_NAME: $v"
				
	
			}
		}

		String buildUrl=params.server+params.job+"/ws/target/"+file
//String server=params.server
//String job=params.job

		if (result=='SUCCESS') {

			String appId, appName, appEnv
			def pp=params.customParams
			def apps
			if (pp) {
				def data = JSON.parse(params.customParams)
				appId=data?.appId
				appName=data?.appName
				appEnv=data?.appEnv
			}
			Scripts scripts=Scripts.findByName('deploy')
			if (scripts) {
			def scriptcontent=scripts.script
			scriptcontent=scriptcontent.replace('[URL]',buildUrl)
			println "${scriptcontent}"
			[scriptcontent:scriptcontent, buildUrl:buildUrl,appId:appId, appName:appName, appEnv:appEnv]
			}
		}else{
	
		
		render "Result: ${result} >> No action for that"
		}
	}
	
	
	def parseJenPlugin2() {
		println ":::> ${params} <:::"
		def pp=params.customParams
		def apps
		if (pp) {
			def data = JSON.parse(params.customParams)
			def appId=data?.appId
			def appName=data?.appName
			def appEnv=data?.appEnv
			println "--- YOUR Custom values passed from initial taglib call are:"
			print " AppID: $appId | AppName: $appName | AppEnv: $appEnv"
			render "AppID: $appId | AppName: $appName | AppEnv: $appEnv"
		}
		render "-------------------?"
	}
}
