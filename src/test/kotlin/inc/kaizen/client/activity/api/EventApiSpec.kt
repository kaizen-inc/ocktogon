package inc.kaizen.client.activity.api

import inc.kaizen.client.activity.model.Event
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class EventApiSpec : FunSpec({
    val api = mockk<EventApi>()
    val owner = "owner"; val repo = "repo"; val org = "my-org"; val username = "octocat"
    val events = listOf<Event>()

    test("listPublicEvents returns events") {
        coEvery { api.listPublicEvents(any(), any()) } returns events
        runBlocking { api.listPublicEvents() shouldBe events }
    }
    test("listRepoEvents returns events") {
        coEvery { api.listRepoEvents(owner, repo, any(), any()) } returns events
        runBlocking { api.listRepoEvents(owner, repo) shouldBe events }
    }
    test("listPublicOrgEvents returns events") {
        coEvery { api.listPublicOrgEvents(org, any(), any()) } returns events
        runBlocking { api.listPublicOrgEvents(org) shouldBe events }
    }
    test("listEventsForAuthenticatedUser returns events") {
        coEvery { api.listEventsForAuthenticatedUser(username, any(), any()) } returns events
        runBlocking { api.listEventsForAuthenticatedUser(username) shouldBe events }
    }
    test("listOrgEventsForAuthenticatedUser returns events") {
        coEvery { api.listOrgEventsForAuthenticatedUser(username, org, any(), any()) } returns events
        runBlocking { api.listOrgEventsForAuthenticatedUser(username, org) shouldBe events }
    }
    test("listPublicEventsForUser returns events") {
        coEvery { api.listPublicEventsForUser(username, any(), any()) } returns events
        runBlocking { api.listPublicEventsForUser(username) shouldBe events }
    }
    test("listPublicEventsForRepoNetwork returns events") {
        coEvery { api.listPublicEventsForRepoNetwork(owner, repo, any(), any()) } returns events
        runBlocking { api.listPublicEventsForRepoNetwork(owner, repo) shouldBe events }
    }
    test("listReceivedEventsForUser returns events") {
        coEvery { api.listReceivedEventsForUser(username, any(), any()) } returns events
        runBlocking { api.listReceivedEventsForUser(username) shouldBe events }
    }
    test("listPublicReceivedEventsForUser returns events") {
        coEvery { api.listPublicReceivedEventsForUser(username, any(), any()) } returns events
        runBlocking { api.listPublicReceivedEventsForUser(username) shouldBe events }
    }
})

