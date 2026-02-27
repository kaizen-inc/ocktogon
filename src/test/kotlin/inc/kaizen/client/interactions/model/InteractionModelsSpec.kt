package inc.kaizen.client.interactions.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class InteractionModelsSpec : StringSpec({

    "InteractionLimit should instantiate and compare correctly" {
        val limit = InteractionLimit(limit = "collaborators_only", origin = "repository", expires_at = "2025-12-31T23:59:59Z")
        limit.limit shouldBe "collaborators_only"
        limit.origin shouldBe "repository"
        limit.expires_at shouldBe "2025-12-31T23:59:59Z"
    }

    "InteractionLimit should instantiate with null defaults" {
        val limit = InteractionLimit()
        limit.limit shouldBe null
        limit.origin shouldBe null
    }

    "SetInteractionLimitRequest should instantiate and compare correctly" {
        val req = SetInteractionLimitRequest(limit = "existing_users", expiry = "one_month")
        req.limit shouldBe "existing_users"
        req.expiry shouldBe "one_month"
    }

    "SetInteractionLimitRequest should instantiate without expiry" {
        val req = SetInteractionLimitRequest(limit = "collaborators_only")
        req.limit shouldBe "collaborators_only"
        req.expiry shouldBe null
    }
})

