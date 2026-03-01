package inc.kaizen.client.ocktogon.releases.api

import inc.kaizen.client.releases.model.Release
import inc.kaizen.client.releases.model.ReleaseNotes
import inc.kaizen.client.releases.model.ReleaseNotesRequest
import inc.kaizen.client.releases.model.ReleaseRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class ReleaseApiSpec : FunSpec({
    val api = mockk<ReleaseApi>()
    val owner = "owner"
    val repo = "repo"
    val releaseId = 1L
    val tag = "v1.0.0"
    val release = mockk<Release>()
    val releaseList = listOf(release)
    val releaseRequest = mockk<ReleaseRequest>()
    val releaseNotesRequest = mockk<ReleaseNotesRequest>()
    val releaseNotes = mockk<ReleaseNotes>()

    test("listReleases returns releases list") {
        coEvery { api.listReleases(owner, repo, any(), any()) } returns Response.success(releaseList)
        runBlocking {
            api.listReleases(owner, repo).body() shouldBe releaseList
        }
    }

    test("createRelease returns created release") {
        coEvery { api.createRelease(owner, repo, releaseRequest) } returns Response.success(release)
        runBlocking {
            api.createRelease(owner, repo, releaseRequest).body() shouldBe release
        }
    }

    test("createReleaseNotes returns release notes") {
        coEvery { api.createReleaseNotes(owner, repo, releaseNotesRequest) } returns Response.success(releaseNotes)
        runBlocking {
            api.createReleaseNotes(owner, repo, releaseNotesRequest).body() shouldBe releaseNotes
        }
    }

    test("getLatestRelease returns latest release") {
        coEvery { api.getLatestRelease(owner, repo) } returns Response.success(release)
        runBlocking {
            api.getLatestRelease(owner, repo).body() shouldBe release
        }
    }

    test("getReleaseByTag returns release by tag") {
        coEvery { api.getReleaseByTag(owner, repo, tag) } returns Response.success(release)
        runBlocking {
            api.getReleaseByTag(owner, repo, tag).body() shouldBe release
        }
    }

    test("getRelease returns release by id") {
        coEvery { api.getRelease(owner, repo, releaseId) } returns Response.success(release)
        runBlocking {
            api.getRelease(owner, repo, releaseId).body() shouldBe release
        }
    }

    test("updateRelease returns updated release") {
        coEvery { api.updateRelease(owner, repo, releaseId, releaseRequest) } returns Response.success(release)
        runBlocking {
            api.updateRelease(owner, repo, releaseId, releaseRequest).body() shouldBe release
        }
    }

    test("deleteRelease returns unit response") {
        coEvery { api.deleteRelease(owner, repo, releaseId) } returns Response.success(Unit)
        runBlocking {
            api.deleteRelease(owner, repo, releaseId).isSuccessful shouldBe true
        }
    }
})
