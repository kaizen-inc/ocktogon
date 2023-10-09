package inc.kaizen.client.action.api

import inc.kaizen.client.action.model.permission.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface PermissionApi {

    @GET("/orgs/{org}/actions/permissions")
    suspend fun getOrgActionPermissions(
        @Path("org") org: String
    ): Permission

    @PUT("/orgs/{org}/actions/permissions")
    suspend fun getOrgActionPermissions(
        @Path("org") org: String,
        @Body permission: Permission
    ): Response<Unit>

    @GET("/orgs/{org}/actions/permissions/repositories")
    suspend fun getOrgEnabledActions(
        @Path("org") org: String
    ): EnabledActions

    @PUT("/orgs/{org}/actions/permissions/repositories")
    suspend fun enableActionsForReposInOrg(
        @Path("org") org: String,
        @Body selectedRepositoryIds: List<Int>
    ): Response<Unit>

    @PUT("/orgs/{org}/actions/permissions/repositories/{repository_id}")
    suspend fun enableActionsForRepoInOrg(
        @Path("org") org: String,
        @Path("repository_id") repositoryId: Int
    ): Response<Unit>

    @DELETE("/orgs/{org}/actions/permissions/repositories/{repository_id}")
    suspend fun disableActionsForRepoInOrg(
        @Path("org") org: String,
        @Path("repository_id") repositoryId: Int
    ): Response<Unit>

    @GET("/orgs/{org}/actions/permissions/selected-actions")
    suspend fun getOrgAllowedActionsAndReusableWorkflows(
        @Path("org") org: String
    ): AllowedActionsReusableWorkflows

    @PUT("/orgs/{org}/actions/permissions/selected-actions")
    suspend fun setOrgAllowedActionsAndReusableWorkflows(
        @Path("org") org: String,
        @Body allowedActionsReusableWorkflows: AllowedActionsReusableWorkflows
    ): Response<Unit>

    @GET("/orgs/{org}/actions/permissions/workflow")
    suspend fun getOrgDefaultWorkflowPermission(
        @Path("org") org: String
    ): DefaultWorkflowPermission

    @PUT("/orgs/{org}/actions/permissions/workflow")
    suspend fun setOrgDefaultWorkflowPermission(
        @Path("org") org: String,
        @Body defaultWorkflowPermission: DefaultWorkflowPermission
    )

    @GET("/repos/{owner}/{repo}/actions/permissions")
    suspend fun getRepoActionPermission(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): ActionPermission

    @PUT("/orgs/{org}/actions/permissions/workflow")
    suspend fun setRepoActionPermission(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body actionPermission: ActionPermission
    )

    @GET("/repos/{owner}/{repo}/actions/permissions/access")
    suspend fun getRepoWorkflowAccessLevel(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): AccessLevel

    @PUT("/repos/{owner}/{repo}/actions/permissions/access")
    suspend fun setRepoWorkflowAccessLevel(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body accessLevel: AccessLevel
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/permissions/selected-actions")
    suspend fun getRepoAllowedActionsAndReusableWorkflows(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
    ): AllowedActionsReusableWorkflows

    @PUT("/repos/{owner}/{repo}/actions/permissions/selected-actions")
    suspend fun setRepoAllowedActionsAndReusableWorkflows(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body allowedActionsReusableWorkflows: AllowedActionsReusableWorkflows
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/permissions/workflow")
    suspend fun getRepoDefaultWorkflowPermission(
        @Path("org") org: String
    ): DefaultWorkflowPermission

    @PUT("/repos/{owner}/{repo}/actions/permissions/workflow")
    suspend fun setRepoDefaultWorkflowPermission(
        @Path("org") org: String,
        @Body defaultWorkflowPermission: DefaultWorkflowPermission
    )

}