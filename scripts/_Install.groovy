//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//
Ant.property(environment: "env")
grailsHome = Ant.antProject.properties."env.GRAILS_HOME"
def scaffoldingDir = "/src/templates/scaffolding"
def ngTemplateDir = "/web-app/ng-templates"

Ant.sequential {
  event("StatusUpdate", ["Copying files into the application's src/template/scaffolding"])

  mkdir(dir: "${basedir}${scaffoldingDir}")
  copy(todir: "${basedir}${scaffoldingDir}") {
    fileset(dir: "${pluginBasedir}${scaffoldingDir}") {
		include(name: "*.groovy")
		include(name: "*.html")
		include(name: "*.gsp")
    }
  }
  mkdir(dir: "${basedir}${ngTemplateDir}")
  copy(todir: "${basedir}${ngTemplateDir}") {
    fileset(dir: "${pluginBasedir}${ngTemplateDir}") {
		include(name: "*.html")
    }
  }
}
event("StatusFinal", ["\nDone. All files has been copied into the application.\n"])
