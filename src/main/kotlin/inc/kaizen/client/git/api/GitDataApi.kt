package inc.kaizen.client.git.api

import inc.kaizen.client.git.model.*
import retrofit2.Response
import retrofit2.http.*

interface GitDataApi {

    // Blobs
    @GET("/repos/{owner}/{repo}/git/blobs/{file_sha}")
    suspend fun getBlob(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("file_sha") fileSha: String
    ): GitBlob

    @POST("/repos/{owner}/{repo}/git/blobs")
    suspend fun createBlob(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateBlobRequest
    ): GitBlobRef

    // Commits
    @GET("/repos/{owner}/{repo}/git/commits/{commit_sha}")
    suspend fun getCommit(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("commit_sha") commitSha: String
    ): GitCommit

    @POST("/repos/{owner}/{repo}/git/commits")
    suspend fun createCommit(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateGitCommitRequest
    ): GitCommit

    // References
    @GET("/repos/{owner}/{repo}/git/ref/{ref}")
    suspend fun getRef(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref", encoded = true) ref: String
    ): GitRef

    @GET("/repos/{owner}/{repo}/git/matching-refs/{ref}")
    suspend fun listMatchingRefs(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref", encoded = true) ref: String
    ): List<GitRef>

    @POST("/repos/{owner}/{repo}/git/refs")
    suspend fun createRef(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateRefRequest
    ): GitRef

    @PATCH("/repos/{owner}/{repo}/git/refs/{ref}")
    suspend fun updateRef(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref", encoded = true) ref: String,
        @Body body: UpdateRefRequest
    ): GitRef

    @DELETE("/repos/{owner}/{repo}/git/refs/{ref}")
    suspend fun deleteRef(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref", encoded = true) ref: String
    ): Response<Unit>

    // Tags
    @GET("/repos/{owner}/{repo}/git/tags/{tag_sha}")
    suspend fun getTag(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("tag_sha") tagSha: String
    ): GitTag

    @POST("/repos/{owner}/{repo}/git/tags")
    suspend fun createTag(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateTagRequest
    ): GitTag

    // Trees
    @GET("/repos/{owner}/{repo}/git/trees/{tree_sha}")
    suspend fun getTree(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("tree_sha") treeSha: String,
        @Query("recursive") recursive: String? = null
    ): GitTree

    @POST("/repos/{owner}/{repo}/git/trees")
    suspend fun createTree(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateTreeRequest
    ): GitTree
}

