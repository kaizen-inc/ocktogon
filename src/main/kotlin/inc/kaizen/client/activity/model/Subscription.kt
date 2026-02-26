package inc.kaizen.client.activity.model

data class RepoSubscription(
    val subscribed: Boolean? = null,
    val ignored: Boolean? = null,
    val reason: String? = null,
    val created_at: String? = null,
    val url: String? = null,
    val repository_url: String? = null
)

data class SetRepoSubscriptionRequest(
    val subscribed: Boolean? = null,
    val ignored: Boolean? = null
)

