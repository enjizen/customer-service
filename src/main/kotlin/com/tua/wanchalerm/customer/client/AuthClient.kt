package com.tua.wanchalerm.customer.client

import com.tua.wanchalerm.customer.model.request.AuthRequest
import com.tua.wanchalerm.customer.model.response.GeneralResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("auth-service")
interface AuthClient {
    @PostMapping("auth/v1/authentications/profiles")
    fun addProfileDigitalPass(@RequestBody authRequest: AuthRequest) : GeneralResponse<*>
}