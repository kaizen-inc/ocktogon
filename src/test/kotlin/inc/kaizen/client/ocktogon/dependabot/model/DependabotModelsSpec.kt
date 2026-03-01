package inc.kaizen.client.ocktogon.dependabot.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DependabotModelsSpec : StringSpec({

    "DependabotPackage should instantiate and compare correctly" {
        val pkg = DependabotPackage(ecosystem = "npm", name = "lodash")
        pkg.ecosystem shouldBe "npm"
        pkg.name shouldBe "lodash"
    }

    "DependabotFirstPatchedVersion should instantiate and compare correctly" {
        val ver = DependabotFirstPatchedVersion(identifier = "4.17.21")
        ver.identifier shouldBe "4.17.21"
    }

    "DependabotCvss should instantiate and compare correctly" {
        val cvss = DependabotCvss(score = 9.8, vector_string = "CVSS:3.1/AV:N/AC:L/PR:N/UI:N/S:U/C:H/I:H/A:H")
        cvss.score shouldBe 9.8
    }

    "DependabotCwe should instantiate and compare correctly" {
        val cwe = DependabotCwe(cwe_id = "CWE-79", name = "Cross-site Scripting")
        cwe.cwe_id shouldBe "CWE-79"
        cwe.name shouldBe "Cross-site Scripting"
    }

    "DependabotIdentifier should instantiate and compare correctly" {
        val id = DependabotIdentifier(value = "CVE-2021-1234", type = "CVE")
        id.value shouldBe "CVE-2021-1234"
        id.type shouldBe "CVE"
    }

    "DependabotReference should instantiate and compare correctly" {
        val ref = DependabotReference(url = "https://nvd.nist.gov/vuln/detail/CVE-2021-1234")
        ref.url shouldBe "https://nvd.nist.gov/vuln/detail/CVE-2021-1234"
    }

    "DependabotVulnerability should instantiate and compare correctly" {
        val vuln = DependabotVulnerability(severity = "critical", vulnerable_version_range = "< 4.17.21")
        vuln.severity shouldBe "critical"
        vuln.vulnerable_version_range shouldBe "< 4.17.21"
    }

    "DependabotSecurityAdvisory should instantiate and compare correctly" {
        val advisory = DependabotSecurityAdvisory(ghsa_id = "GHSA-1234", summary = "Critical vulnerability", severity = "critical")
        advisory.ghsa_id shouldBe "GHSA-1234"
        advisory.severity shouldBe "critical"
    }

    "DependabotDependency should instantiate and compare correctly" {
        val pkg = DependabotPackage(ecosystem = "npm", name = "lodash")
        val dep = DependabotDependency(`package` = pkg, manifest_path = "package.json", scope = "runtime")
        dep.manifest_path shouldBe "package.json"
        dep.scope shouldBe "runtime"
    }

    "DependabotAlert should instantiate and compare correctly" {
        val alert = DependabotAlert(number = 1, state = "open", url = "url", html_url = "html_url")
        alert.number shouldBe 1
        alert.state shouldBe "open"
    }

    "DependabotSecret should instantiate and compare correctly" {
        val secret = DependabotSecret(name = "MY_SECRET", visibility = "all", created_at = "2025-01-01T00:00:00Z")
        secret.name shouldBe "MY_SECRET"
        secret.visibility shouldBe "all"
    }

    "DependabotPublicKey should instantiate and compare correctly" {
        val key = DependabotPublicKey(key_id = "key-id", key = "base64key")
        key.key_id shouldBe "key-id"
    }

    "DependabotSecretsResponse should instantiate and compare correctly" {
        val secret = DependabotSecret(name = "S1")
        val resp = DependabotSecretsResponse(total_count = 1, secrets = listOf(secret))
        resp.total_count shouldBe 1
        resp.secrets?.size shouldBe 1
    }

    "UpdateDependabotAlertRequest should instantiate and compare correctly" {
        val req = UpdateDependabotAlertRequest(state = "dismissed", dismissed_reason = "tolerable_risk")
        req.state shouldBe "dismissed"
        req.dismissed_reason shouldBe "tolerable_risk"
    }

    "CreateDependabotSecretRequest should instantiate and compare correctly" {
        val req = CreateDependabotSecretRequest(encrypted_value = "enc", key_id = "kid", visibility = "selected", selected_repository_ids = listOf("1"))
        req.encrypted_value shouldBe "enc"
        req.visibility shouldBe "selected"
    }

    "SetSelectedReposRequest should instantiate and compare correctly" {
        val req = SetSelectedReposRequest(selected_repository_ids = listOf(1, 2, 3))
        req.selected_repository_ids shouldBe listOf(1, 2, 3)
    }

    "DependabotSecretRepositoriesResponse should instantiate and compare correctly" {
        val resp = DependabotSecretRepositoriesResponse(total_count = 0, repositories = listOf())
        resp.total_count shouldBe 0
        resp.repositories?.size shouldBe 0
    }
})
