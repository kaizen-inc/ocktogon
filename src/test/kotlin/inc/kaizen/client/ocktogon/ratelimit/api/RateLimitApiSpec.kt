package inc.kaizen.client.ocktogon.ratelimit.api

import inc.kaizen.client.ratelimit.model.RateLimit
import inc.kaizen.client.ratelimit.model.RateLimitOverview
import inc.kaizen.client.ratelimit.model.RateLimitResources
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class RateLimitApiSpec : FunSpec({
    val api = mockk<RateLimitApi>()
    val core = RateLimit(limit = 5000, used = 100, remaining = 4900, reset = 1735689600L)
    val resources = RateLimitResources(core = core)
    val overview = RateLimitOverview(resources = resources, rate = core)

    test("getRateLimit returns overview") {
        coEvery { api.getRateLimit() } returns overview
        runBlocking { api.getRateLimit() shouldBe overview }
    }
})

