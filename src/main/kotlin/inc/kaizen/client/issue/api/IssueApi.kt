package inc.kaizen.client.issue.api

import inc.kaizen.client.issue.model.Filter
import inc.kaizen.client.issue.model.SortComment
import inc.kaizen.client.issue.model.SortIssue
import inc.kaizen.client.issue.model.comment.Comment
import inc.kaizen.client.issue.model.event.Event
import inc.kaizen.client.issue.model.issue.Issue
import inc.kaizen.client.pull.model.Direction
import inc.kaizen.client.pull.model.State
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IssueApi {

    @GET("/issues")
    fun getIssues(
        @Query("filter") filter: Filter = Filter.assigned,
        @Query("state") state: State = State.open,
        @Query("labels") labels: String,
        @Query("sort") sort: SortIssue = SortIssue.created,
        @Query("direction") direction: Direction = Direction.desc,
        @Query("since") since: String,
        @Query("collab") collab: Boolean = false,
        @Query("orgs") orgs: Boolean = false,
        @Query("owned") owned: Boolean = false,
        @Query("pulls") pulls: Boolean = false,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Issue>

    @GET("/orgs/{org}/issues")
    fun getOrgIssues(
        @Path("org") org: String,
        @Query("filter") filter: Filter = Filter.assigned,
        @Query("state") state: State = State.open,
        @Query("labels") labels: String,
        @Query("sort") sort: SortIssue = SortIssue.created,
        @Query("direction") direction: Direction = Direction.desc,
        @Query("since") since: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Issue>

    @GET("/repos/{owner}/{repo}/issues")
    fun getRepoIssues(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("milestone") milestone: String,
        @Query("state") state: State = State.open,
        @Query("assignee") assignee: String,
        @Query("creator") creator: String,
        @Query("mentioned") mentioned: String,
        @Query("labels") labels: String,
        @Query("sort") sort: SortIssue = SortIssue.created,
        @Query("direction") direction: Direction = Direction.desc,
        @Query("since") since: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Issue>

    @GET("/repos/{owner}/{repo}/issues/{issue_number}")
    fun getIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
    ): Issue

    @GET("/user/issues")
    fun getLoggedInUserIssues(
        @Query("filter") filter: Filter = Filter.assigned,
        @Query("state") state: State = State.open,
        @Query("labels") labels: String,
        @Query("sort") sort: SortIssue = SortIssue.created,
        @Query("direction") direction: Direction = Direction.desc,
        @Query("since") since: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Issue>

    @GET("/repos/{owner}/{repo}/issues/comments")
    fun getRepoComments(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("sort") sort: SortComment = SortComment.created,
        @Query("direction") direction: Direction = Direction.desc,
        @Query("since") since: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Comment>

    @GET("/repos/{owner}/{repo}/issues/comments/{comment_id}")
    fun getRepoComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("comment_id") commentId: Int,
    ): Comment

    @GET("/repos/{owner}/{repo}/issues/{issue_number}/comments")
    fun getIssueComments(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Query("since") since: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Comment>

    @GET("/repos/{owner}/{repo}/issues/events")
    fun getRepoIssueEvents(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Event>

    @GET("/repos/{owner}/{repo}/issues/events/{event_id}")
    fun getRepoIssueEvent(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("event_id") eventId: Int,
    ): Event

    @GET("/repos/{owner}/{repo}/issues/{issue_number}/events")
    fun getRepoIssueEvents(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page : Int = 1
    ): List<Event>
}