package inc.kaizen.client.ocktogon.pull.model.pull

import inc.kaizen.client.ocktogon.common.Repository
import inc.kaizen.client.ocktogon.common.User

data class Head(
    val label: String? = null,
    val ref: String? = null,
    val repo: Repository? = null,
    val sha: String? = null,
    val user: User? = null
)