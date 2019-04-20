package com.spring.demo.restcontroller

import org.springframework.web.bind.annotation.*

@RestController
class DemoController {

    @GetMapping(value = arrayOf("/demo"))
    fun demo(@RequestParam(value = "name", defaultValue = "world") name: String): Demo {
        val demo = Demo()
        demo.id = 1
        demo.content = name
        return demo
    }
}