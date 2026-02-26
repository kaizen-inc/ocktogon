package inc.kaizen.client.issue.model

data class CreateIssueRequest(
    val title: String,
    val body: String? = null,
    val assignee: String? = null,
    val milestone: Int? = null,
    val labels: List<String>? = null,
    val assignees: List<String>? = null
)

data class UpdateIssueRequest(
    val title: String? = null,
    val body: String? = null,
    val assignee: String? = null,
    val state: String? = null,
    val state_reason: String? = null,
    val milestone: Int? = null,
    val labels: List<String>? = null,
    val assignees: List<String>? = null
)

data class LockIssueRequest(val lock_reason: String? = null)
data class UpdateCommentRequest(val body: String)

data class LabelRequest(
    val name: String? = null,
    val color: String? = null,
    val description: String? = null
)

data class MilestoneRequest(
    val title: String,
    val state: String? = null,
    val description: String? = null,
    val due_on: String? = null
)

data class AddLabelsRequest(val labels: List<String>)
data class AssigneesRequest(val assignees: List<String>)

