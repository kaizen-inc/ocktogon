package inc.kaizen.client.ocktogon.releases.api

import inc.kaizen.client.ocktogon.releases.model.Release
import inc.kaizen.client.ocktogon.releases.model.ReleaseNotes
import inc.kaizen.client.ocktogon.releases.model.ReleaseNotesRequest
import inc.kaizen.client.ocktogon.releases.model.ReleaseRequest
import retrofit2.Response
import retrofit2.http.*

interface ReleaseApi {
    // List releases
    @GET("/repos/{owner}/{repo}/releases")
    suspend fun listReleases(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Response<List<Release>>

    // Create a release
    @POST("/repos/{owner}/{repo}/releases")
    suspend fun createRelease(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: ReleaseRequest
    ): Response<Release>

    // Create a release notes content for release
    @POST("/repos/{owner}/{repo}/releases/generate-notes")
    suspend fun createReleaseNotes(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: ReleaseNotesRequest
    ): Response<ReleaseNotes>

    // Get the latest release
    @GET("/repos/{owner}/{repo}/releases/latest")
    suspend fun getLatestRelease(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Release>

    // Get a release by tag name
    @GET("/repos/{owner}/{repo}/releases/tags/{tag}")
    suspend fun getReleaseByTag(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("tag") tag: String
    ): Response<Release>

    // Get a release
    @GET("/repos/{owner}/{repo}/releases/{release_id}")
    suspend fun getRelease(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("release_id") releaseId: Long
    ): Response<Release>

    // Update a release
    @PATCH("/repos/{owner}/{repo}/releases/{release_id}")
    suspend fun updateRelease(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("release_id") releaseId: Long,
        @Body body: ReleaseRequest // TODO: generate_release_notes is not supported
    ): Response<Release>

    // Delete a release
    @DELETE("/repos/{owner}/{repo}/releases/{release_id}")
    suspend fun deleteRelease(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("release_id") releaseId: Long
    ): Response<Unit>

    // Upload a release asset (handled separately, not a standard JSON endpoint)
}
