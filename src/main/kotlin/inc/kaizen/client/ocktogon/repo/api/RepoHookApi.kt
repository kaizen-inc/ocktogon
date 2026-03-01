package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.common.CreateHookRequest
import inc.kaizen.client.ocktogon.common.Hook
import inc.kaizen.client.ocktogon.common.HookDelivery
import inc.kaizen.client.ocktogon.common.UpdateHookRequest
import retrofit2.Response
import retrofit2.http.*

interface RepoHookApi {

    @GET("/repos/{owner}/{repo}/hooks")
    suspend fun listRepoWebhooks(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Hook>

    @POST("/repos/{owner}/{repo}/hooks")
    suspend fun createRepoWebhook(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateHookRequest? = null
    ): Hook

    @GET("/repos/{owner}/{repo}/hooks/{hook_id}")
    suspend fun getRepoWebhook(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("hook_id") hookId: Long
    ): Hook

    @PATCH("/repos/{owner}/{repo}/hooks/{hook_id}")
    suspend fun updateRepoWebhook(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("hook_id") hookId: Long,
        @Body body: UpdateHookRequest
    ): Hook

    @DELETE("/repos/{owner}/{repo}/hooks/{hook_id}")
    suspend fun deleteRepoWebhook(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("hook_id") hookId: Long
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/hooks/{hook_id}/pings")
    suspend fun pingRepoWebhook(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("hook_id") hookId: Long
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/hooks/{hook_id}/tests")
    suspend fun testRepoWebhook(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("hook_id") hookId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/hooks/{hook_id}/deliveries")
    suspend fun listDeliveriesForRepoWebhook(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("hook_id") hookId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("cursor") cursor: String? = null
    ): List<HookDelivery>

    @GET("/repos/{owner}/{repo}/hooks/{hook_id}/deliveries/{delivery_id}")
    suspend fun getWebhookDelivery(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("hook_id") hookId: Long,
        @Path("delivery_id") deliveryId: Long
    ): HookDelivery

    @POST("/repos/{owner}/{repo}/hooks/{hook_id}/deliveries/{delivery_id}/attempts")
    suspend fun redeliverWebhookDelivery(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("hook_id") hookId: Long,
        @Path("delivery_id") deliveryId: Long
    ): Response<Unit>
}

