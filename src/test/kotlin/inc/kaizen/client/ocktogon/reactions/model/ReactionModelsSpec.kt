package inc.kaizen.client.ocktogon.reactions.model

import inc.kaizen.client.common.User
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ReactionModelsSpec : StringSpec({

    "Reaction should instantiate and compare correctly" {
        val user = User(id = 1, login = "octocat")
        val reaction = Reaction(id = 1, node_id = "node", user = user, content = "+1", created_at = "2025-01-01T00:00:00Z")
        reaction.id shouldBe 1
        reaction.content shouldBe "+1"
        reaction.user shouldBe user
    }

    "Reaction should instantiate with null defaults" {
        val reaction = Reaction()
        reaction.id shouldBe null
        reaction.content shouldBe null
    }

    "CreateReactionRequest should instantiate and compare correctly" {
        val req = CreateReactionRequest(content = "heart")
        req.content shouldBe "heart"
    }
})

