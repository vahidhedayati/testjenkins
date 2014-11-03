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
		String file="testwschat-0.1.war"

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
