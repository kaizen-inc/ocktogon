package inc.kaizen.client.ocktogon.interactions.model

data class InteractionLimit(
    val limit: String? = null,
    val origin: String? = null,
    val expires_at: String? = null
)

data class SetInteractionLimitRequest(
    val limit: String,
    val expiry: String? = null
)

