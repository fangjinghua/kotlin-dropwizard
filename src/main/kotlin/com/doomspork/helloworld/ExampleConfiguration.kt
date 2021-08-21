package com.doomspork.Example

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

public class ExampleConfiguration() : Configuration() {
    @JsonProperty("template")
    public var template: String=""

    @JsonProperty("defaultName")
    public var defaultName: String="Stranger"

    @JsonProperty("customMap")
    public var customMap: Map<String, Any> = emptyMap()
}
