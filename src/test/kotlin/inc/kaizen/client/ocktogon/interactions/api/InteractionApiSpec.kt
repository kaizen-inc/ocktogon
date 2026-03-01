package inc.kaizen.client.ocktogon.interactions.api

import inc.kaizen.client.ocktogon.interactions.model.InteractionLimit
import inc.kaizen.client.ocktogon.interactions.model.SetInteractionLimitRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class InteractionApiSpec : FunSpec({
    val api = mockk<InteractionApi>()
    val org = "my-org"; val owner = "owner"; val repo = "repo"
    val limit = InteractionLimit(limit = "collaborators_only", origin = "repository")
    val req = SetInteractionLimitRequest(limit = "collaborators_only")

    test("getOrgInteractionRestrictions returns limit") {
        coEvery { api.getOrgInteractionRestrictions(org) } returns limit
        runBlocking { api.getOrgInteractionRestrictions(org) shouldBe limit }
    }
    test("setOrgInteractionRestrictions returns limit") {
        coEvery { api.setOrgInteractionRestrictions(org, req) } returns limit
        runBlocking { api.setOrgInteractionRestrictions(org, req) shouldBe limit }
    }
    test("removeOrgInteractionRestrictions returns response") {
        coEvery { api.removeOrgInteractionRestrictions(org) } returns Response.success(Unit)
        runBlocking { api.removeOrgInteractionRestrictions(org).isSuccessful shouldBe true }
    }
    test("getRepoInteractionRestrictions returns limit") {
        coEvery { api.getRepoInteractionRestrictions(owner, repo) } returns limit
        runBlocking { api.getRepoInteractionRestrictions(owner, repo) shouldBe limit }
    }
    test("setRepoInteractionRestrictions returns limit") {
        coEvery { api.setRepoInteractionRestrictions(owner, repo, req) } returns limit
        runBlocking { api.setRepoInteractionRestrictions(owner, repo, req) shouldBe limit }
    }
    test("removeRepoInteractionRestrictions returns response") {
        coEvery { api.removeRepoInteractionRestrictions(owner, repo) } returns Response.success(Unit)
        runBlocking { api.removeRepoInteractionRestrictions(owner, repo).isSuccessful shouldBe true }
    }
    test("getUserInteractionRestrictions returns limit") {
        coEvery { api.getUserInteractionRestrictions() } returns limit
        runBlocking { api.getUserInteractionRestrictions() shouldBe limit }
    }
    test("setUserInteractionRestrictions returns limit") {
        coEvery { api.setUserInteractionRestrictions(req) } returns limit
        runBlocking { api.setUserInteractionRestrictions(req) shouldBe limit }
    }
    test("removeUserInteractionRestrictions returns response") {
        coEvery { api.removeUserInteractionRestrictions() } returns Response.success(Unit)
        runBlocking { api.removeUserInteractionRestrictions().isSuccessful shouldBe true }
    }
})

