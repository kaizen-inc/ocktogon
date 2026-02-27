package inc.kaizen.client.user.model

import inc.kaizen.client.common.Plan
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PlanTest : StringSpec({

    "Plan should instantiate with all fields" {
        val plan = Plan(
            name = "pro",
            space = 5000,
            private_repos = 100,
            collaborators = 10,
            filled_seats = 5,
            seats = 20
        )
        plan.name shouldBe "pro"
        plan.space shouldBe 5000
        plan.private_repos shouldBe 100
        plan.collaborators shouldBe 10
        plan.filled_seats shouldBe 5
        plan.seats shouldBe 20
    }

    "Plan should instantiate with null defaults" {
        val plan = Plan()
        plan.name shouldBe null
        plan.space shouldBe null
        plan.seats shouldBe null
    }
})

