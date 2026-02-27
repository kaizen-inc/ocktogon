package inc.kaizen.client.action.api

import inc.kaizen.client.action.model.artifact.Artifact
import inc.kaizen.client.action.model.artifact.Artifacts
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class ArtifactApiSpec : FunSpec({
    val api = mockk<ArtifactApi>()
    val owner = "owner"
    val repo = "repo"
    val artifactId = "123"
    val runId = "456"
    val artifact = mockk<Artifact>()
    val artifacts = mockk<Artifacts>()

    test("getRepoArtifacts returns artifacts") {
        coEvery { api.getRepoArtifacts(owner, repo, any(), any(), any()) } returns artifacts
        runBlocking {
            api.getRepoArtifacts(owner, repo) shouldBe artifacts
        }
    }

    test("getRepoArtifact returns artifact") {
        coEvery { api.getRepoArtifact(owner, repo, artifactId) } returns artifact
        runBlocking {
            api.getRepoArtifact(owner, repo, artifactId) shouldBe artifact
        }
    }

    test("deleteRepoArtifact returns unit response") {
        coEvery { api.deleteRepoArtifact(owner, repo, artifactId) } returns Response.success(Unit)
        runBlocking {
            api.deleteRepoArtifact(owner, repo, artifactId).isSuccessful shouldBe true
        }
    }

    test("downloadRepoArtifact returns unit response") {
        coEvery { api.downloadRepoArtifact(owner, repo, artifactId, "zip") } returns Response.success(Unit)
        runBlocking {
            api.downloadRepoArtifact(owner, repo, artifactId, "zip").isSuccessful shouldBe true
        }
    }

    test("getWorkflowRunRepoArtifacts returns artifacts") {
        coEvery { api.getWorkflowRunRepoArtifacts(owner, repo, runId, any(), any(), any()) } returns artifacts
        runBlocking {
            api.getWorkflowRunRepoArtifacts(owner, repo, runId) shouldBe artifacts
        }
    }
})

