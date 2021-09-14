package com.tua.wanchaelrm.customer.service

import com.tua.wanchaelrm.customer.model.document.ProfileDocument
import com.tua.wanchaelrm.customer.model.request.ProfileRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class ProfileService {
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    fun add(request: ProfileRequest?) : ProfileDocument? {
        request?.let {
            ProfileDocument(
                email = it.email,
                firstName = it.firstName,
                lastName = it.lastName,
                birthDate = it.birthDate
            ).run {
                return mongoTemplate.save(this)
            }
        }
        return null
    }

    fun get(id: String) : ProfileDocument? {
       return  mongoTemplate.findById(id, ProfileDocument::class.java)
    }

    fun getWithEmail(email: String) : ProfileDocument? {
        Query().apply {
            addCriteria(  Criteria().apply {
                and("email").`is`(email)
            })
        }.run {
            return mongoTemplate.findOne( this, ProfileDocument::class.java)
        }




    }
}