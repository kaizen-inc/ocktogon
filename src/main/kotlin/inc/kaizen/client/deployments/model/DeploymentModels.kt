package inc.kaizen.client.deployments.model

import inc.kaizen.client.common.User

data class Deployment(
    val url: String? = null,
    val id: Long? = null,
    val node_id: String? = null,
    val sha: String? = null,
    val ref: String? = null,
    val task: String? = null,
    val payload: Any? = null,
    val original_environment: String? = null,
    val environment: String? = null,
    val description: String? = null,
    val creator: User? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val statuses_url: String? = null,
    val repository_url: String? = null,
    val transient_environment: Boolean? = null,
    val production_environment: Boolean? = null
)

data class DeploymentStatus(
    val url: String? = null,
    val id: Long? = null,
    val node_id: String? = null,
    val state: String? = null,
    val creator: User? = null,
    val description: String? = null,
    val environment: String? = null,
    val target_url: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val deployment_url: String? = null,
    val repository_url: String? = null,
    val environment_url: String? = null,
    val log_url: String? = null
)

data class Environment(
    val id: Int? = null,
    val node_id: String? = null,
    val name: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val can_admins_bypass: Boolean? = null,
    val protection_rules: List<Any>? = null,
    val deployment_branch_policy: DeploymentBranchPolicySettings? = null
)

data class DeploymentBranchPolicySettings(
    val protected_branches: Boolean? = null,
    val custom_branch_policies: Boolean? = null
)

data class EnvironmentsResponse(
    val total_count: Int? = null,
    val environments: List<Environment>? = null
)

data class DeploymentBranchPolicy(
    val id: Long? = null,
    val node_id: String? = null,
    val name: String? = null,
    val type: String? = null
)

data class DeploymentBranchPoliciesResponse(
    val total_count: Int? = null,
    val branch_policies: List<DeploymentBranchPolicy>? = null
)

data class DeploymentProtectionRule(
    val id: Long? = null,
    val node_id: String? = null,
    val type: String? = null,
    val app: Any? = null
)

data class DeploymentProtectionRulesResponse(
    val total_count: Int? = null,
    val custom_deployment_protection_rules: List<DeploymentProtectionRule>? = null
)

data class CustomDeploymentRuleIntegrationsResponse(
    val total_count: Int? = null,
    val available_custom_deployment_protection_rule_integrations: List<Any>? = null
)

data class CreateDeploymentRequest(
    val ref: String,
    val task: String? = null,
    val auto_merge: Boolean? = null,
    val required_contexts: List<String>? = null,
    val payload: Any? = null,
    val environment: String? = null,
    val description: String? = null,
    val transient_environment: Boolean? = null,
    val production_environment: Boolean? = null
)

data class CreateDeploymentStatusRequest(
    val state: String,
    val target_url: String? = null,
    val log_url: String? = null,
    val description: String? = null,
    val environment: String? = null,
    val environment_url: String? = null,
    val auto_inactive: Boolean? = null
)

data class CreateEnvironmentRequest(
    val wait_timer: Int? = null,
    val reviewers: List<EnvironmentReviewer>? = null,
    val deployment_branch_policy: DeploymentBranchPolicySettings? = null,
    val can_admins_bypass: Boolean? = null
)

data class EnvironmentReviewer(
    val type: String? = null,
    val id: Int? = null
)

data class CreateDeploymentBranchPolicyRequest(val name: String, val type: String? = null)
data class CreateDeploymentProtectionRuleRequest(val integration_id: Int? = null)

