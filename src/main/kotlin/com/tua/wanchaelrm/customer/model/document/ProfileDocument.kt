package com.tua.wanchaelrm.customer.model.document

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document("profile")
data class ProfileDocument(
    @Id
    val id: String? = null,

    @Field("email")
    @Indexed(unique = true)
    @JsonProperty("email")
    val email: String? = null,

    @Field("first_name")
    @JsonProperty("first_name")
    val firstName: String? = null,

    @Field("last_name")
    @JsonProperty("last_name")
    val lastName: String? = null,

    @Field("birthDate")
    @JsonProperty("birthDate")
    val birthDate: Date? = null
)
