package inc.kaizen.client.ocktogon.issue.api

import inc.kaizen.client.ocktogon.user.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AssigneeApi {

    @GET("/repos/{owner}/{repo}/assignees")
    fun getRepoAssignees(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<User>

    @GET("/repos/{owner}/{repo}/assignees/{assignee}")
    fun canUserBeAssigned(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("assignee") assignee: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/issues/{issue_number}/assignees/{assignee}")
    fun canUserBeAssignedToIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Query("assignee") assignee: String
    ): Response<Unit>
}