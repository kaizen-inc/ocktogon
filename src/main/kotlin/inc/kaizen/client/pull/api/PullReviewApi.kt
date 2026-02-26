package inc.kaizen.client.pull.api

import inc.kaizen.client.pull.model.*
import retrofit2.http.*

interface PullReviewApi {

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/reviews")
    suspend fun listReviews(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<PullReview>

    @POST("/repos/{owner}/{repo}/pulls/{pull_number}/reviews")
    suspend fun createReview(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Body body: CreateReviewRequest
    ): PullReview

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
    suspend fun getReview(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Path("review_id") reviewId: Long
    ): PullReview

    @PUT("/repos/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
    suspend fun updateReview(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Path("review_id") reviewId: Long,
        @Body body: UpdateReviewRequest
    ): PullReview

    @DELETE("/repos/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
    suspend fun deletePendingReview(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Path("review_id") reviewId: Long
    ): PullReview

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/comments")
    suspend fun listCommentsForReview(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Path("review_id") reviewId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<inc.kaizen.client.pull.model.review.ReviewComment>

    @POST("/repos/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/dismissals")
    suspend fun dismissReview(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Path("review_id") reviewId: Long,
        @Body body: DismissReviewRequest
    ): PullReview

    @POST("/repos/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/events")
    suspend fun submitReview(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Path("review_id") reviewId: Long,
        @Body body: SubmitReviewRequest
    ): PullReview

    @POST("/repos/{owner}/{repo}/pulls/{pull_number}/merge")
    suspend fun mergePullRequest(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Body body: MergePullRequestRequest? = null
    ): MergeResult

    @GET("/repos/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
    suspend fun getRequestedReviewers(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int
    ): inc.kaizen.client.pull.model.reviewer.RequestedReviewer

    @POST("/repos/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
    suspend fun requestReviewers(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Body body: RequestReviewersRequest
    ): inc.kaizen.client.pull.model.pull.Pull

    @DELETE("/repos/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
    suspend fun removeRequestedReviewers(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pull_number") pullNumber: Int,
        @Body body: RequestReviewersRequest
    ): inc.kaizen.client.pull.model.pull.Pull
}


