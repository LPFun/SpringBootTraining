package com.spring.demo.viewcontroller

import com.spring.demo.domain.Message
import com.spring.demo.repository.MessageRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ListController {

    @Autowired
    private lateinit var messageRepo: MessageRepo

    @GetMapping("/main")
    fun getList(model: HashMap<String, Any>): String {
        showList(model)
        return "list"
    }

    private fun showList(model: HashMap<String, Any>) {
        val messages: Iterable<Message> = messageRepo.findAll()
        model.put("messages", messages)
    }

    @PostMapping("/main")
    fun add(@RequestParam text: String, @RequestParam tag: String, model: HashMap<String, Any>): String {
        val message = Message(text, tag)
        messageRepo.save(message)
        showList(model)
        return "list"
    }

    @PostMapping("filter")
    fun filter(@RequestParam filter: String, model: HashMap<String, Any>): String {
        val messages: Iterable<Message>
        when {
            !filter.isEmpty() || filter == null -> messages = messageRepo.findByTag(filter)
            else -> messages = messageRepo.findAll()
        }
        model.put("messages", messages)
        return "list"
    }
}