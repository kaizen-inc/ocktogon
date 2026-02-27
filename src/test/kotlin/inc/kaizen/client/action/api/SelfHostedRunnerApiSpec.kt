package inc.kaizen.client.action.api

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class SelfHostedRunnerApiSpec : FunSpec({
    val api = mockk<SelfHostedRunnerApi>()
    val org = "my-org"
    val owner = "owner"
    val repo = "repo"
    val runnerId = 1L
    val runnerName = "my-label"
    val runner = mockk<Runner>()
    val runnersResponse = mockk<RunnersResponse>()
    val runnerApplication = mockk<RunnerApplication>()
    val runnerApplicationList = listOf(runnerApplication)
    val runnerToken = mockk<RunnerToken>()
    val runnerJitConfig = mockk<RunnerJitConfig>()
    val runnerLabelsResponse = mockk<RunnerLabelsResponse>()
    val runnerLabelsRequest = RunnerLabelsRequest(labels = listOf("self-hosted"))
    val generateRunnerConfigRequest = GenerateRunnerConfigRequest(
        name = "runner",
        runner_group_id = 1,
        labels = listOf("self-hosted")
    )

    test("listOrgRunners returns runners response") {
        coEvery { api.listOrgRunners(org, any(), any(), any()) } returns runnersResponse
        runBlocking { api.listOrgRunners(org) shouldBe runnersResponse }
    }

    test("listRunnerApplicationsForOrg returns list") {
        coEvery { api.listRunnerApplicationsForOrg(org) } returns runnerApplicationList
        runBlocking { api.listRunnerApplicationsForOrg(org) shouldBe runnerApplicationList }
    }

    test("generateConfigForOrgRunner returns jit config") {
        coEvery { api.generateConfigForOrgRunner(org, generateRunnerConfigRequest) } returns runnerJitConfig
        runBlocking { api.generateConfigForOrgRunner(org, generateRunnerConfigRequest) shouldBe runnerJitConfig }
    }

    test("createRegistrationTokenForOrg returns token") {
        coEvery { api.createRegistrationTokenForOrg(org) } returns runnerToken
        runBlocking { api.createRegistrationTokenForOrg(org) shouldBe runnerToken }
    }

    test("createRemoveTokenForOrg returns token") {
        coEvery { api.createRemoveTokenForOrg(org) } returns runnerToken
        runBlocking { api.createRemoveTokenForOrg(org) shouldBe runnerToken }
    }

    test("getOrgRunner returns runner") {
        coEvery { api.getOrgRunner(org, runnerId) } returns runner
        runBlocking { api.getOrgRunner(org, runnerId) shouldBe runner }
    }

    test("deleteOrgRunner returns unit response") {
        coEvery { api.deleteOrgRunner(org, runnerId) } returns Response.success(Unit)
        runBlocking { api.deleteOrgRunner(org, runnerId).isSuccessful shouldBe true }
    }

    test("listLabelsForOrgRunner returns runner labels response") {
        coEvery { api.listLabelsForOrgRunner(org, runnerId) } returns runnerLabelsResponse
        runBlocking { api.listLabelsForOrgRunner(org, runnerId) shouldBe runnerLabelsResponse }
    }

    test("addCustomLabelsToOrgRunner returns runner labels response") {
        coEvery { api.addCustomLabelsToOrgRunner(org, runnerId, runnerLabelsRequest) } returns runnerLabelsResponse
        runBlocking { api.addCustomLabelsToOrgRunner(org, runnerId, runnerLabelsRequest) shouldBe runnerLabelsResponse }
    }

    test("setCustomLabelsForOrgRunner returns runner labels response") {
        coEvery { api.setCustomLabelsForOrgRunner(org, runnerId, runnerLabelsRequest) } returns runnerLabelsResponse
        runBlocking { api.setCustomLabelsForOrgRunner(org, runnerId, runnerLabelsRequest) shouldBe runnerLabelsResponse }
    }

    test("removeAllCustomLabelsFromOrgRunner returns runner labels response") {
        coEvery { api.removeAllCustomLabelsFromOrgRunner(org, runnerId) } returns runnerLabelsResponse
        runBlocking { api.removeAllCustomLabelsFromOrgRunner(org, runnerId) shouldBe runnerLabelsResponse }
    }

    test("removeCustomLabelFromOrgRunner returns runner labels response") {
        coEvery { api.removeCustomLabelFromOrgRunner(org, runnerId, runnerName) } returns runnerLabelsResponse
        runBlocking { api.removeCustomLabelFromOrgRunner(org, runnerId, runnerName) shouldBe runnerLabelsResponse }
    }

    test("listRepoRunners returns runners response") {
        coEvery { api.listRepoRunners(owner, repo, any(), any(), any()) } returns runnersResponse
        runBlocking { api.listRepoRunners(owner, repo) shouldBe runnersResponse }
    }

    test("listRunnerApplicationsForRepo returns list") {
        coEvery { api.listRunnerApplicationsForRepo(owner, repo) } returns runnerApplicationList
        runBlocking { api.listRunnerApplicationsForRepo(owner, repo) shouldBe runnerApplicationList }
    }

    test("generateConfigForRepoRunner returns jit config") {
        coEvery { api.generateConfigForRepoRunner(owner, repo, generateRunnerConfigRequest) } returns runnerJitConfig
        runBlocking { api.generateConfigForRepoRunner(owner, repo, generateRunnerConfigRequest) shouldBe runnerJitConfig }
    }

    test("createRegistrationTokenForRepo returns token") {
        coEvery { api.createRegistrationTokenForRepo(owner, repo) } returns runnerToken
        runBlocking { api.createRegistrationTokenForRepo(owner, repo) shouldBe runnerToken }
    }

    test("createRemoveTokenForRepo returns token") {
        coEvery { api.createRemoveTokenForRepo(owner, repo) } returns runnerToken
        runBlocking { api.createRemoveTokenForRepo(owner, repo) shouldBe runnerToken }
    }

    test("getRepoRunner returns runner") {
        coEvery { api.getRepoRunner(owner, repo, runnerId) } returns runner
        runBlocking { api.getRepoRunner(owner, repo, runnerId) shouldBe runner }
    }

    test("deleteRepoRunner returns unit response") {
        coEvery { api.deleteRepoRunner(owner, repo, runnerId) } returns Response.success(Unit)
        runBlocking { api.deleteRepoRunner(owner, repo, runnerId).isSuccessful shouldBe true }
    }

    test("listLabelsForRepoRunner returns runner labels response") {
        coEvery { api.listLabelsForRepoRunner(owner, repo, runnerId) } returns runnerLabelsResponse
        runBlocking { api.listLabelsForRepoRunner(owner, repo, runnerId) shouldBe runnerLabelsResponse }
    }

    test("addCustomLabelsToRepoRunner returns runner labels response") {
        coEvery { api.addCustomLabelsToRepoRunner(owner, repo, runnerId, runnerLabelsRequest) } returns runnerLabelsResponse
        runBlocking { api.addCustomLabelsToRepoRunner(owner, repo, runnerId, runnerLabelsRequest) shouldBe runnerLabelsResponse }
    }

    test("setCustomLabelsForRepoRunner returns runner labels response") {
        coEvery { api.setCustomLabelsForRepoRunner(owner, repo, runnerId, runnerLabelsRequest) } returns runnerLabelsResponse
        runBlocking { api.setCustomLabelsForRepoRunner(owner, repo, runnerId, runnerLabelsRequest) shouldBe runnerLabelsResponse }
    }

    test("removeAllCustomLabelsFromRepoRunner returns runner labels response") {
        coEvery { api.removeAllCustomLabelsFromRepoRunner(owner, repo, runnerId) } returns runnerLabelsResponse
        runBlocking { api.removeAllCustomLabelsFromRepoRunner(owner, repo, runnerId) shouldBe runnerLabelsResponse }
    }

    test("removeCustomLabelFromRepoRunner returns runner labels response") {
        coEvery { api.removeCustomLabelFromRepoRunner(owner, repo, runnerId, runnerName) } returns runnerLabelsResponse
        runBlocking { api.removeCustomLabelFromRepoRunner(owner, repo, runnerId, runnerName) shouldBe runnerLabelsResponse }
    }
})

