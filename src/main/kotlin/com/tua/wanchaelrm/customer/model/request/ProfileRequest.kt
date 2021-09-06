package com.tua.wanchaelrm.customer.model.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class ProfileRequest (
    @JsonProperty("first_name")
    val firstName: String? = null,
    @JsonProperty("last_name")
    val lastName: String? = null,
    @JsonProperty("birthDate")
    val birthDate: Date? = null,
    @JsonProperty("email")
    val email: String? = null
)