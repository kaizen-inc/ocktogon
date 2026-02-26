package inc.kaizen.client.repo.api

import inc.kaizen.client.repo.model.*
import retrofit2.Response
import retrofit2.http.*

interface CommitApi {

    @GET("/repos/{owner}/{repo}/commits")
    suspend fun listCommits(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("sha") sha: String? = null,
        @Query("path") path: String? = null,
        @Query("author") author: String? = null,
        @Query("committer") committer: String? = null,
        @Query("since") since: String? = null,
        @Query("until") until: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<RepoCommit>

    @GET("/repos/{owner}/{repo}/commits/{ref}")
    suspend fun getCommit(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref") ref: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30
    ): RepoCommit

    @GET("/repos/{owner}/{repo}/commits/{commit_sha}/branches-where-head")
    suspend fun listBranchesForHeadCommit(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("commit_sha") commitSha: String
    ): List<BranchShort>

    @GET("/repos/{owner}/{repo}/commits/{commit_sha}/comments")
    suspend fun listCommitComments(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("commit_sha") commitSha: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<CommitComment>

    @POST("/repos/{owner}/{repo}/commits/{commit_sha}/comments")
    suspend fun createCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("commit_sha") commitSha: String,
        @Body body: CreateCommitCommentRequest
    ): CommitComment

    @GET("/repos/{owner}/{repo}/comments")
    suspend fun listCommitCommentsForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<CommitComment>

    @GET("/repos/{owner}/{repo}/comments/{comment_id}")
    suspend fun getCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long
    ): CommitComment

    @PATCH("/repos/{owner}/{repo}/comments/{comment_id}")
    suspend fun updateCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Body body: UpdateCommitCommentRequest
    ): CommitComment

    @DELETE("/repos/{owner}/{repo}/comments/{comment_id}")
    suspend fun deleteCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/commits/{ref}/statuses")
    suspend fun listCommitStatuses(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref") ref: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<CommitStatus>

    @POST("/repos/{owner}/{repo}/statuses/{sha}")
    suspend fun createCommitStatus(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("sha") sha: String,
        @Body body: CreateCommitStatusRequest
    ): CommitStatus

    @GET("/repos/{owner}/{repo}/commits/{ref}/status")
    suspend fun getCombinedStatusForRef(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref") ref: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): CombinedCommitStatus

    @GET("/repos/{owner}/{repo}/compare/{basehead}")
    suspend fun compareCommits(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("basehead", encoded = true) basehead: String,
        @Query("diff_url") diffUrl: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30
    ): CommitComparison
}
