import testjenkins.Scripts

class BootStrap {

    def init = { servletContext ->
		def script="""
echo /etc/init.d/tomcat stop
wget [URL] -O /tmp/deploy.war
echo /etc/init.d/tomcat start
"""
		Scripts.findOrSaveWhere(name:'deploy', script: script)
    }
    def destroy = {
    }
}
