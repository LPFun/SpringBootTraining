package com.spring.demo.repository

import com.spring.demo.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo: JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}