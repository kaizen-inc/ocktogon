package inc.kaizen.client.ocktogon.reactions.model

import inc.kaizen.client.ocktogon.common.User

data class Reaction(
    val id: Int? = null,
    val node_id: String? = null,
    val user: User? = null,
    val content: String? = null,
    val created_at: String? = null
)

data class CreateReactionRequest(val content: String)

