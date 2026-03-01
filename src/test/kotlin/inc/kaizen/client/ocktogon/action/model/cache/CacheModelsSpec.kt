package inc.kaizen.client.ocktogon.action.model.cache

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CacheModelsSpec : StringSpec({

    "SortCache enum should have correct values" {
        SortCache.values().size shouldBe 3
        SortCache.created_at.name shouldBe "created_at"
        SortCache.last_accessed_at.name shouldBe "last_accessed_at"
        SortCache.size_in_bytes.name shouldBe "size_in_bytes"
    }

    "ActionCache should instantiate and compare correctly" {
        val cache = ActionCache(
            created_at = "2025-01-01T00:00:00Z",
            id = 1,
            key = "cache-key",
            last_accessed_at = "2025-06-01T00:00:00Z",
            ref = "refs/heads/main",
            size_in_bytes = 2048,
            version = "v1"
        )
        cache.id shouldBe 1
        cache.key shouldBe "cache-key"
        cache.size_in_bytes shouldBe 2048
    }

    "ActionCaches should instantiate and compare correctly" {
        val cache = ActionCache("2025-01-01T00:00:00Z", 1, "key", "2025-06-01T00:00:00Z", "refs/heads/main", 100, "v1")
        val caches = ActionCaches(actions_caches = listOf(cache), total_count = 1)
        caches.total_count shouldBe 1
        caches.actions_caches.size shouldBe 1
        caches.actions_caches[0] shouldBe cache
    }

    "CacheUsage should instantiate and compare correctly" {
        val usage = CacheUsage(
            total_active_caches_count = 5,
            total_active_caches_size_in_bytes = 10240
        )
        usage.total_active_caches_count shouldBe 5
        usage.total_active_caches_size_in_bytes shouldBe 10240
    }

    "RepositoryCacheUsage should instantiate and compare correctly" {
        val repoUsage = RepositoryCacheUsage(
            active_caches_count = 3,
            active_caches_size_in_bytes = 5120,
            full_name = "owner/repo"
        )
        repoUsage.active_caches_count shouldBe 3
        repoUsage.full_name shouldBe "owner/repo"
    }

    "CacheUsagePerRepo should instantiate and compare correctly" {
        val repoUsage = RepositoryCacheUsage(1, 100, "owner/repo")
        val usagePerRepo = CacheUsagePerRepo(
            repository_cache_usages = listOf(repoUsage),
            total_count = 1
        )
        usagePerRepo.total_count shouldBe 1
        usagePerRepo.repository_cache_usages.size shouldBe 1
        usagePerRepo.repository_cache_usages[0] shouldBe repoUsage
    }
})

