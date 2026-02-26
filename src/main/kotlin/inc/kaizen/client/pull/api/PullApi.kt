package inc.kaizen.client.pull.api

import inc.kaizen.client.pull.model.*
import inc.kaizen.client.pull.model.commit.PullCommit
import inc.kaizen.client.pull.model.file.PullFile
import inc.kaizen.client.pull.model.pull.Pull
import inc.kaizen.client.pull.model.review.ReviewComment
import inc.kaizen.client.pull.model.reviewer.RequestedReviewer
import retrofit2.Response
import retrofit2.http.*

interface PullApi {

    @GET("/repos/{owner}/{repo}/pulls")
    fun getPulls(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
        @Query("state") state: State = State.open,
        @Query("head") head: String,
        @Query("base") base: String,
        @Query("sort") sort: SortType = SortType.created,
        @Query("direction") direction: Direction = Direction.asc,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Pull>

//    @POST("/repos/{owner}/{repo}/pulls")
//    fun createPull(
//        @Path("owner") owner:String,
//        @Path("repo") repo:String
//    )

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}")
    fun getPull(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
        @Path("pull_number") pullNumber:String
    ): Pull

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/commits")
    fun getPullCommits(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
        @Path("pull_number") pullNumber:String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<PullCommit>

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/files")
    fun getPullFiles(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
        @Path("pull_number") pullNumber:String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<PullFile>

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/merge")
    fun isPullMerged(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
        @Path("pull_number") pullNumber:String,
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/pulls/comments")
    fun getRepositoryReviewComments(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
        @Query("sort") sort: SortType = SortType.created,
        @Query("direction") direction: Direction = Direction.asc,
        @Query("since") since: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<ReviewComment>

    @GET("/repos/{owner}/{repo}/pulls/comments/{comment_id}")
    fun getRepositoryReviewComment(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
        @Path("comment_id") commentId:String,
        @Query("sort") sort: SortType = SortType.created,
        @Query("direction") direction: Direction = Direction.asc,
        @Query("since") since: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): ReviewComment

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/comments")
    fun getPullReviewComments(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
        @Path("pull_number") pullNumber:String,
        @Query("sort") sort: SortType = SortType.created,
        @Query("direction") direction: Direction = Direction.asc,
        @Query("since") since: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<ReviewComment>

//    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/comments/{comment_id}")
//    fun getPullReviewComment(
//        @Path("owner") owner:String,
//        @Path("repo") repo:String,
//        @Path("pull_number") pullNumber:String,
//        @Path("comment_id") commentId:String,
//        @Query("sort") sort: SortType = SortType.created,
//        @Query("direction") direction: Direction = Direction.asc,
//        @Query("since") since: String? = null,
//        @Query("per_page") perPage: Int = 30,
//        @Query("page") page : Int = 1
//    ): ReviewComment

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/{requested_reviewers}")
    fun getPullRequestedReviewers(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: String
    ): RequestedReviewer

    @POST("/repos/{owner}/{repo}/pulls")
    suspend fun createPull(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreatePullRequest
    ): Pull

    @PATCH("/repos/{owner}/{repo}/pulls/{pull_number}")
    suspend fun updatePull(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Body body: UpdatePullRequest
    ): Pull

    @PATCH("/repos/{owner}/{repo}/pulls/comments/{comment_id}")
    suspend fun updateReviewComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Body body: UpdateReviewCommentRequest
    ): ReviewComment

    @DELETE("/repos/{owner}/{repo}/pulls/comments/{comment_id}")
    suspend fun deleteReviewComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/pulls/{pull_number}/comments")
    suspend fun createReviewComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Body body: CreateReviewCommentRequest
    ): ReviewComment

    @POST("/repos/{owner}/{repo}/pulls/{pull_number}/comments/{comment_id}/replies")
    suspend fun createReplyForReviewComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Path("comment_id") commentId: Long,
        @Body body: ReplyReviewCommentRequest
    ): ReviewComment
}

