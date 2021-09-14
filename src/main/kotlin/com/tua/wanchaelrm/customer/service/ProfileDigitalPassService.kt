package com.tua.wanchaelrm.customer.service

import com.tua.wanchaelrm.customer.model.document.ProfileDigitalPassDocument
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class ProfileDigitalPassService {
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    fun add() : ProfileDigitalPassDocument? {
        return null
    }
}