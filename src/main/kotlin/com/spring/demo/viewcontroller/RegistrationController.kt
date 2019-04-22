package com.spring.demo.viewcontroller

import com.spring.demo.domain.Role
import com.spring.demo.domain.User
import com.spring.demo.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.util.*
import kotlin.collections.HashMap

@Controller
class RegistrationController {
    @Autowired
    private lateinit var userRepo: UserRepo

    @GetMapping("/reg")
    fun registration(): String {
        return "registration"
    }

    @PostMapping("/reg")
    fun addUser(user: User, model: HashMap<String, Any>): String{

        val userFromDb = userRepo.findByUsername(user.username!!)

        when{
            userFromDb != null -> {
                model.put("message", "User exists!")
                return "registration"
            }
        }

        user.active = true
        user.roles = Collections.singleton(Role.USER)
        userRepo.save(user)

        return "redirect:/login"
    }
}