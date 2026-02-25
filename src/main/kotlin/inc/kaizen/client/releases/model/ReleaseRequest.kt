package inc.kaizen.client.releases.model

data class ReleaseRequest(
    val tag_name: String,
    val target_commitish: String? = null,
    val name: String? = null,
    val body: String? = null,
    val draft: Boolean = false,
    val prerelease: Boolean = false,
    val discussion_category_name: String? = null,
    val generate_release_notes: Boolean = false,
    val make_latest: MakeLatest? = null,
)

enum class MakeLatest {
    TRUE,
    FALSE,
    LEGACY
}