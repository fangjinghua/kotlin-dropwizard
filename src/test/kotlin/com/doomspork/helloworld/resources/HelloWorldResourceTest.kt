package com.doomspork.helloworld.resources

import com.doomspork.helloworld.HelloWorldConfiguration
import com.doomspork.helloworld.core.Saying
import com.google.common.base.Optional
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class HelloWorldResourceTest {
    private var configuration = HelloWorldConfiguration()
    @Before
    fun beforeEach() {
        configuration.template = "Hello, %s!"
        configuration.defaultName = "Stranger"
        configuration.customMap = mapOf(Pair("first", "later!"))
    }

    @Test
    fun testSayHello() {


        run {
            val resource=HelloWorldResource(configuration)
            val expected= Saying(id = 1, content = "Hello, later!!");
            assertEquals(resource.sayHello(Optional.absent()), expected)
        }
        run {
            val resource=HelloWorldResource(configuration)
            val expected= Saying(id = 1, content = "Hello, TEST!");
            assertEquals(resource.sayHello(Optional.of("TEST")), expected)
        }
    }


}