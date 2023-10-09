package inc.kaizen.client.action.model.permission

data class DefaultWorkflowPermission(
    val can_approve_pull_request_reviews: Boolean,
    val default_workflow_permissions: WorkflowPermission
)