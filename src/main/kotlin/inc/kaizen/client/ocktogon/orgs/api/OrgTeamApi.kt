package inc.kaizen.client.ocktogon.orgs.api

import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.Team
import inc.kaizen.client.common.User
import inc.kaizen.client.orgs.model.*
import retrofit2.Response
import retrofit2.http.*

interface OrgTeamApi {

    @GET("/orgs/{org}/teams")
    suspend fun listTeams(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Team>

    @POST("/orgs/{org}/teams")
    suspend fun createTeam(
        @Path("org") org: String,
        @Body body: CreateTeamRequest
    ): Team

    @GET("/orgs/{org}/teams/{team_slug}")
    suspend fun getTeamByName(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String
    ): Team

    @PATCH("/orgs/{org}/teams/{team_slug}")
    suspend fun updateTeam(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Body body: UpdateTeamRequest
    ): Team

    @DELETE("/orgs/{org}/teams/{team_slug}")
    suspend fun deleteTeam(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String
    ): Response<Unit>

    @GET("/orgs/{org}/teams/{team_slug}/members")
    suspend fun listTeamMembers(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Query("role") role: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/orgs/{org}/teams/{team_slug}/memberships/{username}")
    suspend fun getTeamMembership(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("username") username: String
    ): TeamMembership

    @PUT("/orgs/{org}/teams/{team_slug}/memberships/{username}")
    suspend fun addOrUpdateTeamMembership(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("username") username: String,
        @Body body: TeamMembershipRequest? = null
    ): TeamMembership

    @DELETE("/orgs/{org}/teams/{team_slug}/memberships/{username}")
    suspend fun removeTeamMembership(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("username") username: String
    ): Response<Unit>

    @GET("/orgs/{org}/teams/{team_slug}/repos")
    suspend fun listTeamRepos(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>

    @GET("/orgs/{org}/teams/{team_slug}/repos/{owner}/{repo}")
    suspend fun checkTeamPermissionsForRepo(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Repository

    @PUT("/orgs/{org}/teams/{team_slug}/repos/{owner}/{repo}")
    suspend fun addOrUpdateTeamRepoPermissions(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: TeamRepoPermissionRequest? = null
    ): Response<Unit>

    @DELETE("/orgs/{org}/teams/{team_slug}/repos/{owner}/{repo}")
    suspend fun removeTeamRepoPermissions(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @GET("/orgs/{org}/teams/{team_slug}/teams")
    suspend fun listChildTeams(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Team>

    @GET("/orgs/{org}/teams/{team_slug}/discussions")
    suspend fun listDiscussions(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("pinned") pinned: String? = null
    ): List<TeamDiscussion>

    @POST("/orgs/{org}/teams/{team_slug}/discussions")
    suspend fun createDiscussion(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Body body: CreateDiscussionRequest
    ): TeamDiscussion

    @GET("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}")
    suspend fun getDiscussion(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int
    ): TeamDiscussion

    @PATCH("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}")
    suspend fun updateDiscussion(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Body body: UpdateDiscussionRequest
    ): TeamDiscussion

    @DELETE("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}")
    suspend fun deleteDiscussion(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int
    ): Response<Unit>

    @GET("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/comments")
    suspend fun listDiscussionComments(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<TeamDiscussionComment>

    @POST("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/comments")
    suspend fun createDiscussionComment(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Body body: CreateDiscussionCommentRequest
    ): TeamDiscussionComment

    @GET("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}")
    suspend fun getDiscussionComment(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Path("comment_number") commentNumber: Int
    ): TeamDiscussionComment

    @PATCH("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}")
    suspend fun updateDiscussionComment(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Path("comment_number") commentNumber: Int,
        @Body body: CreateDiscussionCommentRequest
    ): TeamDiscussionComment

    @DELETE("/orgs/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}")
    suspend fun deleteDiscussionComment(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String,
        @Path("discussion_number") discussionNumber: Int,
        @Path("comment_number") commentNumber: Int
    ): Response<Unit>

    @GET("/user/teams")
    suspend fun listTeamsForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Team>
}

