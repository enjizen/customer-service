package com.tua.wanchaelrm.customer.controller

import com.tua.wanchaelrm.customer.model.document.Profile
import com.tua.wanchaelrm.customer.model.request.ProfileRequest
import com.tua.wanchaelrm.customer.service.ProfileService
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import org.mockito.Mockito.`when`
import org.mockito.Mockito.any
import org.springframework.http.HttpStatus


@RunWith(MockitoJUnitRunner::class)
 class ProfileControllerTest {

    @InjectMocks
    private lateinit var controller: ProfileController

    @Mock
    private lateinit var profileService: ProfileService

    @Test
    fun `add profile`() {
        val profile = Profile(id = "0034322", email = "wancham.y@outlook.com")
        
        `when`(profileService.add(any())).thenReturn(profile)

        val response = controller.addProfile(ProfileRequest())
        val body: Profile = response.body as Profile
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("0034322", body.id)
        assertEquals("wancham.y@outlook.com", body.email)
    }

    @Test
    fun getProfile() {
    }

    @Test
    fun getProfileWithEmail() {
    }
}