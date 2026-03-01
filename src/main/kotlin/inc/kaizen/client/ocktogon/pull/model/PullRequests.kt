package inc.kaizen.client.ocktogon.pull.model

import inc.kaizen.client.common.User

data class CreatePullRequest(
    val title: String? = null,
    val head: String,
    val head_repo: String? = null,
    val base: String,
    val body: String? = null,
    val maintainer_can_modify: Boolean? = null,
    val draft: Boolean? = null,
    val issue: Int? = null
)

data class UpdatePullRequest(
    val title: String? = null,
    val body: String? = null,
    val state: String? = null,
    val base: String? = null,
    val maintainer_can_modify: Boolean? = null
)

data class CreateReviewCommentRequest(
    val body: String,
    val commit_id: String,
    val path: String,
    val position: Int? = null,
    val side: String? = null,
    val line: Int? = null,
    val start_line: Int? = null,
    val start_side: String? = null,
    val in_reply_to: Int? = null,
    val subject_type: String? = null
)

data class UpdateReviewCommentRequest(val body: String)
data class ReplyReviewCommentRequest(val body: String)

data class PullReview(
    val id: Long? = null,
    val node_id: String? = null,
    val user: User? = null,
    val body: String? = null,
    val state: String? = null,
    val html_url: String? = null,
    val pull_request_url: String? = null,
    val submitted_at: String? = null,
    val commit_id: String? = null,
    val author_association: String? = null
)

data class CreateReviewRequest(
    val commit_id: String? = null,
    val body: String? = null,
    val event: String? = null,
    val comments: List<ReviewCommentDraft>? = null
)

data class ReviewCommentDraft(
    val path: String,
    val position: Int? = null,
    val body: String,
    val line: Int? = null,
    val side: String? = null,
    val start_line: Int? = null,
    val start_side: String? = null
)

data class UpdateReviewRequest(val body: String)
data class DismissReviewRequest(val message: String, val event: String = "DISMISS")
data class SubmitReviewRequest(val body: String? = null, val event: String)

data class MergePullRequestRequest(
    val commit_title: String? = null,
    val commit_message: String? = null,
    val sha: String? = null,
    val merge_method: String? = null
)

data class MergeResult(
    val sha: String? = null,
    val merged: Boolean? = null,
    val message: String? = null
)

data class RequestReviewersRequest(
    val reviewers: List<String>? = null,
    val team_reviewers: List<String>? = null
)

