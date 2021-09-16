package com.tua.wanchaelrm.customer.service

import com.tua.wanchaelrm.customer.model.document.ProfileDocument
import com.tua.wanchaelrm.customer.model.request.ProfileRequest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

@ExtendWith(MockitoExtension::class)
internal class ProfileServiceTest {

    @InjectMocks
    private lateinit var profileService: ProfileService

    @Mock
    private lateinit var mongoTemplate: MongoTemplate

    private val id = "445466900636"
    private val response =
        ProfileDocument(id = id, firstName = "wanchalerm", lastName = "yuphasuk", email = "wanchalerm.y@outlook.com")

    @Test
    fun add() {
        val request = ProfileRequest(firstName = "wanchalerm", lastName = "yuphasuk")

        `when`(mongoTemplate.save(any(ProfileDocument::class.java))).thenReturn(response)

        val result = profileService.add(request)
        assertEquals("445466900636", result?.id)
        assertEquals("wanchalerm", result?.firstName)
        assertEquals("wanchalerm.y@outlook.com", result?.email)
    }

    @Test
    fun `add request null`() {
        val result = profileService.add(null)
        assertNull(result)
        verify(mongoTemplate, never()).save(any(ProfileDocument::class.java))
    }

    @Test
    fun get() {
        `when`(mongoTemplate.findById(id, ProfileDocument::class.java)).thenReturn(response)

        val result = profileService.get(id)
        assertEquals("445466900636", result?.id)
        assertEquals("wanchalerm", result?.firstName)
        assertEquals("wanchalerm.y@outlook.com", result?.email)
    }

    @Test
    fun getWithEmail() {
       val query = Query().apply {
            addCriteria(Criteria().apply {
                and("email").`is`("wanchalerm.y@outlook.com")
            })
        }

        `when`(mongoTemplate.findOne(query, ProfileDocument::class.java)).thenReturn(response)

        val result = profileService.getWithEmail("wanchalerm.y@outlook.com")
        assertEquals("445466900636", result?.id)
        assertEquals("wanchalerm", result?.firstName)
        assertEquals("wanchalerm.y@outlook.com", result?.email)
    }
}