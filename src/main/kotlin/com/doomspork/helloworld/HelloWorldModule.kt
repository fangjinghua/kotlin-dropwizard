package com.doomspork.helloworld

import com.google.inject.Inject
import com.google.inject.Provides
import com.google.inject.name.Named
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule

class HelloWorldModule : DropwizardAwareModule<HelloWorldConfiguration>() {
    override fun configure() {
        bootstrap()
    }

    @Provides
    @Inject
    @Named("customMap")
    fun customMap(configuration: HelloWorldConfiguration) : Map<String, Any>{
        return configuration.customMap
    }
}