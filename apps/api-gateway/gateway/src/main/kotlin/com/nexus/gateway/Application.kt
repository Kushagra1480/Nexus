package com.nexus.gateway

import com.nexus.gateway.monitoring.configureMonitoring
import com.nexus.gateway.routes.configureRouting

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureSecurity()
    configureMonitoring()
    configureRouting()
}
