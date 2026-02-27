package inc.kaizen.client.activity.api

import inc.kaizen.client.activity.model.RepoSubscription
import inc.kaizen.client.activity.model.SetRepoSubscriptionRequest
import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.User
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class StarAndWatchApiSpec : FunSpec({
    val starApi = mockk<StarApi>()
    val watchApi = mockk<WatchApi>()
    val owner = "owner"; val repo = "repo"; val username = "octocat"
    val users = listOf<User>()
    val repos = listOf<Repository>()
    val subscription = mockk<RepoSubscription>()
    val subRequest = SetRepoSubscriptionRequest(subscribed = true)

    test("listStargazers returns users") {
        coEvery { starApi.listStargazers(owner, repo, any(), any()) } returns users
        runBlocking { starApi.listStargazers(owner, repo) shouldBe users }
    }
    test("listReposStarredByAuthenticatedUser returns repos") {
        coEvery { starApi.listReposStarredByAuthenticatedUser(any(), any(), any(), any()) } returns repos
        runBlocking { starApi.listReposStarredByAuthenticatedUser() shouldBe repos }
    }
    test("listReposStarredByUser returns repos") {
        coEvery { starApi.listReposStarredByUser(username, any(), any(), any(), any()) } returns repos
        runBlocking { starApi.listReposStarredByUser(username) shouldBe repos }
    }
    test("checkIfRepoIsStarredByAuthenticatedUser returns response") {
        coEvery { starApi.checkIfRepoIsStarredByAuthenticatedUser(owner, repo) } returns Response.success(Unit)
        runBlocking { starApi.checkIfRepoIsStarredByAuthenticatedUser(owner, repo).isSuccessful shouldBe true }
    }
    test("starRepoForAuthenticatedUser returns response") {
        coEvery { starApi.starRepoForAuthenticatedUser(owner, repo) } returns Response.success(Unit)
        runBlocking { starApi.starRepoForAuthenticatedUser(owner, repo).isSuccessful shouldBe true }
    }
    test("unstarRepoForAuthenticatedUser returns response") {
        coEvery { starApi.unstarRepoForAuthenticatedUser(owner, repo) } returns Response.success(Unit)
        runBlocking { starApi.unstarRepoForAuthenticatedUser(owner, repo).isSuccessful shouldBe true }
    }
    test("listWatchers returns users") {
        coEvery { watchApi.listWatchers(owner, repo, any(), any()) } returns users
        runBlocking { watchApi.listWatchers(owner, repo) shouldBe users }
    }
    test("getRepoSubscription returns subscription") {
        coEvery { watchApi.getRepoSubscription(owner, repo) } returns subscription
        runBlocking { watchApi.getRepoSubscription(owner, repo) shouldBe subscription }
    }
    test("setRepoSubscription returns subscription") {
        coEvery { watchApi.setRepoSubscription(owner, repo, subRequest) } returns subscription
        runBlocking { watchApi.setRepoSubscription(owner, repo, subRequest) shouldBe subscription }
    }
    test("deleteRepoSubscription returns response") {
        coEvery { watchApi.deleteRepoSubscription(owner, repo) } returns Response.success(Unit)
        runBlocking { watchApi.deleteRepoSubscription(owner, repo).isSuccessful shouldBe true }
    }
    test("listReposWatchedByAuthenticatedUser returns repos") {
        coEvery { watchApi.listReposWatchedByAuthenticatedUser(any(), any()) } returns repos
        runBlocking { watchApi.listReposWatchedByAuthenticatedUser() shouldBe repos }
    }
    test("listReposWatchedByUser returns repos") {
        coEvery { watchApi.listReposWatchedByUser(username, any(), any()) } returns repos
        runBlocking { watchApi.listReposWatchedByUser(username) shouldBe repos }
    }
})

