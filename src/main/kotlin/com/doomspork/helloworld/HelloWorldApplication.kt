package com.doomspork.helloworld

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import com.doomspork.helloworld.resources.HelloWorldResource
import com.doomspork.helloworld.health.TemplateHealthCheck
import ru.vyarus.dropwizard.guice.GuiceBundle

class HelloWorldApplication : Application<HelloWorldConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            HelloWorldApplication().run(*args)
        }
    }

    override fun initialize(bootstrap: Bootstrap<HelloWorldConfiguration>) {
        // Don't do anything
        bootstrap.addBundle(GuiceBundle.builder<HelloWorldConfiguration>()
            .enableAutoConfig(javaClass.`package`.name)
            .modules(HelloWorldModule())
            .build())
    }

    override fun run(config: HelloWorldConfiguration, env: Environment) {
        val healthCheck = TemplateHealthCheck(config.template)

        env.healthChecks().register("template", healthCheck)
        env.jersey().register(HelloWorldResource::class)
    }

}