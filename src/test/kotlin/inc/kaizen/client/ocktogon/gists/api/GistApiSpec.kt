package inc.kaizen.client.ocktogon.gists.api

import inc.kaizen.client.gists.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class GistApiSpec : FunSpec({
    val api = mockk<GistApi>()
    val gistId = "gist-id"; val username = "octocat"
    val gist = mockk<Gist>()
    val gists = listOf(gist)
    val createReq = mockk<CreateGistRequest>()
    val updateReq = mockk<UpdateGistRequest>()
    val commit = mockk<GistCommit>()
    val fork = mockk<GistFork>()
    val comment = mockk<GistComment>()
    val commentReq = CreateGistCommentRequest("body")

    test("listGistsForAuthenticatedUser returns gists") {
        coEvery { api.listGistsForAuthenticatedUser(any(), any(), any()) } returns gists
        runBlocking { api.listGistsForAuthenticatedUser() shouldBe gists }
    }
    test("createGist returns gist") {
        coEvery { api.createGist(createReq) } returns gist
        runBlocking { api.createGist(createReq) shouldBe gist }
    }
    test("listPublicGists returns gists") {
        coEvery { api.listPublicGists(any(), any(), any()) } returns gists
        runBlocking { api.listPublicGists() shouldBe gists }
    }
    test("listStarredGists returns gists") {
        coEvery { api.listStarredGists(any(), any(), any()) } returns gists
        runBlocking { api.listStarredGists() shouldBe gists }
    }
    test("getGist returns gist") {
        coEvery { api.getGist(gistId) } returns gist
        runBlocking { api.getGist(gistId) shouldBe gist }
    }
    test("updateGist returns gist") {
        coEvery { api.updateGist(gistId, updateReq) } returns gist
        runBlocking { api.updateGist(gistId, updateReq) shouldBe gist }
    }
    test("deleteGist returns response") {
        coEvery { api.deleteGist(gistId) } returns Response.success(Unit)
        runBlocking { api.deleteGist(gistId).isSuccessful shouldBe true }
    }
    test("listGistCommits returns commits") {
        coEvery { api.listGistCommits(gistId, any(), any()) } returns listOf(commit)
        runBlocking { api.listGistCommits(gistId) shouldBe listOf(commit) }
    }
    test("listGistForks returns forks") {
        coEvery { api.listGistForks(gistId, any(), any()) } returns listOf(fork)
        runBlocking { api.listGistForks(gistId) shouldBe listOf(fork) }
    }
    test("listGistsForUser returns gists") {
        coEvery { api.listGistsForUser(username, any(), any(), any()) } returns gists
        runBlocking { api.listGistsForUser(username) shouldBe gists }
    }
    test("listGistComments returns comments") {
        coEvery { api.listGistComments(gistId, any(), any()) } returns listOf(comment)
        runBlocking { api.listGistComments(gistId) shouldBe listOf(comment) }
    }
    test("createGistComment returns comment") {
        coEvery { api.createGistComment(gistId, commentReq) } returns comment
        runBlocking { api.createGistComment(gistId, commentReq) shouldBe comment }
    }
    test("getGistComment returns comment") {
        coEvery { api.getGistComment(gistId, 1) } returns comment
        runBlocking { api.getGistComment(gistId, 1) shouldBe comment }
    }
    test("deleteGistComment returns response") {
        coEvery { api.deleteGistComment(gistId, 1) } returns Response.success(Unit)
        runBlocking { api.deleteGistComment(gistId, 1).isSuccessful shouldBe true }
    }
    test("checkIfGistIsStarred returns response") {
        coEvery { api.checkIfGistIsStarred(gistId) } returns Response.success(Unit)
        runBlocking { api.checkIfGistIsStarred(gistId).isSuccessful shouldBe true }
    }
    test("starGist returns response") {
        coEvery { api.starGist(gistId) } returns Response.success(Unit)
        runBlocking { api.starGist(gistId).isSuccessful shouldBe true }
    }
    test("unstarGist returns response") {
        coEvery { api.unstarGist(gistId) } returns Response.success(Unit)
        runBlocking { api.unstarGist(gistId).isSuccessful shouldBe true }
    }
    test("forkGist returns gist") {
        coEvery { api.forkGist(gistId) } returns gist
        runBlocking { api.forkGist(gistId) shouldBe gist }
    }
})

