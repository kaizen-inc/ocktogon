package inc.kaizen.client.releases.model

data class ReleaseAssetRequest(
    val name: String,
    val label: String,
    val state: String
)