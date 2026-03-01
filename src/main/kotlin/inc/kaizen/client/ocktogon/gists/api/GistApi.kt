package inc.kaizen.client.ocktogon.gists.api

import inc.kaizen.client.ocktogon.gists.model.*
import retrofit2.Response
import retrofit2.http.*

interface GistApi {

    @GET("/gists")
    suspend fun listGistsForAuthenticatedUser(
        @Query("since") since: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Gist>

    @POST("/gists")
    suspend fun createGist(
        @Body body: CreateGistRequest
    ): Gist

    @GET("/gists/public")
    suspend fun listPublicGists(
        @Query("since") since: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Gist>

    @GET("/gists/starred")
    suspend fun listStarredGists(
        @Query("since") since: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Gist>

    @GET("/gists/{gist_id}")
    suspend fun getGist(@Path("gist_id") gistId: String): Gist

    @PATCH("/gists/{gist_id}")
    suspend fun updateGist(
        @Path("gist_id") gistId: String,
        @Body body: UpdateGistRequest
    ): Gist

    @DELETE("/gists/{gist_id}")
    suspend fun deleteGist(@Path("gist_id") gistId: String): Response<Unit>

    @GET("/gists/{gist_id}/commits")
    suspend fun listGistCommits(
        @Path("gist_id") gistId: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<GistCommit>

    @GET("/gists/{gist_id}/forks")
    suspend fun listGistForks(
        @Path("gist_id") gistId: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<GistFork>

    @POST("/gists/{gist_id}/forks")
    suspend fun forkGist(@Path("gist_id") gistId: String): Gist

    @GET("/gists/{gist_id}/star")
    suspend fun checkIfGistIsStarred(@Path("gist_id") gistId: String): Response<Unit>

    @PUT("/gists/{gist_id}/star")
    suspend fun starGist(@Path("gist_id") gistId: String): Response<Unit>

    @DELETE("/gists/{gist_id}/star")
    suspend fun unstarGist(@Path("gist_id") gistId: String): Response<Unit>

    @GET("/gists/{gist_id}/{sha}")
    suspend fun getGistRevision(
        @Path("gist_id") gistId: String,
        @Path("sha") sha: String
    ): Gist

    @GET("/users/{username}/gists")
    suspend fun listGistsForUser(
        @Path("username") username: String,
        @Query("since") since: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Gist>

    @GET("/gists/{gist_id}/comments")
    suspend fun listGistComments(
        @Path("gist_id") gistId: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<GistComment>

    @POST("/gists/{gist_id}/comments")
    suspend fun createGistComment(
        @Path("gist_id") gistId: String,
        @Body body: CreateGistCommentRequest
    ): GistComment

    @GET("/gists/{gist_id}/comments/{comment_id}")
    suspend fun getGistComment(
        @Path("gist_id") gistId: String,
        @Path("comment_id") commentId: Long
    ): GistComment

    @PATCH("/gists/{gist_id}/comments/{comment_id}")
    suspend fun updateGistComment(
        @Path("gist_id") gistId: String,
        @Path("comment_id") commentId: Long,
        @Body body: CreateGistCommentRequest
    ): GistComment

    @DELETE("/gists/{gist_id}/comments/{comment_id}")
    suspend fun deleteGistComment(
        @Path("gist_id") gistId: String,
        @Path("comment_id") commentId: Long
    ): Response<Unit>
}
