package com.spring.demo.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Message() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Int? = null

    private var text: String? = null
    private var tag: String? = null

    constructor(text: String, tag: String): this(){
        this.text = text
        this.tag = tag
    }
}