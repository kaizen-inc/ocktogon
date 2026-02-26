package inc.kaizen.client.collaborator.api

import inc.kaizen.client.collaborator.model.Affiliation
import inc.kaizen.client.collaborator.model.CollaboratorPermission
import inc.kaizen.client.collaborator.model.Permission
import inc.kaizen.client.user.model.User
import retrofit2.Response
import retrofit2.http.*

interface CollaboratorApi {

    @GET("repos/{owner}/{repo}/collaborators")
    suspend fun getRepoCollaborators(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("affiliation") affiliation: Affiliation = Affiliation.all,
        @Query("permission") permission: Permission? = null
    ): List<User>

    @GET("repos/{owner}/{repo}/collaborators/{username}")
    suspend fun isUserACollaborator(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("username") username: String,
    ): Response<Unit>

    @POST("repos/{owner}/{repo}/collaborators/{username}")
    suspend fun addUserAsCollaborator(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("username") username: String,
        @Body permission: Permission = Permission.push
    ): User

    @DELETE("repos/{owner}/{repo}/collaborators/{username}")
    suspend fun removeUserAsCollaborator(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("username") username: String,
    ): Response<Unit>

    @GET("repos/{owner}/{repo}/collaborators/{username}/permission")
    suspend fun getCollaboratorPermission(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("username") username: String,
    ): CollaboratorPermission
}