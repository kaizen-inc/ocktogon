package inc.kaizen.client.team.api

import inc.kaizen.client.pull.model.reviewer.Team
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @GET("/orgs/{org}/teams")
    suspend fun getOrganizationTeams(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Team>

    @POST("/orgs/{org}/teams")
    suspend fun getOrganizationTeams(
        @Path("org") org: String,
        @Body team: Team
    ): List<Team>


     @GET("/orgs/{org}/teams/{team_slug}")
    suspend fun getOrganizationTeamByName(
        @Path("org") org: String,
        @Path("team_slug") team_slug: String,
    ): Team
}