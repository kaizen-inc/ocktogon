package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.repo.model.RepoInvitation
import inc.kaizen.client.ocktogon.repo.model.UpdateInvitationRequest
import retrofit2.Response
import retrofit2.http.*

interface RepoInvitationApi {

    @GET("/repos/{owner}/{repo}/invitations")
    suspend fun listRepoInvitations(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<RepoInvitation>

    @PATCH("/repos/{owner}/{repo}/invitations/{invitation_id}")
    suspend fun updateRepoInvitation(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("invitation_id") invitationId: Long,
        @Body body: UpdateInvitationRequest
    ): RepoInvitation

    @DELETE("/repos/{owner}/{repo}/invitations/{invitation_id}")
    suspend fun deleteRepoInvitation(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("invitation_id") invitationId: Long
    ): Response<Unit>

    @GET("/user/repository_invitations")
    suspend fun listRepoInvitationsForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<RepoInvitation>

    @PATCH("/user/repository_invitations/{invitation_id}")
    suspend fun acceptRepoInvitation(
        @Path("invitation_id") invitationId: Long
    ): Response<Unit>

    @DELETE("/user/repository_invitations/{invitation_id}")
    suspend fun declineRepoInvitation(
        @Path("invitation_id") invitationId: Long
    ): Response<Unit>
}
