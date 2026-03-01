package inc.kaizen.client.ocktogon.issue.model.event

import inc.kaizen.client.ocktogon.common.User
import inc.kaizen.client.ocktogon.issue.model.issue.Issue

data class Event(
    val actor: User? = null,
    val commit_id: String? = null,
    val commit_url: String? = null,
    val created_at: String? = null,
    val event: String? = null,
    val id: Int? = null,
    val issue: Issue? = null,
    val node_id: String? = null,
    val url: String? = null
)