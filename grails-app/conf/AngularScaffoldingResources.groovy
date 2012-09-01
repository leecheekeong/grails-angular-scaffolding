import grails.util.GrailsUtil

def fileVersion = GrailsUtil.isDevelopmentEnv() ? '1.0.0' : '1.0.0.min'

modules = {
    angular {
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js/angular', file: "angular-${fileVersion}.js"], nominify: true
    }
	'bootstrap' {
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'bootstrap/js', file: "bootstrap.js"], nominify: true	
        resource id: 'css', url: [plugin: 'angular-scaffolding', dir: 'bootstrap/css', file: "bootstrap.css"], nominify: true	
	}
	'ui-common' {
       resource id: 'css', url: [plugin: 'angular-scaffolding', dir: 'css', file: 'ui-common.css']
 	}
    'angular-resource' {
		dependsOn 'angular'
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js/angular', file: "angular-resource-${fileVersion}.js"], nominify: true
    }

    'angular-scaffolding' {
        dependsOn 'jquery', 'angular-resource', 'ui-common', 'bootstrap'
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js', file: 'grails-default.js']
        resource id: 'js', url: [plugin: 'angular-scaffolding', dir: 'js', file: 'scaffolding.js']
        resource id: 'css', url: [plugin: 'angular-scaffolding', dir: 'css', file: 'scaffolding.css']
    }
}