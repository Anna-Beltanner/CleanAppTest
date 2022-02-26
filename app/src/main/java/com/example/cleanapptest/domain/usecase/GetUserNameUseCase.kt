package com.example.cleanapptest.domain.usecase

import com.example.cleanapptest.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName{

        return UserName(firstName = "Anna", lastName = "Naumova")

    }
}