This is a Grails plugin that allows you to use [Angular.js](http://angularjs.org/) based scaffolding.
It is a fork of the grails-angular-scaffolding by Rob Fletcher which I had fixed the ng-generate-*
routines and added some additional CSS files to make it layout nicely.

## Usage

After installing the plugin run:

	grails ng-install-templates

This will install the Angular JS scaffolding templates into your project under `src/templates/scaffolding`. It will also copy some common HTML template files that will be shared by all scaffolded views into `web-app/ng-templates`.

### Static scaffolding

To generate the controller and views for a domain class run:

	grails ng-generate-all _domain class name_

### Dynamic scaffolding

Dynamic scaffolding is only supported for the controller. Currently you will need to generate the views for each domain class.

To generate only the views and use a dynamically scaffolded controller run:

	grails ng-generate-views _domain class name_

## How it works

Instead of the Grails controller rendering a view for each page using a GSP the controller's _index_ action serves up an initial framework page containing the JavaScript resources required by Angular JS. The remaining controller actions simply return _JSON_ data.

Each _'page'_ in the CRUD interface for a particular domain class is accessed using a URL fragment; `#/list`, `#/create`, etc. The page content is rendered by Angular JS using an HTML template and the data to populate the page is retrieved from the controller using an _AJAX_ call.

The HTML templates need to be generated individually for each domain class as they contain the markup needed to represent the properties of that class in a list or a form. However, the JavaScript used for the CRUD interface is the same for all domain classes.

## Customizing

### Using Grails RESTful URL mappings

By default Grails uses a non-RESTful URL scheme where the controller action representing the verb is part of the URL. In the Grails documentation there is a section on [configuring RESTful URL mappings](http://grails.org/doc/latest/guide/theWebLayer.html#mappingHTTP). If you want to use such a URL scheme with this plugin you will need to override the `web-app/js/grails-default.js` file that configures an Angular _$resource_ service that maps to your Grails controllers.

## Limitations

This is an experimental work-in-progress. See the [issues list](https://github.com/robfletcher/grails-angular-scaffolding/issues) for outstanding features.

