package inc.kaizen.client.ocktogon.collaborator.model

import inc.kaizen.client.ocktogon.user.model.User

data class CollaboratorPermission(
    val permission: String,
    val role_name: String,
    val user: User
)
