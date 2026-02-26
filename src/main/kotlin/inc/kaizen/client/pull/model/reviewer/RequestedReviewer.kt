package inc.kaizen.client.pull.model.reviewer

import inc.kaizen.client.common.Team
import inc.kaizen.client.common.User

data class RequestedReviewer(
    val teams: List<Team>? = null,
    val users: List<User>? = null
)