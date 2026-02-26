package inc.kaizen.client.issue.api

import inc.kaizen.client.common.Label
import inc.kaizen.client.common.Milestone
import inc.kaizen.client.common.User
import inc.kaizen.client.issue.model.AddLabelsRequest
import inc.kaizen.client.issue.model.AssigneesRequest
import inc.kaizen.client.issue.model.LabelRequest
import inc.kaizen.client.issue.model.MilestoneRequest
import retrofit2.Response
import retrofit2.http.*

interface IssueLabelApi {

    @GET("/repos/{owner}/{repo}/labels")
    suspend fun listLabelsForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Label>

    @POST("/repos/{owner}/{repo}/labels")
    suspend fun createLabel(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: LabelRequest
    ): Label

    @GET("/repos/{owner}/{repo}/labels/{name}")
    suspend fun getLabel(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("name") name: String
    ): Label

    @PATCH("/repos/{owner}/{repo}/labels/{name}")
    suspend fun updateLabel(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("name") name: String,
        @Body body: LabelRequest
    ): Label

    @DELETE("/repos/{owner}/{repo}/labels/{name}")
    suspend fun deleteLabel(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("name") name: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/issues/{issue_number}/labels")
    suspend fun listLabelsForIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Label>

    @POST("/repos/{owner}/{repo}/issues/{issue_number}/labels")
    suspend fun addLabelsToIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Body body: AddLabelsRequest
    ): List<Label>

    @PUT("/repos/{owner}/{repo}/issues/{issue_number}/labels")
    suspend fun setLabelsForIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Body body: AddLabelsRequest
    ): List<Label>

    @DELETE("/repos/{owner}/{repo}/issues/{issue_number}/labels")
    suspend fun removeAllLabelsFromIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int
    ): Response<Unit>

    @DELETE("/repos/{owner}/{repo}/issues/{issue_number}/labels/{name}")
    suspend fun removeLabelFromIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Path("name") name: String
    ): List<Label>

    @GET("/repos/{owner}/{repo}/milestones/{milestone_number}/labels")
    suspend fun listLabelsForMilestone(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("milestone_number") milestoneNumber: Int,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Label>
}

interface IssueMilestoneApi {

    @GET("/repos/{owner}/{repo}/milestones")
    suspend fun listMilestones(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("state") state: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Milestone>

    @POST("/repos/{owner}/{repo}/milestones")
    suspend fun createMilestone(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: MilestoneRequest
    ): Milestone

    @GET("/repos/{owner}/{repo}/milestones/{milestone_number}")
    suspend fun getMilestone(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("milestone_number") milestoneNumber: Int
    ): Milestone

    @PATCH("/repos/{owner}/{repo}/milestones/{milestone_number}")
    suspend fun updateMilestone(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("milestone_number") milestoneNumber: Int,
        @Body body: MilestoneRequest
    ): Milestone

    @DELETE("/repos/{owner}/{repo}/milestones/{milestone_number}")
    suspend fun deleteMilestone(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("milestone_number") milestoneNumber: Int
    ): Response<Unit>
}

interface IssueAssigneeApi {

    @GET("/repos/{owner}/{repo}/assignees")
    suspend fun listAssignees(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/repos/{owner}/{repo}/assignees/{assignee}")
    suspend fun checkUserCanBeAssigned(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("assignee") assignee: String
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/issues/{issue_number}/assignees")
    suspend fun addAssignees(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Body body: AssigneesRequest
    ): inc.kaizen.client.issue.model.issue.Issue

    @DELETE("/repos/{owner}/{repo}/issues/{issue_number}/assignees")
    suspend fun removeAssignees(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Body body: AssigneesRequest
    ): inc.kaizen.client.issue.model.issue.Issue

    @GET("/repos/{owner}/{repo}/issues/{issue_number}/assignees/{assignee}")
    suspend fun checkUserCanBeAssignedToIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Path("assignee") assignee: String
    ): Response<Unit>
}

interface IssueTimelineApi {

    @GET("/repos/{owner}/{repo}/issues/{issue_number}/timeline")
    suspend fun listTimelineEvents(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Any>
}


