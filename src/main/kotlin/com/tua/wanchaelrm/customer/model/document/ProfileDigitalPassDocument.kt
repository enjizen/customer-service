package com.tua.wanchaelrm.customer.model.document

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("profile_digital_pass")
data class ProfileDigitalPassDocument (
    @Id
    val id: String? = null,

    @Field("profile_id")
    val profileId: String? = null,

    @Field("digital_pass")
    @JsonProperty("digital_pass")
    val digitalPass: String? = null,

    @Field("digital_number")
    @JsonProperty("digital_number")
    val digitalNumber: Int? = 0
)