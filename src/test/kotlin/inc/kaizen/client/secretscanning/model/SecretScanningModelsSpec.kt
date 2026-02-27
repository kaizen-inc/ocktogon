package inc.kaizen.client.secretscanning.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SecretScanningModelsSpec : StringSpec({

    "SecretScanningLocationDetails should instantiate and compare correctly" {
        val details = SecretScanningLocationDetails(
            path = "src/config.kt", start_line = 10, end_line = 10,
            start_column = 20, end_column = 50, blob_sha = "abc123", commit_sha = "def456"
        )
        details.path shouldBe "src/config.kt"
        details.start_line shouldBe 10
        details.commit_sha shouldBe "def456"
    }

    "SecretScanningAlertLocation should instantiate and compare correctly" {
        val details = SecretScanningLocationDetails(path = "src/config.kt", blob_sha = "abc123")
        val location = SecretScanningAlertLocation(type = "commit", details = details)
        location.type shouldBe "commit"
        location.details shouldBe details
    }

    "SecretScanningAlert should instantiate and compare correctly" {
        val alert = SecretScanningAlert(
            number = 1, state = "open", secret_type = "github_personal_access_token",
            secret_type_display_name = "GitHub Personal Access Token", validity = "active"
        )
        alert.number shouldBe 1
        alert.state shouldBe "open"
        alert.secret_type shouldBe "github_personal_access_token"
    }

    "SecretScanningAlert should instantiate with null defaults" {
        val alert = SecretScanningAlert()
        alert.number shouldBe null
        alert.state shouldBe null
    }

    "UpdateSecretScanningAlertRequest should instantiate and compare correctly" {
        val req = UpdateSecretScanningAlertRequest(state = "resolved", resolution = "revoked", resolution_comment = "Token revoked")
        req.state shouldBe "resolved"
        req.resolution shouldBe "revoked"
        req.resolution_comment shouldBe "Token revoked"
    }
})

