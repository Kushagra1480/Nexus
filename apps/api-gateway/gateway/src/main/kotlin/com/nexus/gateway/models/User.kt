package com.nexus.gateway.models

import kotlinx.serialization.Serializable

@Serializable
data class User (
    val id: String,
    val username: String,
    val password: String,
    val roles: List<String> = listOf(),
)

@Serializable
data class UserCredentials(
    val username: String,
    val password: String,
)

@Serializable
data class TokenResponse(
    val token: String,
    val expiresIn: Long
)