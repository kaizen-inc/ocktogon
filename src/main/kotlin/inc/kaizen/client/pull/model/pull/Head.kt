package inc.kaizen.client.pull.model.pull

import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.User

data class Head(
    val label: String? = null,
    val ref: String? = null,
    val repo: Repository? = null,
    val sha: String? = null,
    val user: User? = null
)