package inc.kaizen.client.ocktogon.activity.api

import inc.kaizen.client.activity.model.MarkNotificationsRequest
import inc.kaizen.client.activity.model.Notification
import inc.kaizen.client.activity.model.ThreadSubscription
import inc.kaizen.client.activity.model.ThreadSubscriptionRequest
import retrofit2.Response
import retrofit2.http.*

interface NotificationApi {

    @GET("/notifications")
    suspend fun listNotificationsForAuthenticatedUser(
        @Query("all") all: Boolean? = null,
        @Query("participating") participating: Boolean? = null,
        @Query("since") since: String? = null,
        @Query("before") before: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 50
    ): List<Notification>

    @PUT("/notifications")
    suspend fun markNotificationsAsRead(
        @Body body: MarkNotificationsRequest? = null
    ): Response<Any>

    @GET("/repos/{owner}/{repo}/notifications")
    suspend fun listRepoNotificationsForAuthenticatedUser(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("all") all: Boolean? = null,
        @Query("participating") participating: Boolean? = null,
        @Query("since") since: String? = null,
        @Query("before") before: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Notification>

    @PUT("/repos/{owner}/{repo}/notifications")
    suspend fun markRepoNotificationsAsRead(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: MarkNotificationsRequest? = null
    ): Response<Any>

    @GET("/notifications/threads/{thread_id}")
    suspend fun getThread(
        @Path("thread_id") threadId: Long
    ): Notification

    @PATCH("/notifications/threads/{thread_id}")
    suspend fun markThreadAsRead(
        @Path("thread_id") threadId: Long
    ): Response<Unit>

    @DELETE("/notifications/threads/{thread_id}")
    suspend fun markThreadAsDone(
        @Path("thread_id") threadId: Long
    ): Response<Unit>

    @GET("/notifications/threads/{thread_id}/subscription")
    suspend fun getThreadSubscription(
        @Path("thread_id") threadId: Long
    ): ThreadSubscription

    @PUT("/notifications/threads/{thread_id}/subscription")
    suspend fun setThreadSubscription(
        @Path("thread_id") threadId: Long,
        @Body body: ThreadSubscriptionRequest
    ): ThreadSubscription

    @DELETE("/notifications/threads/{thread_id}/subscription")
    suspend fun deleteThreadSubscription(
        @Path("thread_id") threadId: Long
    ): Response<Unit>
}


