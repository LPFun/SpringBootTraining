package com.spring.demo.viewcontroller

import com.spring.demo.repository.MessageRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ViewController {

    @Autowired
    private lateinit var messageRepo: MessageRepo

    @GetMapping("/view")
    fun getView(@RequestParam(name = "name", required = false, defaultValue = "world") name: String): String {
        return "view"
    }
}