package inc.kaizen.client.collaborator.model

import inc.kaizen.client.user.model.User

data class CollaboratorPermission(
    val permission: String,
    val role_name: String,
    val user: User
)
