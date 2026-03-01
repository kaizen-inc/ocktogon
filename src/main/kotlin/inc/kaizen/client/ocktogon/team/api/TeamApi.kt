package inc.kaizen.client.ocktogon.team.api

import inc.kaizen.client.common.Team
import inc.kaizen.client.team.model.CreateTeamBody
import retrofit2.Response
import retrofit2.http.*

interface TeamApi {

    @GET("/orgs/{org}/teams")
    suspend fun listTeams(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Team>

    @POST("/orgs/{org}/teams")
    suspend fun createTeam(
        @Path("org") org: String,
        @Body team: CreateTeamBody
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
        @Body body: CreateTeamBody
    ): Team

    @DELETE("/orgs/{org}/teams/{team_slug}")
    suspend fun deleteTeam(
        @Path("org") org: String,
        @Path("team_slug") teamSlug: String
    ): Response<Unit>

    @GET("/user/teams")
    suspend fun listTeamsForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Team>
}
