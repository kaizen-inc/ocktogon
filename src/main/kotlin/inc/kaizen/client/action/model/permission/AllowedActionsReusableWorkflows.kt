package inc.kaizen.client.action.model.permission

data class AllowedActionsReusableWorkflows(
    val github_owned_allowed: Boolean,
    val patterns_allowed: List<String>,
    val verified_allowed: Boolean
)