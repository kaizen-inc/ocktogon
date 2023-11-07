package inc.kaizen.client.issue.model.issue

import inc.kaizen.client.issue.model.event.Milestone
import inc.kaizen.client.issue.model.label.Label
import inc.kaizen.client.pull.model.pull.Pull
import inc.kaizen.client.user.model.User

data class Issue(
    val active_lock_reason: String,
    val assignee: User,
    val assignees: List<User>,
    val author_association: String,
    val body: String,
    val closed_at: Any,
    val comments: Int,
    val comments_url: String,
    val created_at: String,
    val events_url: String,
    val html_url: String,
    val id: Int,
    val labels: List<Label>,
    val labels_url: String,
    val locked: Boolean,
    val milestone: Milestone,
    val node_id: String,
    val number: Int,
    val pull_request: Pull,
    val repository: Repository?,
    val repository_url: String,
    val state: String,
    val state_reason: String?,
    val title: String,
    val updated_at: String,
    val url: String,
    val user: User
)