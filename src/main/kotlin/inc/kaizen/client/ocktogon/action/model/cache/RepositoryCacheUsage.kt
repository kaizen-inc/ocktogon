package inc.kaizen.client.ocktogon.action.model.cache

data class RepositoryCacheUsage(
    val active_caches_count: Int,
    val active_caches_size_in_bytes: Int,
    val full_name: String
)