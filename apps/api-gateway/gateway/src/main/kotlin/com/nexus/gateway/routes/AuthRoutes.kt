package com.nexus.gateway.routes

import com.nexus.gateway.models.TokenResponse
import com.nexus.gateway.models.UserCredentials
import com.nexus.gateway.models.User
import com.nexus.gateway.services.JWTService
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authRoutes(jwtService: JWTService) {
    route("/auth") {
        post("/login") {
            val credentials = call.receive<UserCredentials>()

            // TODO: Validate credentials against database
            // For now, just a dummy check
            if (credentials.username == "admin" && credentials.password == "admin") {
                val user = User(
                    id = "1",
                    username = credentials.username,
                    password = "", // Don't include password in token
                    roles = listOf("ADMIN")
                )

                val token = jwtService.generateToken(user)
                call.respond(
                    HttpStatusCode.OK,
                    TokenResponse(token = token, expiresIn = 3600)
                )
            } else {
                call.respond(
                    HttpStatusCode.Unauthorized,
                    mapOf("error" to "Invalid credentials")
                )
            }
        }
    }
}