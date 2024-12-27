import com.nexus.gateway.monitoring.models.HealthStatus

class HealthCheck {
    fun check(): HealthStatus {
        return HealthStatus(
            status = "UP",
            version = System.getenv("VERSION") ?: "0.1.0"
        )
    }
}