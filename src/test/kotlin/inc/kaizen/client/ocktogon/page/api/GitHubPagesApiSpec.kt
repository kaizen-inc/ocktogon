package inc.kaizen.client.ocktogon.page.api

import inc.kaizen.client.page.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class GitHubPagesApiSpec : FunSpec({
    val api = mockk<GitHubPagesApi>()
    val owner = "owner"
    val repo = "repo"
    val buildId = "buildId"
    val pagesDeploymentId = "deploymentId"
    val pagesSite = mockk<PagesSite>()
    val pagesSiteRequest = mockk<PagesSiteRequest>()
    val pagesSiteInfoRequest = mockk<PagesSiteInformationRequest>()
    val pagesBuild = mockk<PagesBuild>()
    val pagesBuildList = listOf(pagesBuild)
    val pageDeployment = mockk<PageDeployment>()
    val pageDeploymentStatus = mockk<PageDeploymentStatus>()
    val pagesDnsHealth = mockk<PagesDnsHealth>()

    test("getPagesSite returns site") {
        coEvery { api.getPagesSite(owner, repo) } returns Response.success(pagesSite)
        runBlocking {
            api.getPagesSite(owner, repo).body() shouldBe pagesSite
        }
    }

    test("createOrUpdatePagesSite returns site") {
        coEvery { api.createOrUpdatePagesSite(owner, repo, pagesSiteRequest) } returns Response.success(pagesSite)
        runBlocking {
            api.createOrUpdatePagesSite(owner, repo, pagesSiteRequest).body() shouldBe pagesSite
        }
    }

    test("updatePagesSiteInformation returns unit response") {
        coEvery { api.updatePagesSiteInformation(owner, repo, pagesSiteInfoRequest) } returns Response.success(Unit)
        runBlocking {
            api.updatePagesSiteInformation(owner, repo, pagesSiteInfoRequest).isSuccessful shouldBe true
        }
    }

    test("deletePagesSite returns unit response") {
        coEvery { api.deletePagesSite(owner, repo) } returns Response.success(Unit)
        runBlocking {
            api.deletePagesSite(owner, repo).isSuccessful shouldBe true
        }
    }

    test("listPagesBuilds returns builds list") {
        coEvery { api.listPagesBuilds(owner, repo, any(), any()) } returns Response.success(pagesBuildList)
        runBlocking {
            api.listPagesBuilds(owner, repo).body() shouldBe pagesBuildList
        }
    }

    test("requestPagesBuild returns build") {
        coEvery { api.requestPagesBuild(owner, repo) } returns Response.success(pagesBuild)
        runBlocking {
            api.requestPagesBuild(owner, repo).body() shouldBe pagesBuild
        }
    }

    test("getLatestPagesBuild returns build") {
        coEvery { api.getLatestPagesBuild(owner, repo) } returns Response.success(pagesBuild)
        runBlocking {
            api.getLatestPagesBuild(owner, repo).body() shouldBe pagesBuild
        }
    }

    test("getPagesBuild returns build") {
        coEvery { api.getPagesBuild(owner, repo, buildId) } returns Response.success(pagesBuild)
        runBlocking {
            api.getPagesBuild(owner, repo, buildId).body() shouldBe pagesBuild
        }
    }

    test("createPagesDeployment returns deployment") {
        coEvery { api.createPagesDeployment(owner, repo, pagesSiteRequest) } returns Response.success(pageDeployment)
        runBlocking {
            api.createPagesDeployment(owner, repo, pagesSiteRequest).body() shouldBe pageDeployment
        }
    }

    test("getPagesDeployment returns deployment status") {
        coEvery { api.getPagesDeployment(owner, repo, pagesDeploymentId) } returns Response.success(pageDeploymentStatus)
        runBlocking {
            api.getPagesDeployment(owner, repo, pagesDeploymentId).body() shouldBe pageDeploymentStatus
        }
    }

    test("cancelPagesDeployment returns unit response") {
        coEvery { api.cancelPagesDeployment(owner, repo, pagesDeploymentId) } returns Response.success(Unit)
        runBlocking {
            api.cancelPagesDeployment(owner, repo, pagesDeploymentId).isSuccessful shouldBe true
        }
    }

    test("getPagesDnsHealth returns dns health") {
        coEvery { api.getPagesDnsHealth(owner, repo) } returns Response.success(pagesDnsHealth)
        runBlocking {
            api.getPagesDnsHealth(owner, repo).body() shouldBe pagesDnsHealth
        }
    }
})
