package com.tua.wanchaelrm.customer.service

import com.tua.wanchaelrm.customer.model.document.Profile
import com.tua.wanchaelrm.customer.model.request.ProfileRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findOne
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class ProfileService {
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    fun add(request: ProfileRequest) : Profile? {
        Profile(
            email = request.email,
            firstName = request.firstName,
            lastName = request.lastName,
            birthDate = request.birthDate
        ).run {
           return mongoTemplate.save(this)
        }
    }

    fun get(id: String) : Profile? {
       return  mongoTemplate.findById(id, Profile::class.java)
    }

    fun getWithEmail(email: String) : Profile? {
        Query().apply {
            addCriteria(  Criteria().apply {
                and("email").`is`(email)
            })
        }.run {
            return mongoTemplate.findOne( this, Profile::class.java)
        }




    }
}