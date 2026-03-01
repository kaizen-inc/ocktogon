package inc.kaizen.client.ocktogon.action.model.cache

data class CacheUsagePerRepo(
    val repository_cache_usages: List<RepositoryCacheUsage>,
    val total_count: Int
)