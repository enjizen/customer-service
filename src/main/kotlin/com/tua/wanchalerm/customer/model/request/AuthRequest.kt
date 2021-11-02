package com.tua.wanchalerm.customer.model.request

import com.fasterxml.jackson.annotation.JsonProperty

class AuthRequest(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("digital_pass")
    val digitalPass: String,
)