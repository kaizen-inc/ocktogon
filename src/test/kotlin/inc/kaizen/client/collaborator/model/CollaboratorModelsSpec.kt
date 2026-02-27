package inc.kaizen.client.collaborator.model

import inc.kaizen.client.common.User
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CollaboratorModelsSpec : StringSpec({

    "Affiliation enum should have correct values" {
        Affiliation.values().size shouldBe 3
        Affiliation.outside.name shouldBe "outside"
        Affiliation.direct.name shouldBe "direct"
        Affiliation.all.name shouldBe "all"
    }

    "Permission enum should have correct values" {
        Permission.values().size shouldBe 5
        Permission.pull.name shouldBe "pull"
        Permission.triage.name shouldBe "triage"
        Permission.push.name shouldBe "push"
        Permission.maintain.name shouldBe "maintain"
        Permission.admin.name shouldBe "admin"
    }

    "CollaboratorPermission should instantiate and compare correctly" {
        val user = User(id = 1, login = "octocat")
        val collab = CollaboratorPermission(
            permission = "admin",
            role_name = "admin",
            user = user
        )
        collab.permission shouldBe "admin"
        collab.role_name shouldBe "admin"
        collab.user shouldBe user
    }
})

