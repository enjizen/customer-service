package com.tua.wanchalerm.customer.model.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.validation.constraints.NotBlank

class ProfileRequest (
    @JsonProperty("first_name")
    @NotBlank
    val firstName: String,
    @JsonProperty("last_name")
    @NotBlank
    val lastName: String,

    @JsonProperty("birth_date")
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val birthDate: Date,

    @JsonProperty("email")
    @NotBlank
    val email: String,
    @JsonProperty("mobile_number")
    @NotBlank
    val mobileNumber: String,
    @JsonProperty("digital_pass")
    @NotBlank
    val digitalPass: String,
)