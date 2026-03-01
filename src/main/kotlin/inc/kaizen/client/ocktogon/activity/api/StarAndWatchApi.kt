package inc.kaizen.client.ocktogon.activity.api

import inc.kaizen.client.ocktogon.activity.model.RepoSubscription
import inc.kaizen.client.ocktogon.activity.model.SetRepoSubscriptionRequest
import inc.kaizen.client.ocktogon.common.Repository
import inc.kaizen.client.ocktogon.common.User
import retrofit2.Response
import retrofit2.http.*

interface StarApi {

    @GET("/repos/{owner}/{repo}/stargazers")
    suspend fun listStargazers(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/user/starred")
    suspend fun listReposStarredByAuthenticatedUser(
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>

    @GET("/users/{username}/starred")
    suspend fun listReposStarredByUser(
        @Path("username") username: String,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>

    @GET("/user/starred/{owner}/{repo}")
    suspend fun checkIfRepoIsStarredByAuthenticatedUser(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @PUT("/user/starred/{owner}/{repo}")
    suspend fun starRepoForAuthenticatedUser(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @DELETE("/user/starred/{owner}/{repo}")
    suspend fun unstarRepoForAuthenticatedUser(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>
}

interface WatchApi {

    @GET("/repos/{owner}/{repo}/subscribers")
    suspend fun listWatchers(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/repos/{owner}/{repo}/subscription")
    suspend fun getRepoSubscription(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): RepoSubscription

    @PUT("/repos/{owner}/{repo}/subscription")
    suspend fun setRepoSubscription(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: SetRepoSubscriptionRequest
    ): RepoSubscription

    @DELETE("/repos/{owner}/{repo}/subscription")
    suspend fun deleteRepoSubscription(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @GET("/user/subscriptions")
    suspend fun listReposWatchedByAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>

    @GET("/users/{username}/subscriptions")
    suspend fun listReposWatchedByUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>
}

