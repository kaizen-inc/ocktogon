package inc.kaizen.client.ocktogon.common

data class HRef(val href: String? = null)

data class PullRequestLinks(
    val self: HRef? = null,
    val html: HRef? = null,
    val issue: HRef? = null,
    val comments: HRef? = null,
    val review_comments: HRef? = null,
    val review_comment: HRef? = null,
    val commits: HRef? = null,
    val statuses: HRef? = null
)

data class ReviewCommentLinks(
    val self: HRef? = null,
    val html: HRef? = null,
    val pull_request: HRef? = null
)

data class Actor(
    val date: String? = null,
    val email: String? = null,
    val name: String? = null
)

data class Verification(
    val verified: Boolean? = null,
    val reason: String? = null,
    val signature: Any? = null,
    val payload: Any? = null
)

data class SimpleCommit(
    val sha: String? = null,
    val url: String? = null
)

data class PagedList<T>(
    val total_count: Int = 0,
    val items: List<T> = emptyList()
)

data class Hook(
    val type: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val active: Boolean? = null,
    val events: List<String>? = null,
    val config: HookConfig? = null,
    val updated_at: String? = null,
    val created_at: String? = null,
    val url: String? = null,
    val test_url: String? = null,
    val ping_url: String? = null,
    val deliveries_url: String? = null,
    val last_response: HookLastResponse? = null
)

data class HookConfig(
    val email: String? = null,
    val password: String? = null,
    val room: String? = null,
    val subdomain: String? = null,
    val url: String? = null,
    val insecure_ssl: Any? = null,
    val content_type: String? = null,
    val digest: String? = null,
    val secret: String? = null,
    val token: String? = null
)

data class HookLastResponse(
    val code: Int? = null,
    val status: String? = null,
    val message: String? = null
)

data class HookDelivery(
    val id: Int? = null,
    val guid: String? = null,
    val delivered_at: String? = null,
    val redelivery: Boolean? = null,
    val duration: Double? = null,
    val status: String? = null,
    val status_code: Int? = null,
    val event: String? = null,
    val action: String? = null,
    val installation_id: Int? = null,
    val repository_id: Int? = null,
    val url: String? = null,
    val request: HookDeliveryRequest? = null,
    val response: HookDeliveryResponse? = null
)

data class HookDeliveryRequest(
    val headers: Map<String, String>? = null,
    val payload: Any? = null
)

data class HookDeliveryResponse(
    val headers: Map<String, String>? = null,
    val payload: String? = null
)

data class CreateHookRequest(
    val name: String = "web",
    val config: HookConfig,
    val events: List<String>? = null,
    val active: Boolean? = null
)

data class UpdateHookRequest(
    val config: HookConfig? = null,
    val events: List<String>? = null,
    val add_events: List<String>? = null,
    val remove_events: List<String>? = null,
    val active: Boolean? = null
)

