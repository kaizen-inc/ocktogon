package inc.kaizen.client.pull.model.review

import inc.kaizen.client.common.ReviewCommentLinks
import inc.kaizen.client.common.User

data class ReviewComment(
    val _links: ReviewCommentLinks? = null,
    val author_association: String? = null,
    val body: String? = null,
    val commit_id: String? = null,
    val created_at: String? = null,
    val diff_hunk: String? = null,
    val html_url: String? = null,
    val id: Int? = null,
    val in_reply_to_id: Int? = null,
    val line: Int? = null,
    val node_id: String? = null,
    val original_commit_id: String? = null,
    val original_line: Int? = null,
    val original_position: Int? = null,
    val original_start_line: Int? = null,
    val path: String? = null,
    val position: Int? = null,
    val pull_request_review_id: Int? = null,
    val pull_request_url: String? = null,
    val side: String? = null,
    val start_line: Int? = null,
    val start_side: String? = null,
    val updated_at: String? = null,
    val url: String? = null,
    val user: User? = null
)