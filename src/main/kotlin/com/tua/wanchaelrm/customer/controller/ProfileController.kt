package com.tua.wanchaelrm.customer.controller

import com.tua.wanchaelrm.customer.model.request.ProfileRequest
import com.tua.wanchaelrm.customer.service.ProfileService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProfileController {

    private val logger = KotlinLogging.logger {}

    @Autowired
    private lateinit var profileService: ProfileService

    @PostMapping("/v1/profiles")
    fun addProfile(@RequestBody request: ProfileRequest): ResponseEntity<*> {
        logger.info { "Add customer profile" }
        val response = profileService.add(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/v1/profiles/{id}")
    fun getProfile(@PathVariable("id") id: String): ResponseEntity<*> {
        logger.info { "Get profile with id $id" }
        val response = profileService.get(id)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/v1/profile")
    fun getProfileWithEmail(@RequestParam("email") email: String): ResponseEntity<*> {
        logger.info { "Get profile with id $email" }
        val profile = profileService.getWithEmail(email)
        return ResponseEntity.ok(profile)
    }
}