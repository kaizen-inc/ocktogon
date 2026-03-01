package inc.kaizen.client.ocktogon.securityadvisories.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SecurityAdvisoryModelsSpec : StringSpec({

    "AdvisoryIdentifier should instantiate and compare correctly" {
        val id = AdvisoryIdentifier(value = "CVE-2021-1234", type = "CVE")
        id.value shouldBe "CVE-2021-1234"
        id.type shouldBe "CVE"
    }

    "AdvisoryPackage should instantiate and compare correctly" {
        val pkg = AdvisoryPackage(ecosystem = "npm", name = "lodash")
        pkg.ecosystem shouldBe "npm"
        pkg.name shouldBe "lodash"
    }

    "AdvisoryVulnerability should instantiate and compare correctly" {
        val pkg = AdvisoryPackage(ecosystem = "npm", name = "lodash")
        val vuln = AdvisoryVulnerability(`package` = pkg, severity = "high", vulnerable_version_range = "< 4.17.21", first_patched_version = "4.17.21")
        vuln.severity shouldBe "high"
        vuln.first_patched_version shouldBe "4.17.21"
    }

    "AdvisoryCvss should instantiate and compare correctly" {
        val cvss = AdvisoryCvss(score = 9.8, vector_string = "CVSS:3.1/AV:N/AC:L/PR:N/UI:N/S:U/C:H/I:H/A:H")
        cvss.score shouldBe 9.8
    }

    "AdvisoryCwe should instantiate and compare correctly" {
        val cwe = AdvisoryCwe(cwe_id = "CWE-79", name = "Cross-site Scripting")
        cwe.cwe_id shouldBe "CWE-79"
    }

    "AdvisoryCredit should instantiate and compare correctly" {
        val credit = AdvisoryCredit(user = null, type = "analyst")
        credit.type shouldBe "analyst"
    }

    "GlobalSecurityAdvisory should instantiate and compare correctly" {
        val advisory = GlobalSecurityAdvisory(ghsa_id = "GHSA-1234", cve_id = "CVE-2021-1234", summary = "Critical vulnerability", severity = "critical")
        advisory.ghsa_id shouldBe "GHSA-1234"
        advisory.severity shouldBe "critical"
    }

    "RepositoryAdvisory should instantiate and compare correctly" {
        val advisory = RepositoryAdvisory(ghsa_id = "GHSA-1234", summary = "Critical", severity = "critical", state = "published")
        advisory.ghsa_id shouldBe "GHSA-1234"
        advisory.state shouldBe "published"
    }

    "CreateRepositoryAdvisoryRequest should instantiate and compare correctly" {
        val req = CreateRepositoryAdvisoryRequest(summary = "Critical vulnerability", description = "Detailed desc", severity = "critical")
        req.summary shouldBe "Critical vulnerability"
        req.severity shouldBe "critical"
    }

    "UpdateRepositoryAdvisoryRequest should instantiate and compare correctly" {
        val req = UpdateRepositoryAdvisoryRequest(summary = "Updated summary", state = "published")
        req.summary shouldBe "Updated summary"
        req.state shouldBe "published"
    }

    "AdvisoryVulnerabilityRequest should instantiate and compare correctly" {
        val pkg = AdvisoryPackage(ecosystem = "npm", name = "lodash")
        val req = AdvisoryVulnerabilityRequest(`package` = pkg, vulnerable_version_range = "< 4.17.21", patched_versions = "4.17.21")
        req.`package` shouldBe pkg
        req.patched_versions shouldBe "4.17.21"
    }

    "AdvisoryCreditRequest should instantiate and compare correctly" {
        val req = AdvisoryCreditRequest(login = "octocat", type = "analyst")
        req.login shouldBe "octocat"
        req.type shouldBe "analyst"
    }

    "PrivateVulnerabilityReportRequest should instantiate and compare correctly" {
        val req = PrivateVulnerabilityReportRequest(summary = "Vulnerability found", description = "Details here", severity = "high")
        req.summary shouldBe "Vulnerability found"
        req.severity shouldBe "high"
    }
})

