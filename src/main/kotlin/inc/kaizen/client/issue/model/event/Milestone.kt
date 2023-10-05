package inc.kaizen.client.issue.model.event

import inc.kaizen.client.user.model.User

data class Milestone(
    val closed_at: String,
    val closed_issues: Int,
    val created_at: String,
    val creator: User,
    val description: String,
    val due_on: String,
    val html_url: String,
    val id: Int,
    val labels_url: String,
    val node_id: String,
    val number: Int,
    val open_issues: Int,
    val state: String,
    val title: String,
    val updated_at: String,
    val url: String
)