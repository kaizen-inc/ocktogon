package inc.kaizen.client.repo.model.repo

data class Permissions(
    val admin: Boolean,
    val pull: Boolean,
    val push: Boolean
)