package inc.kaizen.client.ocktogon.page.model

data class PageDeploymentRequest(
    val artifact_id: String? = null,
    val artifact_url: String? = null,
    val environment: String = "github-pages",
    val pages_build_version: String = "GITHUB_SHA",
    val oidc_token: String
)