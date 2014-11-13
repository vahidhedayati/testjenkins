// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j.main = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

jenkins.processurl=""
jenkins.wsprocessname="Deploy"
jenkins.wsprocessurl="http://localhost:8080/testjenkins/test/jsshconnect"

jenkins.autosubmit="yes"

jenkins.showhistory="yes"


jenkins.sendtoJira='yes'

jenkins.jiraServer='http://localhost:8181/'
jenkins.jiraUser='jira'
jenkins.jiraPass='jira'

jenkins.jira.AccessUri="/browse/"


/*
 * There are various send types :
 * comment -- adds the summary output as a comment to valid jira ticket
 * customfield -- adds the summary output to provided customfield ID - please note customfield must have correct screen perms for it to work
 * updatecustomfield -- gets current input if different to new input adds them together to customfield
 * description -- updates ticket description with the summary
 * comdesc -- updates ticket description and adds a comment both containing the summary
 */
jenkins.jiraSendType='comment'
// If you have defined working option customfield then define the customfield id for this configuration item:
//jenkins.customField='10010' // the id of your customfield


// Auto submit wsprocess url ?
jenkins.autosubmit = "yes"


// This is an important option to enable
// With this enabled - after a build has completed and has a result
// So long as your jira details are correct
// and the ticket convention is as below appears in changes logs...
// Then this enabled with the jira info below should mean your build history should appear
// under all logged tickets under changes screen of a given build id.
jenkins.showsummary = "yes"





/*
* This is the url usually to access the ticket for viewing - used to test if ticket is valid
* if not defined will default to /browse/
*/
jenkins.jira.AccessUri = "/browse/"


/*
 * There are various send types :
 * comment -- adds the summary output as a comment to valid jira ticket
 * customfield -- adds the summary output to provided customfield ID - please note customfield must have correct screen perms for it to work
 * updatecustomfield -- gets current input if different to new input adds them together to customfield
 * description -- updates ticket description with the summary
 * comdesc -- updates ticket description and adds a comment both containing the summary
 */
jenkins.jiraSendType = 'customfield'
// If you have defined working option customfield then define the customfield id for this configuration item:
jenkins.customField = '12330' // the id of your customfield


/*
* API Api Info - send this as part of summary?
*/
jenkins.sendApi = true  // true/false - by default false
// SendApi - sub fields:
/* API ChangeSet - send this as part of summary?*/
jenkins.sendChangeSet = true  // true/false - by default false
/*API culprits - send this as part of summary?*/
jenkins.sendCulprits = true  // true/false - by default false
/*API full display name - send this as part of summary?*/
jenkins.sendFdn = true  // true/false - by default false
/*API Build Id - send this as part of summary?*/
jenkins.sendBuildId = true  // true/false - by default false
/*API Build UserID/Name - send this as part of summary?*/
jenkins.sendBuildUser = true  // true/false - by default false

/*
* Jenkins BuildID Change Logs - send this as part of summary?
*/
jenkins.sendChanges = true  // true/false - by default false

/*
* Jenkins BuildID Specific parse Info - send this as part of summary?
*/
jenkins.sendParseConsole = true  // true/false - by default false
/*LogParser Look for Building Work space ? send this as part of summary?*/
jenkins.parseBuildingWorkSpace = true  // true/false - by default false
/*LogParser Look for Building ? send this as part of summary?*/
jenkins.parseBuilding = true  // true/false - by default false
/*LogParser Look for Done Creating? send this as part of summary?*/
jenkins.parseDoneCreating = true  // true/false - by default false
/*LogParser Look for Last valid trans ? send this as part of summary?*/
jenkins.parseLastTrans = true  // true/false - by default false


/* Buttons on websocket page :
* set these as you see here change to no if you wish
* not for them to appear on the webpage.
* you can override these values from within either taglib call too
*/
jenkins.summaryViewButtons = "yes"
jenkins.summaryFileButton = "yes"
jenkins.summaryChangesButton = "yes"

jenkins.jiraButtons = "yes"
jenkins.jiraOverwriteButton = "yes"
jenkins.jiraAppendButton = "yes"
jenkins.jiraCommentButton = "yes"


jssh.USER = "mx1"
jssh.PASS = ""
jssh.KEY="/home/mx1/.ssh/id_rsa"
jssh.timeout="0"
jssh.disable.login="NO"
jssh.NEWCONNPERTRANS='NO'
jssh.hideSessionCtrl="NO"
jssh.hideAuthBlock='NO'
jssh.hideConsoleMenu="NO"
jssh.hideSendBlock="NO"
jssh.hidePauseControl="NO"
jssh.hideWhatsRunning="NO"
jssh.hideDiscoButton="NO"
jssh.hideNewShellButton="NO"
