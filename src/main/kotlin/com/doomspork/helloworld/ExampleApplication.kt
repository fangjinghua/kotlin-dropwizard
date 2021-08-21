package com.doomspork.Example

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import com.doomspork.Example.resources.ExampleResource
import com.doomspork.Example.health.TemplateHealthCheck
import ru.vyarus.dropwizard.guice.GuiceBundle

class ExampleApplication : Application<ExampleConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ExampleApplication().run(*args)
        }
    }

    override fun initialize(bootstrap: Bootstrap<ExampleConfiguration>) {
        // Don't do anything
        bootstrap.addBundle(GuiceBundle.builder<ExampleConfiguration>()
            .enableAutoConfig(javaClass.`package`.name)
            .modules(ExampleModule())
            .build())
    }

    override fun run(config: ExampleConfiguration, env: Environment) {
        val healthCheck = TemplateHealthCheck(config.template)

        env.healthChecks().register("template", healthCheck)
        env.jersey().register(ExampleResource::class)
    }

}