package com.nexus.gateway.config

import io.ktor.server.config.*

class AppConfig (private val config: ApplicationConfig) {
    val jwt = JWTConfig(
        secret = config.property("ktor.jwt.secret").getString(),
        issuer = config.property("ktor.jwt.issuer").getString(),
        audience = config.property("ktor.jwt.audience").getString(),
        realm = config.property("ktor.jwt.realm").getString(),
    )
}