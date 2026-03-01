package inc.kaizen.client.ocktogon.reactions.api

import inc.kaizen.client.reactions.model.CreateReactionRequest
import inc.kaizen.client.reactions.model.Reaction
import retrofit2.Response
import retrofit2.http.*

interface ReactionApi {

    // Commit comment reactions
    @GET("/repos/{owner}/{repo}/comments/{comment_id}/reactions")
    suspend fun listReactionsForCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Query("content") content: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Reaction>

    @POST("/repos/{owner}/{repo}/comments/{comment_id}/reactions")
    suspend fun createReactionForCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Body body: CreateReactionRequest
    ): Reaction

    @DELETE("/repos/{owner}/{repo}/comments/{comment_id}/reactions/{reaction_id}")
    suspend fun deleteReactionForCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Path("reaction_id") reactionId: Long
    ): Response<Unit>

    // Issue reactions
    @GET("/repos/{owner}/{repo}/issues/{issue_number}/reactions")
    suspend fun listReactionsForIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Query("content") content: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Reaction>

    @POST("/repos/{owner}/{repo}/issues/{issue_number}/reactions")
    suspend fun createReactionForIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Body body: CreateReactionRequest
    ): Reaction

    @DELETE("/repos/{owner}/{repo}/issues/{issue_number}/reactions/{reaction_id}")
    suspend fun deleteReactionForIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Path("reaction_id") reactionId: Long
    ): Response<Unit>

    // Issue comment reactions
    @GET("/repos/{owner}/{repo}/issues/comments/{comment_id}/reactions")
    suspend fun listReactionsForIssueComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Query("content") content: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Reaction>

    @POST("/repos/{owner}/{repo}/issues/comments/{comment_id}/reactions")
    suspend fun createReactionForIssueComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Body body: CreateReactionRequest
    ): Reaction

    @DELETE("/repos/{owner}/{repo}/issues/comments/{comment_id}/reactions/{reaction_id}")
    suspend fun deleteReactionForIssueComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Path("reaction_id") reactionId: Long
    ): Response<Unit>

    // Pull request review comment reactions
    @GET("/repos/{owner}/{repo}/pulls/comments/{comment_id}/reactions")
    suspend fun listReactionsForPullRequestReviewComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Query("content") content: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Reaction>

    @POST("/repos/{owner}/{repo}/pulls/comments/{comment_id}/reactions")
    suspend fun createReactionForPullRequestReviewComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Body body: CreateReactionRequest
    ): Reaction

    @DELETE("/repos/{owner}/{repo}/pulls/comments/{comment_id}/reactions/{reaction_id}")
    suspend fun deleteReactionForPullRequestReviewComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Long,
        @Path("reaction_id") reactionId: Long
    ): Response<Unit>

    // Release reactions
    @GET("/repos/{owner}/{repo}/releases/{release_id}/reactions")
    suspend fun listReactionsForRelease(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("release_id") releaseId: Long,
        @Query("content") content: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Reaction>

    @POST("/repos/{owner}/{repo}/releases/{release_id}/reactions")
    suspend fun createReactionForRelease(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("release_id") releaseId: Long,
        @Body body: CreateReactionRequest
    ): Reaction

    @DELETE("/repos/{owner}/{repo}/releases/{release_id}/reactions/{reaction_id}")
    suspend fun deleteReactionForRelease(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("release_id") releaseId: Long,
        @Path("reaction_id") reactionId: Long
    ): Response<Unit>

    // Team discussion reactions
    @GET("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/reactions")
    suspend fun listReactionsForTeamDiscussion(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Query("content") content: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Reaction>

    @POST("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/reactions")
    suspend fun createReactionForTeamDiscussion(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Body body: CreateReactionRequest
    ): Reaction

    @DELETE("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/reactions/{reaction_id}")
    suspend fun deleteReactionForTeamDiscussion(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Path("reaction_id") reactionId: Long
    ): Response<Unit>

    // Team discussion comment reactions
    @GET("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}/reactions")
    suspend fun listReactionsForTeamDiscussionComment(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Path("comment_number") commentNumber: Int,
        @Query("content") content: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Reaction>

    @POST("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}/reactions")
    suspend fun createReactionForTeamDiscussionComment(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Path("comment_number") commentNumber: Int,
        @Body body: CreateReactionRequest
    ): Reaction

    @DELETE("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}/reactions/{reaction_id}")
    suspend fun deleteReactionForTeamDiscussionComment(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Path("comment_number") commentNumber: Int,
        @Path("reaction_id") reactionId: Long
    ): Response<Unit>
}
