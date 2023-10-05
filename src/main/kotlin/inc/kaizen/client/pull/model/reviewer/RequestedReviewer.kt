package inc.kaizen.client.pull.model.reviewer

import inc.kaizen.client.user.model.User

data class RequestedReviewer(
    val teams: List<Team>,
    val users: List<User>
)