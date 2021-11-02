package com.tua.wanchalerm.customer.service

import com.tua.wanchalerm.customer.client.AuthClient
import com.tua.wanchalerm.customer.model.document.ProfileDocument
import com.tua.wanchalerm.customer.model.request.AuthRequest
import com.tua.wanchalerm.customer.model.request.ProfileRequest
import com.tua.wanchalerm.customer.repository.ProfileRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class ProfileService(
    private var authClient: AuthClient,
    private var profileRepository: ProfileRepository
) {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = [Exception::class])
    fun add(request: ProfileRequest): ProfileDocument? {
        val profileDocument: ProfileDocument = request.let {
            ProfileDocument(
                email = it.email,
                mobileNumber = it.mobileNumber,
                firstName = it.firstName,
                lastName = it.lastName,
                birthDate = it.birthDate
            )
        }

        val profile = profileRepository.save(profileDocument)
        val authRequest = AuthRequest(id = profile.id!!, request.digitalPass)
        authClient.addProfileDigitalPass(authRequest)
        return profile
    }

    fun get(id: String): ProfileDocument? {
        return profileRepository.findById(id).orElse(null)

    }

    fun getWithEmail(email: String): ProfileDocument? {
        return profileRepository.findByEmail(email = email)
    }
}