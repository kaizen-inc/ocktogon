package inc.kaizen.client.ocktogon.action.model.artifact

data class Artifact(
    val archive_download_url: String,
    val created_at: String,
    val expired: Boolean,
    val expires_at: String,
    val id: Int,
    val name: String,
    val node_id: String,
    val size_in_bytes: Int,
    val updated_at: String,
    val url: String,
    val workflow_run: WorkflowRun
)