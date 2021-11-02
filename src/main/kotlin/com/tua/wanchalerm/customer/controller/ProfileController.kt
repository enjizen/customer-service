package com.tua.wanchalerm.customer.controller

import com.tua.wanchalerm.customer.annotation.Slf4j.Companion.log
import com.tua.wanchalerm.customer.constant.HeaderKeyConstant
import com.tua.wanchalerm.customer.constant.ResponseConstant
import com.tua.wanchalerm.customer.model.request.ProfileRequest
import com.tua.wanchalerm.customer.model.response.GeneralResponse
import com.tua.wanchalerm.customer.service.ProfileService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProfileController(private var profileService: ProfileService) {


    @PostMapping("/v1/profiles")
    fun addProfile(@RequestBody request: ProfileRequest): ResponseEntity<*> {
        log.info ("Add customer profile")
        val response = profileService.add(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/v1/profiles/{id}")
    fun getProfile(@PathVariable("id") id: String): ResponseEntity<*> {
        log.info ("Get profile with id {}", id)
        val response = profileService.get(id)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/v1/profiles")
    fun getProfileWithEmail(@RequestHeader(HeaderKeyConstant.X_EMAIL) emailHeader: String, @RequestParam("email") email: String): ResponseEntity<*> {
        log.info ("Get profile with email {}", email )

        if (emailHeader != email) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
        val profile = profileService.getWithEmail(email)
        val response = GeneralResponse(code = ResponseConstant.SUCCESS, data = profile)

        return ResponseEntity.ok(response)
    }
}