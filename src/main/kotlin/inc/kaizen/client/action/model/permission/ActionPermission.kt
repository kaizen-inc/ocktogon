package inc.kaizen.client.action.model.permission

data class ActionPermission(
    val allowed_actions: AllowedAction,
    val enabled: Boolean,
    val selected_actions_url: String? = null
)