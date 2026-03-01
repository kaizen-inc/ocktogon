package inc.kaizen.client.ocktogon.action.api

import inc.kaizen.client.ocktogon.action.model.artifact.Artifact
import inc.kaizen.client.ocktogon.action.model.artifact.Artifacts
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtifactApi {

    @GET("/repos/{owner}/{repo}/actions/artifacts")
    suspend fun getRepoArtifacts(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("name") name: String? = null
    ): Artifacts

    @GET("/repos/{owner}/{repo}/actions/artifacts/{artifact_id}")
    suspend fun getRepoArtifact(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("artifact_id") artifactId: String
    ): Artifact

    @DELETE("/repos/{owner}/{repo}/actions/artifacts/{artifact_id}")
    suspend fun deleteRepoArtifact(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("artifact_id") artifactId: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/artifacts/{artifact_id}/{archive_format}")
    suspend fun downloadRepoArtifact(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("artifact_id") artifactId: String,
        @Path("archive_format") archiveFormat : String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/artifacts")
    suspend fun getWorkflowRunRepoArtifacts(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("name") name: String? = null
    ): Artifacts
}