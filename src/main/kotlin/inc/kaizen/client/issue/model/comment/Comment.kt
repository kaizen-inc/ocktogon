package inc.kaizen.client.issue.model.comment

import inc.kaizen.client.user.model.User

data class Comment(
    val author_association: String,
    val body: String,
    val created_at: String,
    val html_url: String,
    val id: Int,
    val issue_url: String,
    val node_id: String,
    val updated_at: String,
    val url: String,
    val user: User
)