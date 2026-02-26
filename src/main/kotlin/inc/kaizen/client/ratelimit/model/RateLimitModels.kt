package inc.kaizen.client.ratelimit.model

data class RateLimitOverview(
    val resources: RateLimitResources? = null,
    val rate: RateLimit? = null
)

data class RateLimitResources(
    val core: RateLimit? = null,
    val search: RateLimit? = null,
    val graphql: RateLimit? = null,
    val integration_manifest: RateLimit? = null,
    val source_import: RateLimit? = null,
    val code_scanning_upload: RateLimit? = null,
    val actions_runner_registration: RateLimit? = null,
    val scim: RateLimit? = null,
    val dependency_snapshots: RateLimit? = null,
    val audit_log: RateLimit? = null,
    val audit_log_streaming: RateLimit? = null,
    val code_search: RateLimit? = null
)

data class RateLimit(
    val limit: Int? = null,
    val used: Int? = null,
    val remaining: Int? = null,
    val reset: Long? = null
)

