package com.tua.wanchaelrm.customer.controller

import com.tua.wanchaelrm.customer.model.document.ProfileDocument
import com.tua.wanchaelrm.customer.model.request.ProfileRequest
import com.tua.wanchaelrm.customer.service.ProfileService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

import org.springframework.http.HttpStatus


@ExtendWith(MockitoExtension::class)
internal class ProfileDocumentControllerTest {

    @InjectMocks
    private lateinit var controller: ProfileController

    @Mock
    private lateinit var profileService: ProfileService

    @Test
    fun `add profile`() {
        val profileDocument = ProfileDocument(id = "0034322", email = "wancham.y@outlook.com")

        `when`(profileService.add(any())).thenReturn(profileDocument)

        val response = controller.addProfile(ProfileRequest())
        val body: ProfileDocument = response.body as ProfileDocument
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("0034322", body.id)
        assertEquals("wancham.y@outlook.com", body.email)

        verify(profileService, times(1)).add(any())
    }

    @Test
    fun getProfile() {
        val profileDocument = ProfileDocument(id = "0034322", email = "wancham.y@outlook.com")

        `when`(profileService.get(anyString())).thenReturn(profileDocument)

        val response = controller.getProfile("0034322")
        val body: ProfileDocument = response.body as ProfileDocument
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("0034322", body.id)
        assertEquals("wancham.y@outlook.com", body.email)
        verify(profileService, times(1)).get(anyString())
    }

    @Test
    fun getProfileWithEmail() {
        val profileDocument = ProfileDocument(id = "0034322", email = "wancham.y@outlook.com")

        `when`(profileService.getWithEmail(anyString())).thenReturn(profileDocument)

        val response = controller.getProfileWithEmail("wancham.y@outlook.com")
        val body: ProfileDocument = response.body as ProfileDocument
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("0034322", body.id)
        assertEquals("wancham.y@outlook.com", body.email)
        verify(profileService, times(1)).getWithEmail(anyString())
    }
}