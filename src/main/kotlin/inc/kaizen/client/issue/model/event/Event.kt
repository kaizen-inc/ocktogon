package inc.kaizen.client.issue.model.event

import inc.kaizen.client.issue.model.issue.Issue
import inc.kaizen.client.user.model.User

data class Event(
    val actor: User,
    val commit_id: String,
    val commit_url: String,
    val created_at: String,
    val event: String,
    val id: Int,
    val issue: Issue,
    val node_id: String,
    val url: String
)