package inc.kaizen.client.action.model.cache

data class CacheUsagePerRepo(
    val repository_cache_usages: List<RepositoryCacheUsage>,
    val total_count: Int
)