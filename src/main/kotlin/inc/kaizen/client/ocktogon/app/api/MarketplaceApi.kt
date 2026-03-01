package inc.kaizen.client.ocktogon.app.api

import inc.kaizen.client.app.model.*
import retrofit2.Response
import retrofit2.http.*

interface MarketplaceApi {

    @GET("/marketplace_listing/accounts/{account_id}")
    suspend fun getSubscriptionPlanForAccount(
        @Path("account_id") accountId: Long
    ): MarketplaceAccount

    @GET("/marketplace_listing/plans")
    suspend fun listPlans(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<MarketplacePlan>

    @GET("/marketplace_listing/plans/{plan_id}/accounts")
    suspend fun listAccountsForPlan(
        @Path("plan_id") planId: Long,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<MarketplaceAccount>

    @GET("/marketplace_listing/stubbed/accounts/{account_id}")
    suspend fun getSubscriptionPlanForAccountStubbed(
        @Path("account_id") accountId: Long
    ): MarketplaceAccount

    @GET("/marketplace_listing/stubbed/plans")
    suspend fun listPlansStubbed(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<MarketplacePlan>

    @GET("/marketplace_listing/stubbed/plans/{plan_id}/accounts")
    suspend fun listAccountsForPlanStubbed(
        @Path("plan_id") planId: Long,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<MarketplaceAccount>

    @GET("/user/marketplace_purchases")
    suspend fun listSubscriptionsForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<UserMarketplacePurchase>

    @GET("/user/marketplace_purchases/stubbed")
    suspend fun listSubscriptionsForAuthenticatedUserStubbed(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<UserMarketplacePurchase>
}

interface OAuthApi {

    @POST("/applications/{client_id}/token")
    suspend fun checkToken(
        @Path("client_id") clientId: String,
        @Body body: CheckTokenRequest
    ): OAuthToken

    @PATCH("/applications/{client_id}/token")
    suspend fun resetToken(
        @Path("client_id") clientId: String,
        @Body body: CheckTokenRequest
    ): OAuthToken

    @POST("/applications/{client_id}/token/scoped")
    suspend fun createScopedAccessToken(
        @Path("client_id") clientId: String,
        @Body body: ScopedAccessTokenRequest
    ): OAuthToken

    @DELETE("/applications/{client_id}/token")
    suspend fun deleteToken(
        @Path("client_id") clientId: String,
        @Body body: CheckTokenRequest
    ): Response<Unit>

    @DELETE("/applications/{client_id}/grant")
    suspend fun deleteAuthorization(
        @Path("client_id") clientId: String,
        @Body body: CheckTokenRequest
    ): Response<Unit>
}
