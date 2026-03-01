package inc.kaizen.client.ocktogon.action.model.artifact

data class WorkflowRun(
    val head_branch: String,
    val head_repository_id: Int,
    val head_sha: String,
    val id: Int,
    val repository_id: Int
)