package inc.kaizen.client.ocktogon.orgs.api

import inc.kaizen.client.common.*
import inc.kaizen.client.orgs.model.*
import retrofit2.Response
import retrofit2.http.*

interface OrgApi {

    @GET("/organizations")
    suspend fun listOrganizations(
        @Query("since") since: Int? = null,
        @Query("per_page") perPage: Int = 30
    ): List<Organization>

    @GET("/user/orgs")
    suspend fun listOrgsForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Organization>

    @GET("/users/{username}/orgs")
    suspend fun listOrgsForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Organization>

    @GET("/orgs/{org}")
    suspend fun getOrg(
        @Path("org") org: String
    ): Organization

    @PATCH("/orgs/{org}")
    suspend fun updateOrg(
        @Path("org") org: String,
        @Body body: UpdateOrgRequest
    ): Organization

    @DELETE("/orgs/{org}")
    suspend fun deleteOrg(
        @Path("org") org: String
    ): Response<Unit>

    @GET("/orgs/{org}/members")
    suspend fun listOrgMembers(
        @Path("org") org: String,
        @Query("filter") filter: String? = null,
        @Query("role") role: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/orgs/{org}/members/{username}")
    suspend fun checkOrgMembership(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @DELETE("/orgs/{org}/members/{username}")
    suspend fun removeOrgMember(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @GET("/orgs/{org}/memberships/{username}")
    suspend fun getOrgMembership(
        @Path("org") org: String,
        @Path("username") username: String
    ): OrgMembership

    @PUT("/orgs/{org}/memberships/{username}")
    suspend fun setOrgMembership(
        @Path("org") org: String,
        @Path("username") username: String,
        @Body body: SetOrgMembershipRequest
    ): OrgMembership

    @DELETE("/orgs/{org}/memberships/{username}")
    suspend fun removeOrgMembership(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @GET("/user/memberships/orgs")
    suspend fun listOrgMembershipsForAuthenticatedUser(
        @Query("state") state: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<OrgMembership>

    @GET("/user/memberships/orgs/{org}")
    suspend fun getOrgMembershipForAuthenticatedUser(
        @Path("org") org: String
    ): OrgMembership

    @PATCH("/user/memberships/orgs/{org}")
    suspend fun updateOrgMembershipForAuthenticatedUser(
        @Path("org") org: String,
        @Body body: UpdateOrgMembershipRequest
    ): OrgMembership

    @GET("/orgs/{org}/public_members")
    suspend fun listPublicOrgMembers(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/orgs/{org}/public_members/{username}")
    suspend fun checkPublicOrgMembership(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @PUT("/orgs/{org}/public_members/{username}")
    suspend fun setPublicOrgMembership(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @DELETE("/orgs/{org}/public_members/{username}")
    suspend fun removePublicOrgMembership(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @GET("/orgs/{org}/outside_collaborators")
    suspend fun listOutsideCollaborators(
        @Path("org") org: String,
        @Query("filter") filter: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @PUT("/orgs/{org}/outside_collaborators/{username}")
    suspend fun convertMemberToOutsideCollaborator(
        @Path("org") org: String,
        @Path("username") username: String,
        @Body body: ConvertCollaboratorRequest? = null
    ): Response<Any>

    @DELETE("/orgs/{org}/outside_collaborators/{username}")
    suspend fun removeOutsideCollaborator(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @GET("/orgs/{org}/invitations")
    suspend fun listPendingInvitations(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("role") role: String? = null,
        @Query("invitation_source") invitationSource: String? = null
    ): List<OrgInvitation>

    @POST("/orgs/{org}/invitations")
    suspend fun createInvitation(
        @Path("org") org: String,
        @Body body: CreateOrgInvitationRequest
    ): OrgInvitation

    @DELETE("/orgs/{org}/invitations/{invitation_id}")
    suspend fun cancelInvitation(
        @Path("org") org: String,
        @Path("invitation_id") invitationId: Long
    ): Response<Unit>

    @GET("/orgs/{org}/invitations/{invitation_id}/teams")
    suspend fun listInvitationTeams(
        @Path("org") org: String,
        @Path("invitation_id") invitationId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Team>

    @GET("/orgs/{org}/failed_invitations")
    suspend fun listFailedInvitations(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<OrgInvitation>

    @GET("/orgs/{org}/blocks")
    suspend fun listBlockedUsers(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/orgs/{org}/blocks/{username}")
    suspend fun checkIfUserIsBlocked(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @PUT("/orgs/{org}/blocks/{username}")
    suspend fun blockUser(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @DELETE("/orgs/{org}/blocks/{username}")
    suspend fun unblockUser(
        @Path("org") org: String,
        @Path("username") username: String
    ): Response<Unit>

    @GET("/orgs/{org}/repos")
    suspend fun listOrgRepos(
        @Path("org") org: String,
        @Query("type") type: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>

    @GET("/orgs/{org}/credential-authorizations")
    suspend fun listSamlSsoAuthorizations(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("login") login: String? = null
    ): List<CredentialAuthorization>

    @DELETE("/orgs/{org}/credential-authorizations/{credential_id}")
    suspend fun removeSamlSsoAuthorization(
        @Path("org") org: String,
        @Path("credential_id") credentialId: Int
    ): Response<Unit>

    @GET("/orgs/{org}/audit-log")
    suspend fun getAuditLog(
        @Path("org") org: String,
        @Query("phrase") phrase: String? = null,
        @Query("include") include: String? = null,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Any>

    @GET("/orgs/{org}/hooks")
    suspend fun listWebhooks(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Hook>

    @POST("/orgs/{org}/hooks")
    suspend fun createWebhook(
        @Path("org") org: String,
        @Body body: CreateHookRequest
    ): Hook

    @GET("/orgs/{org}/hooks/{hook_id}")
    suspend fun getWebhook(
        @Path("org") org: String,
        @Path("hook_id") hookId: Long
    ): Hook

    @PATCH("/orgs/{org}/hooks/{hook_id}")
    suspend fun updateWebhook(
        @Path("org") org: String,
        @Path("hook_id") hookId: Long,
        @Body body: UpdateHookRequest
    ): Hook

    @DELETE("/orgs/{org}/hooks/{hook_id}")
    suspend fun deleteWebhook(
        @Path("org") org: String,
        @Path("hook_id") hookId: Long
    ): Response<Unit>

    @POST("/orgs/{org}/hooks/{hook_id}/pings")
    suspend fun pingWebhook(
        @Path("org") org: String,
        @Path("hook_id") hookId: Long
    ): Response<Unit>

    @GET("/orgs/{org}/hooks/{hook_id}/deliveries")
    suspend fun listDeliveriesForWebhook(
        @Path("org") org: String,
        @Path("hook_id") hookId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("cursor") cursor: String? = null
    ): List<HookDelivery>

    @GET("/orgs/{org}/hooks/{hook_id}/deliveries/{delivery_id}")
    suspend fun getWebhookDelivery(
        @Path("org") org: String,
        @Path("hook_id") hookId: Long,
        @Path("delivery_id") deliveryId: Long
    ): HookDelivery

    @POST("/orgs/{org}/hooks/{hook_id}/deliveries/{delivery_id}/attempts")
    suspend fun redeliverWebhookDelivery(
        @Path("org") org: String,
        @Path("hook_id") hookId: Long,
        @Path("delivery_id") deliveryId: Long
    ): Response<Unit>

    @GET("/orgs/{org}/custom_roles")
    suspend fun listCustomRoles(
        @Path("org") org: String
    ): CustomRolesResponse

    @POST("/orgs/{org}/custom-repository-roles")
    suspend fun createCustomRole(
        @Path("org") org: String,
        @Body body: CustomRoleRequest
    ): CustomRole

    @GET("/orgs/{org}/custom-repository-roles/{role_id}")
    suspend fun getCustomRole(
        @Path("org") org: String,
        @Path("role_id") roleId: Long
    ): CustomRole

    @PATCH("/orgs/{org}/custom-repository-roles/{role_id}")
    suspend fun updateCustomRole(
        @Path("org") org: String,
        @Path("role_id") roleId: Long,
        @Body body: CustomRoleRequest
    ): CustomRole

    @DELETE("/orgs/{org}/custom-repository-roles/{role_id}")
    suspend fun deleteCustomRole(
        @Path("org") org: String,
        @Path("role_id") roleId: Long
    ): Response<Unit>
}

