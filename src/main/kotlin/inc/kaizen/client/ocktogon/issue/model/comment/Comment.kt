package inc.kaizen.client.ocktogon.issue.model.comment

import inc.kaizen.client.ocktogon.common.User

data class Comment(
    val author_association: String? = null,
    val body: String? = null,
    val created_at: String? = null,
    val html_url: String? = null,
    val id: Int? = null,
    val issue_url: String? = null,
    val node_id: String? = null,
    val updated_at: String? = null,
    val url: String? = null,
    val user: User? = null
)