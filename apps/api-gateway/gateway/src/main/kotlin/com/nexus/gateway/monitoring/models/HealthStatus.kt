package com.nexus.gateway.monitoring.models

import kotlinx.serialization.Serializable

@Serializable
data class HealthStatus (
    val status: String,
    val version: String,
    val timestamp: Long = System.currentTimeMillis()
)
