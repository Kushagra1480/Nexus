package com.nexus.gateway.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.nexus.gateway.config.JWTConfig
import com.nexus.gateway.models.User
import java.util.*

class JWTService(private val config: JWTConfig) {
    private val algorithm = Algorithm.HMAC256(config.secret)

    fun generateToken(user: User): String {
        return JWT.create()
            .withAudience(config.audience)
            .withIssuer(config.issuer)
            .withClaim("userId", user.id)
            .withClaim("username", user.username)
            .withArrayClaim("roles", user.roles.toTypedArray())
            .withExpiresAt(Date(getExpiration()))
            .sign(algorithm)
    }

    private fun getExpiration() = System.currentTimeMillis() + (config.expirationMinutes* 60 * 1000)
}