package inc.kaizen.client.ocktogon.repo.model.repo

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RepoSubModelsSpec : StringSpec({

    "AdvancedSecurity should instantiate and compare correctly" {
        val sec = AdvancedSecurity(status = "enabled")
        sec.status shouldBe "enabled"
    }

    "SecretScanning should instantiate and compare correctly" {
        val ss = SecretScanning(status = "enabled")
        ss.status shouldBe "enabled"
    }

    "SecretScanningPushProtection should instantiate and compare correctly" {
        val sspp = SecretScanningPushProtection(status = "disabled")
        sspp.status shouldBe "disabled"
    }

    "SecurityAndAnalysis should instantiate and compare correctly" {
        val adv = AdvancedSecurity(status = "enabled")
        val ss = SecretScanning(status = "enabled")
        val sspp = SecretScanningPushProtection(status = "disabled")
        val sec = SecurityAndAnalysis(advanced_security = adv, secret_scanning = ss, secret_scanning_push_protection = sspp)
        sec.advanced_security.status shouldBe "enabled"
        sec.secret_scanning_push_protection.status shouldBe "disabled"
    }
})

