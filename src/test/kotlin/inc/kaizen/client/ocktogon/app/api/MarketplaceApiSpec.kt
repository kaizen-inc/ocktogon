package inc.kaizen.client.ocktogon.app.api

import inc.kaizen.client.app.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class MarketplaceApiSpec : FunSpec({
    val api = mockk<MarketplaceApi>()
    val accountId = 1L
    val planId = 2L
    val account = mockk<MarketplaceAccount>()
    val accounts = listOf(account)
    val plan = mockk<MarketplacePlan>()
    val plans = listOf(plan)
    val purchase = mockk<UserMarketplacePurchase>()
    val purchases = listOf(purchase)

    test("getSubscriptionPlanForAccount returns account") {
        coEvery { api.getSubscriptionPlanForAccount(accountId) } returns account
        runBlocking { api.getSubscriptionPlanForAccount(accountId) } shouldBe account
    }
    test("listPlans returns plans") {
        coEvery { api.listPlans(any(), any()) } returns plans
        runBlocking { api.listPlans() } shouldBe plans
    }
    test("listAccountsForPlan returns accounts") {
        coEvery { api.listAccountsForPlan(planId, any(), any(), any(), any()) } returns accounts
        runBlocking { api.listAccountsForPlan(planId) } shouldBe accounts
    }
    test("getSubscriptionPlanForAccountStubbed returns account") {
        coEvery { api.getSubscriptionPlanForAccountStubbed(accountId) } returns account
        runBlocking { api.getSubscriptionPlanForAccountStubbed(accountId) } shouldBe account
    }
    test("listPlansStubbed returns plans") {
        coEvery { api.listPlansStubbed(any(), any()) } returns plans
        runBlocking { api.listPlansStubbed() } shouldBe plans
    }
    test("listAccountsForPlanStubbed returns accounts") {
        coEvery { api.listAccountsForPlanStubbed(planId, any(), any(), any(), any()) } returns accounts
        runBlocking { api.listAccountsForPlanStubbed(planId) } shouldBe accounts
    }
    test("listSubscriptionsForAuthenticatedUser returns purchases") {
        coEvery { api.listSubscriptionsForAuthenticatedUser(any(), any()) } returns purchases
        runBlocking { api.listSubscriptionsForAuthenticatedUser() } shouldBe purchases
    }
    test("listSubscriptionsForAuthenticatedUserStubbed returns purchases") {
        coEvery { api.listSubscriptionsForAuthenticatedUserStubbed(any(), any()) } returns purchases
        runBlocking { api.listSubscriptionsForAuthenticatedUserStubbed() } shouldBe purchases
    }
})

class OAuthApiSpec : FunSpec({
    val api = mockk<OAuthApi>()
    val clientId = "client123"
    val token = mockk<OAuthToken>()
    val checkReq = CheckTokenRequest(access_token = "gho_abc123")
    val scopedReq = ScopedAccessTokenRequest(access_token = "gho_abc123", target = "my-org")

    test("checkToken returns token") {
        coEvery { api.checkToken(clientId, checkReq) } returns token
        runBlocking { api.checkToken(clientId, checkReq) } shouldBe token
    }
    test("resetToken returns token") {
        coEvery { api.resetToken(clientId, checkReq) } returns token
        runBlocking { api.resetToken(clientId, checkReq) } shouldBe token
    }
    test("createScopedAccessToken returns token") {
        coEvery { api.createScopedAccessToken(clientId, scopedReq) } returns token
        runBlocking { api.createScopedAccessToken(clientId, scopedReq) } shouldBe token
    }
    test("deleteToken returns response") {
        coEvery { api.deleteToken(clientId, checkReq) } returns Response.success(Unit)
        runBlocking { api.deleteToken(clientId, checkReq).isSuccessful } shouldBe true
    }
    test("deleteAuthorization returns response") {
        coEvery { api.deleteAuthorization(clientId, checkReq) } returns Response.success(Unit)
        runBlocking { api.deleteAuthorization(clientId, checkReq).isSuccessful } shouldBe true
    }
})

