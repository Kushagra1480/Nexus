package com.nexus.gateway.routes

import HealthCheck
import com.nexus.gateway.config.AppConfig
import com.nexus.gateway.config.JWTConfig
import com.nexus.gateway.services.JWTService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val appConfig = AppConfig(environment.config)
    val jwtService = JWTService(appConfig.jwt)

    routing {
        get("/health") {
            val healthCheck = HealthCheck()
            call.respond(healthCheck.check())
        }
        authRoutes(jwtService)
    }
}
