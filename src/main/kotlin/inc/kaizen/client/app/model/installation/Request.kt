package inc.kaizen.client.app.model.installation

data class InstallationAccessTokenRequest(
    val repositories: List<String>? = null,
    val repository_ids: List<String>? = null,
    val permissions: Permissions? = null
)

data class Permissions(
    val actions: String? = null,
    val administration: String? = null,
    val checks: String? = null,
    val contents: String? = null,
    val deployments: String? = null,
    val issues: String? = null,
    val metadata: String? = null,
    val packages: String? = null,
    val pages: String? = null,
    val pull_requests: String? = null,
    val repository_hooks: String? = null,
    val repository_projects: String? = null,
    val secrets: String? = null,
    val security_events: String? = null,
    val single_file: String? = null,
    val statuses: String? = null,
    val vulnerability_alerts: String? = null,
    val workflows: String? = null,
    val members: String? = null,
    val organization_administration: String? = null,
    val organization_hooks: String? = null,
    val organization_packages: String? = null,
    val organization_projects: String? = null,
    val organization_secrets: String? = null,
    val organization_self_hosted_runners: String? = null,
    val organization_user_blocking: String? = null,
    val team_discussions: String? = null
)