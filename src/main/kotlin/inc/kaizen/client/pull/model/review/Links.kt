package inc.kaizen.client.pull.model.review

import inc.kaizen.client.common.HRef

data class Links(
    val html: HRef? = null,
    val pull_request: HRef? = null,
    val self: HRef? = null
)