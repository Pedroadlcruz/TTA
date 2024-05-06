package com.example.tta.data

import com.example.tta.models.UserModel
import kotlinx.coroutines.*

class UserRepository(private val ioDispatcher: CoroutineDispatcher) {
    suspend fun getUserInfo(): UserModel {
        withContext(ioDispatcher) { /* ... implementation ... */ }
        return TODO("Provide the return value")
    }
}
