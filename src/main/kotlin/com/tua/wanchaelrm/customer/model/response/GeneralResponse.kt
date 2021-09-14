package com.tua.wanchaelrm.customer.model.response

import com.fasterxml.jackson.annotation.JsonProperty

 data class GeneralResponse<T>(
    @JsonProperty("code")
    val code: String,

    @JsonProperty("data")
    val data: T? = null
)
