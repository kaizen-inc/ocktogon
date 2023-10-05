package inc.kaizen.client.pull.model.pull

import inc.kaizen.client.user.model.User

data class Head(
    val label: String,
    val ref: String,
    val repo: Repo,
    val sha: String,
    val user: User
)