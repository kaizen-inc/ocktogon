package inc.kaizen.client.ocktogon.ratelimit.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RateLimitModelsSpec : StringSpec({

    "RateLimit should instantiate and compare correctly" {
        val rateLimit = RateLimit(limit = 5000, used = 100, remaining = 4900, reset = 1735689600L)
        rateLimit.limit shouldBe 5000
        rateLimit.remaining shouldBe 4900
        rateLimit.reset shouldBe 1735689600L
    }

    "RateLimit should instantiate with null defaults" {
        val rateLimit = RateLimit()
        rateLimit.limit shouldBe null
        rateLimit.remaining shouldBe null
    }

    "RateLimitResources should instantiate and compare correctly" {
        val core = RateLimit(limit = 5000, used = 100, remaining = 4900, reset = 1735689600L)
        val search = RateLimit(limit = 30, used = 0, remaining = 30, reset = 1735689600L)
        val resources = RateLimitResources(core = core, search = search)
        resources.core shouldBe core
        resources.search shouldBe search
    }

    "RateLimitOverview should instantiate and compare correctly" {
        val rate = RateLimit(limit = 5000, used = 100, remaining = 4900, reset = 1735689600L)
        val core = RateLimit(limit = 5000, used = 100, remaining = 4900)
        val resources = RateLimitResources(core = core)
        val overview = RateLimitOverview(resources = resources, rate = rate)
        overview.rate shouldBe rate
        overview.resources shouldBe resources
    }
})

