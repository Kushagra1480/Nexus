package com.nexus.gateway.routes

import HealthCheck
import com.nexus.gateway.config.JWTConfig
import com.nexus.gateway.services.JWTService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val jwtConfig = JWTConfig(
        secret = "secret",
        issuer = "nexus-gateway",
        audience = "nexus-clients",
        realm = "Nexus Gateway API"
    )

    val jwtService = JWTService(jwtConfig)

    routing {
        get("/health") {
            val healthCheck = HealthCheck()
            call.respond(healthCheck.check())
        }
        authRoutes(jwtService)
    }
}
