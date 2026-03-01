package inc.kaizen.client.ocktogon.releases.model

data class ReleaseAssetRequest(
    val name: String,
    val label: String,
    val state: String
)