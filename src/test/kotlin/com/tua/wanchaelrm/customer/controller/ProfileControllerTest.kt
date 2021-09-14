package com.tua.wanchaelrm.customer.controller

import com.tua.wanchaelrm.customer.model.document.ProfileDocument
import com.tua.wanchaelrm.customer.model.request.ProfileRequest
import com.tua.wanchaelrm.customer.model.response.GeneralResponse
import com.tua.wanchaelrm.customer.service.ProfileService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

import org.springframework.http.HttpStatus


@ExtendWith(MockitoExtension::class)
internal class ProfileControllerTest {

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
    fun `Get profile`() {
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
    fun `Get profile with email`() {

        val profileDocument = ProfileDocument(id = "0034322", email = "wancham.y@outlook.com")
        `when`(profileService.getWithEmail(anyString())).thenReturn(profileDocument)

        val response = controller.getProfileWithEmail("wancham.y@outlook.com", "wancham.y@outlook.com")
        val body: GeneralResponse<ProfileDocument> = response.body as GeneralResponse<ProfileDocument>
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("success", body.code)
        assertEquals("0034322", body.data?.id)
        assertEquals("wancham.y@outlook.com", body.data?.email)
        verify(profileService, times(1)).getWithEmail(anyString())
    }

    @Test
    fun `Get profile with email not match email from header`() {

        val response = controller.getProfileWithEmail("wancham.y@outlook.com", "tamaya.y@outlook.com")
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        assertNull(response.body)
        verify(profileService, never()).getWithEmail(anyString())
    }
}