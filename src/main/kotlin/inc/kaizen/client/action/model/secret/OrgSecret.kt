package inc.kaizen.client.action.model.secret

data class OrgSecret(
    val encrypted_value: String,
    val key_id: String,
    val selected_repository_ids: List<Int>,
    val visibility: String
)