package inc.kaizen.client.repo.api

import inc.kaizen.client.repo.model.*
import inc.kaizen.client.repo.model.repo.Repo
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class RepoApiSpec : FunSpec({
    val api = mockk<RepoApi>()
    val owner = "owner"; val repo = "repo"; val org = "my-org"; val username = "octocat"
    val repoObj = mockk<Repo>()
    val repos = listOf(repoObj)
    val createReq = CreateRepoRequest(name = "new-repo")
    val updateReq = UpdateRepoRequest(name = "renamed-repo")
    val transferReq = TransferRepoRequest(new_owner = "new-owner")
    val tag = mockk<RepoTag>()

    test("listReposForAuthenticatedUser returns repos") {
        coEvery { api.listReposForAuthenticatedUser(any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns repos
        runBlocking { api.listReposForAuthenticatedUser() } shouldBe repos
    }
    test("listReposForUser returns repos") {
        coEvery { api.listReposForUser(username, any(), any(), any(), any(), any()) } returns repos
        runBlocking { api.listReposForUser(username) } shouldBe repos
    }
    test("listOrgRepos returns repos") {
        coEvery { api.listOrgRepos(org, any(), any(), any(), any(), any()) } returns repos
        runBlocking { api.listOrgRepos(org) } shouldBe repos
    }
    test("createRepoForAuthenticatedUser returns repo") {
        coEvery { api.createRepoForAuthenticatedUser(createReq) } returns repoObj
        runBlocking { api.createRepoForAuthenticatedUser(createReq) } shouldBe repoObj
    }
    test("createOrgRepo returns repo") {
        coEvery { api.createOrgRepo(org, createReq) } returns repoObj
        runBlocking { api.createOrgRepo(org, createReq) } shouldBe repoObj
    }
    test("getRepo returns repo") {
        coEvery { api.getRepo(owner, repo) } returns repoObj
        runBlocking { api.getRepo(owner, repo) } shouldBe repoObj
    }
    test("updateRepo returns repo") {
        coEvery { api.updateRepo(owner, repo, updateReq) } returns repoObj
        runBlocking { api.updateRepo(owner, repo, updateReq) } shouldBe repoObj
    }
    test("deleteRepo returns response") {
        coEvery { api.deleteRepo(owner, repo) } returns Response.success(Unit)
        runBlocking { api.deleteRepo(owner, repo).isSuccessful } shouldBe true
    }
    test("createFork returns repo") {
        coEvery { api.createFork(owner, repo, any()) } returns repoObj
        runBlocking { api.createFork(owner, repo) } shouldBe repoObj
    }
    test("listForks returns repos") {
        coEvery { api.listForks(owner, repo, any(), any(), any()) } returns repos
        runBlocking { api.listForks(owner, repo) } shouldBe repos
    }
    test("transferRepo returns repo") {
        coEvery { api.transferRepo(owner, repo, transferReq) } returns repoObj
        runBlocking { api.transferRepo(owner, repo, transferReq) } shouldBe repoObj
    }
    test("getRepoTopics returns topics response") {
        val topicsResponse = TopicsResponse(names = listOf("kotlin"))
        coEvery { api.getRepoTopics(owner, repo, any(), any()) } returns topicsResponse
        runBlocking { api.getRepoTopics(owner, repo) } shouldBe topicsResponse
    }
    test("replaceRepoTopics returns topics response") {
        val topicsRequest = TopicsRequest(names = listOf("kotlin"))
        val topicsResponse = TopicsResponse(names = listOf("kotlin"))
        coEvery { api.replaceRepoTopics(owner, repo, topicsRequest) } returns topicsResponse
        runBlocking { api.replaceRepoTopics(owner, repo, topicsRequest) } shouldBe topicsResponse
    }
    test("listRepoLanguages returns map") {
        val languages = mapOf("Kotlin" to 12345)
        coEvery { api.listRepoLanguages(owner, repo) } returns languages
        runBlocking { api.listRepoLanguages(owner, repo) } shouldBe languages
    }
    test("listRepoTags returns tags") {
        coEvery { api.listRepoTags(owner, repo, any(), any()) } returns listOf(tag)
        runBlocking { api.listRepoTags(owner, repo) } shouldBe listOf(tag)
    }
    test("listPublicRepos returns repos") {
        coEvery { api.listPublicRepos(any(), any()) } returns repos
        runBlocking { api.listPublicRepos() } shouldBe repos
    }
    test("checkVulnerabilityAlertsEnabled returns response") {
        coEvery { api.checkVulnerabilityAlertsEnabled(owner, repo) } returns Response.success(Unit)
        runBlocking { api.checkVulnerabilityAlertsEnabled(owner, repo).isSuccessful } shouldBe true
    }
    test("enableVulnerabilityAlerts returns response") {
        coEvery { api.enableVulnerabilityAlerts(owner, repo) } returns Response.success(Unit)
        runBlocking { api.enableVulnerabilityAlerts(owner, repo).isSuccessful } shouldBe true
    }
    test("disableVulnerabilityAlerts returns response") {
        coEvery { api.disableVulnerabilityAlerts(owner, repo) } returns Response.success(Unit)
        runBlocking { api.disableVulnerabilityAlerts(owner, repo).isSuccessful } shouldBe true
    }
    test("enableAutomatedSecurityFixes returns response") {
        coEvery { api.enableAutomatedSecurityFixes(owner, repo) } returns Response.success(Unit)
        runBlocking { api.enableAutomatedSecurityFixes(owner, repo).isSuccessful } shouldBe true
    }
    test("disableAutomatedSecurityFixes returns response") {
        coEvery { api.disableAutomatedSecurityFixes(owner, repo) } returns Response.success(Unit)
        runBlocking { api.disableAutomatedSecurityFixes(owner, repo).isSuccessful } shouldBe true
    }
    test("createRepoFromTemplate returns repo") {
        val createTemplateReq = CreateRepoFromTemplateRequest(name = "new-from-template")
        coEvery { api.createRepoFromTemplate("template-owner", "template-repo", createTemplateReq) } returns repoObj
        runBlocking { api.createRepoFromTemplate("template-owner", "template-repo", createTemplateReq) } shouldBe repoObj
    }
})
