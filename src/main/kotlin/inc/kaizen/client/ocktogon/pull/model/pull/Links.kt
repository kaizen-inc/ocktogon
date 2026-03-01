package inc.kaizen.client.ocktogon.pull.model.pull

import inc.kaizen.client.common.HRef

// Links now uses common HRef
data class Links(
    val comments: HRef? = null,
    val commits: HRef? = null,
    val html: HRef? = null,
    val issue: HRef? = null,
    val review_comment: HRef? = null,
    val review_comments: HRef? = null,
    val self: HRef? = null,
    val statuses: HRef? = null
)