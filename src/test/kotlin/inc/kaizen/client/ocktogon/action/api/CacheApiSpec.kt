package inc.kaizen.client.ocktogon.action.api

import inc.kaizen.client.ocktogon.action.model.cache.ActionCaches
import inc.kaizen.client.ocktogon.action.model.cache.CacheUsage
import inc.kaizen.client.ocktogon.action.model.cache.CacheUsagePerRepo
import inc.kaizen.client.ocktogon.action.model.cache.RepositoryCacheUsage
import inc.kaizen.client.ocktogon.pull.model.Direction
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class CacheApiSpec : FunSpec({
    val api = mockk<CacheApi>()
    val org = "my-org"
    val owner = "owner"
    val repo = "repo"
    val cacheUsage = mockk<CacheUsage>()
    val cacheUsagePerRepo = mockk<CacheUsagePerRepo>()
    val repoCacheUsage = mockk<RepositoryCacheUsage>()
    val actionCaches = mockk<ActionCaches>()

    test("getOrgCacheUsage returns cache usage") {
        coEvery { api.getOrgCacheUsage(org) } returns cacheUsage
        runBlocking {
            api.getOrgCacheUsage(org) shouldBe cacheUsage
        }
    }

    test("getOrgCacheUsagePerRepositories returns cache usage per repo") {
        coEvery { api.getOrgCacheUsagePerRepositories(org, any(), any()) } returns cacheUsagePerRepo
        runBlocking {
            api.getOrgCacheUsagePerRepositories(org) shouldBe cacheUsagePerRepo
        }
    }

    test("getRepoCacheUsage returns repository cache usage") {
        coEvery { api.getRepoCacheUsage(owner, repo) } returns repoCacheUsage
        runBlocking {
            api.getRepoCacheUsage(owner, repo) shouldBe repoCacheUsage
        }
    }

    test("getRepoCache returns action caches") {
        coEvery {
            api.getRepoCache(owner, repo, any(), any(), any(), any(), any())
        } returns actionCaches
        runBlocking {
            api.getRepoCache(owner, repo, ref = "refs/heads/main", direction = Direction.asc) shouldBe actionCaches
        }
    }

    test("deleteRepoCaches returns action caches") {
        coEvery { api.deleteRepoCaches(owner, repo, "cache-key", "refs/heads/main") } returns actionCaches
        runBlocking {
            api.deleteRepoCaches(owner, repo, "cache-key", "refs/heads/main") shouldBe actionCaches
        }
    }

    test("deleteRepoCache returns unit response") {
        coEvery { api.deleteRepoCache(owner, repo, "1") } returns Response.success(Unit)
        runBlocking {
            api.deleteRepoCache(owner, repo, "1").isSuccessful shouldBe true
        }
    }
})

