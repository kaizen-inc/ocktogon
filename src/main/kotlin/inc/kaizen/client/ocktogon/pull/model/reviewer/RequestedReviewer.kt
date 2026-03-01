package inc.kaizen.client.ocktogon.pull.model.reviewer

import inc.kaizen.client.common.User

data class RequestedReviewer(
    val teams: List<Team>? = null,
    val users: List<User>? = null
)