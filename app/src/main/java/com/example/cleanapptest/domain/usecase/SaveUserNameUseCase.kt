package com.example.cleanapptest.domain.usecase

import com.example.cleanapptest.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean {
        return !param.name.isEmpty()
        //return true if param.name.!isEmpty
        //если имя не пустое, возвращаем true

    }
}