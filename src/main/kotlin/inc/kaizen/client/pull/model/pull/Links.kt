package inc.kaizen.client.pull.model.pull

import inc.kaizen.client.pull.model.review.HRef

data class Links(
    val comments: HRef,
    val commits: HRef,
    val html: HRef,
    val issue: HRef,
    val review_comment: HRef,
    val review_comments: HRef,
    val self: HRef,
    val statuses: HRef
)