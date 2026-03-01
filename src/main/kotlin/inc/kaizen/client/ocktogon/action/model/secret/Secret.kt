package inc.kaizen.client.ocktogon.action.model.secret

data class Secret(
    val created_at: String,
    val name: String,
    val selected_repositories_url: String,
    val updated_at: String,
    val visibility: String
)