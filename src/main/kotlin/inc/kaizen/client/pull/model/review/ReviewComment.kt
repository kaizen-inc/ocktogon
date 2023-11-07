package inc.kaizen.client.pull.model.review

import inc.kaizen.client.user.model.User

data class ReviewComment(
    val _links: Links,
    val author_association: String,
    val body: String,
    val commit_id: String,
    val created_at: String,
    val diff_hunk: String,
    val html_url: String,
    val id: Int,
    val in_reply_to_id: Int,
    val line: Int,
    val node_id: String,
    val original_commit_id: String,
    val original_line: Int,
    val original_position: Int,
    val original_start_line: Int,
    val path: String,
    val position: Int,
    val pull_request_review_id: Int,
    val pull_request_url: String,
    val side: String,
    val start_line: Int,
    val start_side: String,
    val updated_at: String,
    val url: String,
    val user: User
)