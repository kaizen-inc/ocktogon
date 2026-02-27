package inc.kaizen.client.migrations.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MigrationModelsSpec : StringSpec({

    "Migration should instantiate and compare correctly" {
        val migration = Migration(id = 1L, guid = "guid-123", state = "exported", lock_repositories = false, repositories = listOf())
        migration.id shouldBe 1L
        migration.state shouldBe "exported"
        migration.repositories?.size shouldBe 0
    }

    "Migration should instantiate with null defaults" {
        val migration = Migration()
        migration.id shouldBe null
        migration.state shouldBe null
    }

    "StartMigrationRequest should instantiate and compare correctly" {
        val req = StartMigrationRequest(
            repositories = listOf("owner/repo1", "owner/repo2"),
            lock_repositories = true,
            exclude_attachments = false
        )
        req.repositories shouldBe listOf("owner/repo1", "owner/repo2")
        req.lock_repositories shouldBe true
    }

    "StartMigrationRequest should instantiate with only required field" {
        val req = StartMigrationRequest(repositories = listOf("owner/repo"))
        req.repositories.size shouldBe 1
        req.lock_repositories shouldBe null
    }
})

