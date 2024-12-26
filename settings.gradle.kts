rootProject.name = "nexus"


includeBuild("build-logic")
includeProject("apps:analyzer")
includeProject("apps:api-gateway")
includeProject("apps:collector")
includeProject("apps:orchestrator")
includeProject("apps:simulator")