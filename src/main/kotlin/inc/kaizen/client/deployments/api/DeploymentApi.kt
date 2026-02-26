package inc.kaizen.client.deployments.api

import inc.kaizen.client.deployments.model.*
import retrofit2.Response
import retrofit2.http.*

interface DeploymentApi {

    @GET("/repos/{owner}/{repo}/deployments")
    suspend fun listDeployments(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("sha") sha: String? = null,
        @Query("ref") ref: String? = null,
        @Query("task") task: String? = null,
        @Query("environment") environment: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Deployment>

    @POST("/repos/{owner}/{repo}/deployments")
    suspend fun createDeployment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateDeploymentRequest
    ): Deployment

    @GET("/repos/{owner}/{repo}/deployments/{deployment_id}")
    suspend fun getDeployment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("deployment_id") deploymentId: Long
    ): Deployment

    @DELETE("/repos/{owner}/{repo}/deployments/{deployment_id}")
    suspend fun deleteDeployment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("deployment_id") deploymentId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/deployments/{deployment_id}/statuses")
    suspend fun listDeploymentStatuses(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("deployment_id") deploymentId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<DeploymentStatus>

    @POST("/repos/{owner}/{repo}/deployments/{deployment_id}/statuses")
    suspend fun createDeploymentStatus(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("deployment_id") deploymentId: Long,
        @Body body: CreateDeploymentStatusRequest
    ): DeploymentStatus

    @GET("/repos/{owner}/{repo}/deployments/{deployment_id}/statuses/{status_id}")
    suspend fun getDeploymentStatus(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("deployment_id") deploymentId: Long,
        @Path("status_id") statusId: Long
    ): DeploymentStatus
}

interface EnvironmentApi {

    @GET("/repos/{owner}/{repo}/environments")
    suspend fun listEnvironments(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): EnvironmentsResponse

    @GET("/repos/{owner}/{repo}/environments/{environment_name}")
    suspend fun getEnvironment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String
    ): Environment

    @PUT("/repos/{owner}/{repo}/environments/{environment_name}")
    suspend fun createOrUpdateEnvironment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Body body: CreateEnvironmentRequest? = null
    ): Environment

    @DELETE("/repos/{owner}/{repo}/environments/{environment_name}")
    suspend fun deleteEnvironment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/environments/{environment_name}/deployment-branch-policies")
    suspend fun listDeploymentBranchPolicies(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): DeploymentBranchPoliciesResponse

    @POST("/repos/{owner}/{repo}/environments/{environment_name}/deployment-branch-policies")
    suspend fun createDeploymentBranchPolicy(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Body body: CreateDeploymentBranchPolicyRequest
    ): DeploymentBranchPolicy

    @GET("/repos/{owner}/{repo}/environments/{environment_name}/deployment-branch-policies/{branch_policy_id}")
    suspend fun getDeploymentBranchPolicy(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Path("branch_policy_id") branchPolicyId: Long
    ): DeploymentBranchPolicy

    @PUT("/repos/{owner}/{repo}/environments/{environment_name}/deployment-branch-policies/{branch_policy_id}")
    suspend fun updateDeploymentBranchPolicy(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Path("branch_policy_id") branchPolicyId: Long,
        @Body body: CreateDeploymentBranchPolicyRequest
    ): DeploymentBranchPolicy

    @DELETE("/repos/{owner}/{repo}/environments/{environment_name}/deployment-branch-policies/{branch_policy_id}")
    suspend fun deleteDeploymentBranchPolicy(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Path("branch_policy_id") branchPolicyId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/environments/{environment_name}/deployment_protection_rules")
    suspend fun listDeploymentProtectionRules(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String
    ): DeploymentProtectionRulesResponse

    @POST("/repos/{owner}/{repo}/environments/{environment_name}/deployment_protection_rules")
    suspend fun createDeploymentProtectionRule(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Body body: CreateDeploymentProtectionRuleRequest
    ): DeploymentProtectionRule

    @GET("/repos/{owner}/{repo}/environments/{environment_name}/deployment_protection_rules/apps")
    suspend fun listCustomDeploymentRuleIntegrations(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): CustomDeploymentRuleIntegrationsResponse

    @GET("/repos/{owner}/{repo}/environments/{environment_name}/deployment_protection_rules/{protection_rule_id}")
    suspend fun getDeploymentProtectionRule(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Path("protection_rule_id") protectionRuleId: Long
    ): DeploymentProtectionRule

    @DELETE("/repos/{owner}/{repo}/environments/{environment_name}/deployment_protection_rules/{protection_rule_id}")
    suspend fun disableDeploymentProtectionRule(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Path("protection_rule_id") protectionRuleId: Long
    ): Response<Unit>
}
