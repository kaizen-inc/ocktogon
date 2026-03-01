package inc.kaizen.client.ocktogon.activity.api

import inc.kaizen.client.ocktogon.activity.model.MarkNotificationsRequest
import inc.kaizen.client.ocktogon.activity.model.Notification
import inc.kaizen.client.ocktogon.activity.model.ThreadSubscription
import inc.kaizen.client.ocktogon.activity.model.ThreadSubscriptionRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class NotificationApiSpec : FunSpec({
    val api = mockk<NotificationApi>()
    val threadId = 1L
    val owner = "owner"; val repo = "repo"
    val notification = mockk<Notification>()
    val notifications = listOf(notification)
    val subscription = mockk<ThreadSubscription>()
    val subRequest = ThreadSubscriptionRequest(subscribed = true)
    val markRequest = MarkNotificationsRequest(read = true)

    test("listNotificationsForAuthenticatedUser returns list") {
        coEvery { api.listNotificationsForAuthenticatedUser(any(), any(), any(), any(), any(), any()) } returns notifications
        runBlocking { api.listNotificationsForAuthenticatedUser() shouldBe notifications }
    }
    test("markNotificationsAsRead returns response") {
        coEvery { api.markNotificationsAsRead(any()) } returns Response.success(Unit)
        runBlocking { api.markNotificationsAsRead(markRequest).isSuccessful shouldBe true }
    }
    test("listRepoNotificationsForAuthenticatedUser returns list") {
        coEvery { api.listRepoNotificationsForAuthenticatedUser(owner, repo, any(), any(), any(), any(), any(), any()) } returns notifications
        runBlocking { api.listRepoNotificationsForAuthenticatedUser(owner, repo) shouldBe notifications }
    }
    test("markRepoNotificationsAsRead returns response") {
        coEvery { api.markRepoNotificationsAsRead(owner, repo, any()) } returns Response.success(Unit)
        runBlocking { api.markRepoNotificationsAsRead(owner, repo).isSuccessful shouldBe true }
    }
    test("getThread returns notification") {
        coEvery { api.getThread(threadId) } returns notification
        runBlocking { api.getThread(threadId) shouldBe notification }
    }
    test("markThreadAsRead returns response") {
        coEvery { api.markThreadAsRead(threadId) } returns Response.success(Unit)
        runBlocking { api.markThreadAsRead(threadId).isSuccessful shouldBe true }
    }
    test("markThreadAsDone returns response") {
        coEvery { api.markThreadAsDone(threadId) } returns Response.success(Unit)
        runBlocking { api.markThreadAsDone(threadId).isSuccessful shouldBe true }
    }
    test("getThreadSubscription returns subscription") {
        coEvery { api.getThreadSubscription(threadId) } returns subscription
        runBlocking { api.getThreadSubscription(threadId) shouldBe subscription }
    }
    test("setThreadSubscription returns subscription") {
        coEvery { api.setThreadSubscription(threadId, subRequest) } returns subscription
        runBlocking { api.setThreadSubscription(threadId, subRequest) shouldBe subscription }
    }
    test("deleteThreadSubscription returns response") {
        coEvery { api.deleteThreadSubscription(threadId) } returns Response.success(Unit)
        runBlocking { api.deleteThreadSubscription(threadId).isSuccessful shouldBe true }
    }
})

