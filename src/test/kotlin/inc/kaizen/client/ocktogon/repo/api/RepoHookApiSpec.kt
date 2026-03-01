package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.common.CreateHookRequest
import inc.kaizen.client.ocktogon.common.Hook
import inc.kaizen.client.ocktogon.common.HookDelivery
import inc.kaizen.client.ocktogon.common.UpdateHookRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class RepoHookApiSpec : FunSpec({
    val api = mockk<RepoHookApi>()
    val owner = "owner"; val repo = "repo"; val hookId = 1L; val deliveryId = 2L
    val hook = mockk<Hook>()
    val delivery = mockk<HookDelivery>()
    val createReq = mockk<CreateHookRequest>()
    val updateReq = mockk<UpdateHookRequest>()

    test("listRepoWebhooks returns hooks") {
        coEvery { api.listRepoWebhooks(owner, repo, any(), any()) } returns listOf(hook)
        runBlocking { api.listRepoWebhooks(owner, repo) } shouldBe listOf(hook)
    }
    test("createRepoWebhook returns hook") {
        coEvery { api.createRepoWebhook(owner, repo, any()) } returns hook
        runBlocking { api.createRepoWebhook(owner, repo, createReq) } shouldBe hook
    }
    test("getRepoWebhook returns hook") {
        coEvery { api.getRepoWebhook(owner, repo, hookId) } returns hook
        runBlocking { api.getRepoWebhook(owner, repo, hookId) } shouldBe hook
    }
    test("updateRepoWebhook returns hook") {
        coEvery { api.updateRepoWebhook(owner, repo, hookId, updateReq) } returns hook
        runBlocking { api.updateRepoWebhook(owner, repo, hookId, updateReq) } shouldBe hook
    }
    test("deleteRepoWebhook returns response") {
        coEvery { api.deleteRepoWebhook(owner, repo, hookId) } returns Response.success(Unit)
        runBlocking { api.deleteRepoWebhook(owner, repo, hookId).isSuccessful } shouldBe true
    }
    test("pingRepoWebhook returns response") {
        coEvery { api.pingRepoWebhook(owner, repo, hookId) } returns Response.success(Unit)
        runBlocking { api.pingRepoWebhook(owner, repo, hookId).isSuccessful } shouldBe true
    }
    test("testRepoWebhook returns response") {
        coEvery { api.testRepoWebhook(owner, repo, hookId) } returns Response.success(Unit)
        runBlocking { api.testRepoWebhook(owner, repo, hookId).isSuccessful } shouldBe true
    }
    test("listDeliveriesForRepoWebhook returns deliveries") {
        coEvery { api.listDeliveriesForRepoWebhook(owner, repo, hookId, any(), any()) } returns listOf(delivery)
        runBlocking { api.listDeliveriesForRepoWebhook(owner, repo, hookId) } shouldBe listOf(delivery)
    }
    test("getWebhookDelivery returns delivery") {
        coEvery { api.getWebhookDelivery(owner, repo, hookId, deliveryId) } returns delivery
        runBlocking { api.getWebhookDelivery(owner, repo, hookId, deliveryId) } shouldBe delivery
    }
    test("redeliverWebhookDelivery returns response") {
        coEvery { api.redeliverWebhookDelivery(owner, repo, hookId, deliveryId) } returns Response.success(Unit)
        runBlocking { api.redeliverWebhookDelivery(owner, repo, hookId, deliveryId).isSuccessful } shouldBe true
    }
})

