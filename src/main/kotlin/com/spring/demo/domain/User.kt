package com.spring.demo.domain

import javax.persistence.*

@Entity
@Table(name = "usr")
class User() {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null
        var username: String? = null
        var password: String? = null
        var active: Boolean? = null
        @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
        @CollectionTable(name = "user_role", joinColumns = arrayOf(JoinColumn(name = "user_id")))
        @Enumerated(EnumType.STRING)
        var roles: Set<Role>? = null

        constructor(username: String?, password: String?, active: Boolean?, roles: Set<Role>?) : this() {
                this.username = username
                this.password = password
                this.active = active
                this.roles = roles
        }
}
