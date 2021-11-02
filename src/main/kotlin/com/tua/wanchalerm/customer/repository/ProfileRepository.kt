package com.tua.wanchalerm.customer.repository

import com.tua.wanchalerm.customer.model.document.ProfileDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ProfileRepository : MongoRepository<ProfileDocument, String> {
    fun findByEmail(email: String) : ProfileDocument?
}