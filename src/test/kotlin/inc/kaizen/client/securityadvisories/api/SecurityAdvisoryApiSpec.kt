package inc.kaizen.client.securityadvisories.api

import inc.kaizen.client.securityadvisories.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class SecurityAdvisoryApiSpec : FunSpec({
    val api = mockk<SecurityAdvisoryApi>()
    val owner = "owner"; val repo = "repo"; val ghsaId = "GHSA-1234"
    val globalAdvisory = mockk<GlobalSecurityAdvisory>()
    val repoAdvisory = mockk<RepositoryAdvisory>()
    val createReq = CreateRepositoryAdvisoryRequest(summary = "Critical", description = "Details")
    val updateReq = UpdateRepositoryAdvisoryRequest(summary = "Updated")
    val reportReq = PrivateVulnerabilityReportRequest(summary = "Vuln", description = "Details")

    test("listGlobalSecurityAdvisories returns advisories") {
        coEvery { api.listGlobalSecurityAdvisories(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns listOf(globalAdvisory)
        runBlocking { api.listGlobalSecurityAdvisories() shouldBe listOf(globalAdvisory) }
    }
    test("getGlobalSecurityAdvisory returns advisory") {
        coEvery { api.getGlobalSecurityAdvisory(ghsaId) } returns globalAdvisory
        runBlocking { api.getGlobalSecurityAdvisory(ghsaId) shouldBe globalAdvisory }
    }
    test("listRepoSecurityAdvisories returns advisories") {
        coEvery { api.listRepoSecurityAdvisories(owner, repo, any(), any(), any(), any(), any(), any()) } returns listOf(repoAdvisory)
        runBlocking { api.listRepoSecurityAdvisories(owner, repo) shouldBe listOf(repoAdvisory) }
    }
    test("createRepoSecurityAdvisory returns advisory") {
        coEvery { api.createRepoSecurityAdvisory(owner, repo, createReq) } returns repoAdvisory
        runBlocking { api.createRepoSecurityAdvisory(owner, repo, createReq) shouldBe repoAdvisory }
    }
    test("getRepoSecurityAdvisory returns advisory") {
        coEvery { api.getRepoSecurityAdvisory(owner, repo, ghsaId) } returns repoAdvisory
        runBlocking { api.getRepoSecurityAdvisory(owner, repo, ghsaId) shouldBe repoAdvisory }
    }
    test("updateRepoSecurityAdvisory returns advisory") {
        coEvery { api.updateRepoSecurityAdvisory(owner, repo, ghsaId, updateReq) } returns repoAdvisory
        runBlocking { api.updateRepoSecurityAdvisory(owner, repo, ghsaId, updateReq) shouldBe repoAdvisory }
    }
    test("requestCveForRepoSecurityAdvisory returns advisory") {
        coEvery { api.requestCveForRepoSecurityAdvisory(owner, repo, ghsaId) } returns repoAdvisory
        runBlocking { api.requestCveForRepoSecurityAdvisory(owner, repo, ghsaId) shouldBe repoAdvisory }
    }
    test("createPrivateVulnerabilityReport returns advisory") {
        coEvery { api.createPrivateVulnerabilityReport(owner, repo, reportReq) } returns repoAdvisory
        runBlocking { api.createPrivateVulnerabilityReport(owner, repo, reportReq) shouldBe repoAdvisory }
    }
})

