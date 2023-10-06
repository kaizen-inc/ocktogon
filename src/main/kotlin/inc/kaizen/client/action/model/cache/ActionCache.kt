package inc.kaizen.client.action.model.cache

data class ActionCache(
    val created_at: String,
    val id: Int,
    val key: String,
    val last_accessed_at: String,
    val ref: String,
    val size_in_bytes: Int,
    val version: String
)