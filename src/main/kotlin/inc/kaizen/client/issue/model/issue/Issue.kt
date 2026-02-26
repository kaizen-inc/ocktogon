package inc.kaizen.client.issue.model.issue

import inc.kaizen.client.common.Label
import inc.kaizen.client.common.Milestone
import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.User
import inc.kaizen.client.pull.model.pull.Pull

data class Issue(
    val active_lock_reason: String? = null,
    val assignee: User? = null,
    val assignees: List<User>? = null,
    val author_association: String? = null,
    val body: String? = null,
    val closed_at: Any? = null,
    val comments: Int? = null,
    val comments_url: String? = null,
    val created_at: String? = null,
    val events_url: String? = null,
    val html_url: String? = null,
    val id: Int? = null,
    val labels: List<Label>? = null,
    val labels_url: String? = null,
    val locked: Boolean? = null,
    val milestone: Milestone? = null,
    val node_id: String? = null,
    val number: Int? = null,
    val pull_request: Pull? = null,
    val repository: Repository? = null,
    val repository_url: String? = null,
    val state: String? = null,
    val state_reason: String? = null,
    val title: String? = null,
    val updated_at: String? = null,
    val url: String? = null,
    val user: User? = null
)