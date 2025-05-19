package inc.kaizen.client.releases.model

data class ReleaseNotesRequest(
    val tag_name: String,
    val target_commitish: String? = null,
    val previous_tag_name : String? = null,
    val configuration_file_path: String? = null,
)
