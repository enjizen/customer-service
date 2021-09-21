package com.tua.wanchaelrm.customer.controller

import com.tua.wanchaelrm.customer.annotation.Slf4j.Companion.log
import com.tua.wanchaelrm.customer.constant.HeaderKeyConstant
import com.tua.wanchaelrm.customer.constant.ResponseConstant
import com.tua.wanchaelrm.customer.model.request.ProfileRequest
import com.tua.wanchaelrm.customer.model.response.GeneralResponse
import com.tua.wanchaelrm.customer.service.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProfileController {

    @Autowired
    private lateinit var profileService: ProfileService

    @PostMapping("/v1/profiles")
    fun addProfile(@RequestBody request: ProfileRequest): ResponseEntity<*> {
        log.info ("Add customer profile")
        val response = profileService.add(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/v1/profiles/{id}")
    fun getProfile(@PathVariable("id") id: String): ResponseEntity<*> {
        log.info ("Get profile with id $id")
        val response = profileService.get(id)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/v1/profile")
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