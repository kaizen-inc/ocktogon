package inc.kaizen.client.ocktogon.activity.api

import inc.kaizen.client.activity.model.Event
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventApi {

    @GET("/events")
    suspend fun listPublicEvents(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>

    @GET("/repos/{owner}/{repo}/events")
    suspend fun listRepoEvents(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>

    @GET("/orgs/{org}/events")
    suspend fun listPublicOrgEvents(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>

    @GET("/users/{username}/events")
    suspend fun listEventsForAuthenticatedUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>

    @GET("/users/{username}/events/orgs/{org}")
    suspend fun listOrgEventsForAuthenticatedUser(
        @Path("username") username: String,
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>

    @GET("/users/{username}/events/public")
    suspend fun listPublicEventsForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>

    @GET("/networks/{owner}/{repo}/events")
    suspend fun listPublicEventsForRepoNetwork(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>

    @GET("/users/{username}/received_events")
    suspend fun listReceivedEventsForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>

    @GET("/users/{username}/received_events/public")
    suspend fun listPublicReceivedEventsForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Event>
}

