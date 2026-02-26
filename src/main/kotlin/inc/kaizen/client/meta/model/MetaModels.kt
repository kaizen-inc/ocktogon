package inc.kaizen.client.meta.model

data class GitHubMeta(
    val verifiable_password_authentication: Boolean? = null,
    val ssh_key_fingerprints: Map<String, String>? = null,
    val ssh_keys: List<String>? = null,
    val hooks: List<String>? = null,
    val web: List<String>? = null,
    val api: List<String>? = null,
    val git: List<String>? = null,
    val packages: List<String>? = null,
    val pages: List<String>? = null,
    val importer: List<String>? = null,
    val actions: List<String>? = null,
    val dependabot: List<String>? = null,
    val domains: GitHubMetaDomains? = null
)

data class GitHubMetaDomains(
    val website: List<String>? = null,
    val codespaces: List<String>? = null,
    val copilot: List<String>? = null,
    val packages: List<String>? = null,
    val actions: List<String>? = null
)

