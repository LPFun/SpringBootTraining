package com.spring.demo.repository

import com.spring.demo.domain.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepo : CrudRepository<Message, Long> {
    fun findByTag(tag: String): List<Message>
}