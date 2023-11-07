package inc.kaizen.client.action.model.permission

data class Permission(
    val allowed_actions: AllowedAction,
    val enabled_repositories: EnabledRepositories,
    val selected_actions_url: String? = null
)