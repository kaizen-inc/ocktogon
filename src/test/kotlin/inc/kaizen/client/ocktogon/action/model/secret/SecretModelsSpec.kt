package inc.kaizen.client.ocktogon.action.model.secret

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SecretModelsSpec : StringSpec({

    "Key should instantiate and compare correctly" {
        val key = Key(key = "base64encodedkey==", key_id = "key-id-123")
        key.key shouldBe "base64encodedkey=="
        key.key_id shouldBe "key-id-123"
    }

    "OrgSecret should instantiate and compare correctly" {
        val secret = OrgSecret(
            encrypted_value = "encryptedvalue",
            key_id = "key-id-123",
            selected_repository_ids = listOf(1, 2, 3),
            visibility = "selected"
        )
        secret.encrypted_value shouldBe "encryptedvalue"
        secret.key_id shouldBe "key-id-123"
        secret.selected_repository_ids shouldBe listOf(1, 2, 3)
        secret.visibility shouldBe "selected"
    }

    "Secret should instantiate and compare correctly" {
        val secret = Secret(
            created_at = "2025-01-01T00:00:00Z",
            name = "MY_SECRET",
            selected_repositories_url = "https://api.github.com/orgs/my-org/actions/secrets/MY_SECRET/repositories",
            updated_at = "2025-06-01T00:00:00Z",
            visibility = "all"
        )
        secret.name shouldBe "MY_SECRET"
        secret.visibility shouldBe "all"
    }

    "Secrets should instantiate and compare correctly" {
        val secret = Secret(
            created_at = "2025-01-01T00:00:00Z",
            name = "MY_SECRET",
            selected_repositories_url = "url",
            updated_at = "2025-06-01T00:00:00Z",
            visibility = "all"
        )
        val secrets = Secrets(secrets = listOf(secret), total_count = 1)
        secrets.total_count shouldBe 1
        secrets.secrets.size shouldBe 1
        secrets.secrets[0] shouldBe secret
    }

    "Repositories should instantiate and compare correctly" {
        val repos = Repositories(repositories = listOf(), total_count = 0)
        repos.total_count shouldBe 0
        repos.repositories.size shouldBe 0
    }
})
