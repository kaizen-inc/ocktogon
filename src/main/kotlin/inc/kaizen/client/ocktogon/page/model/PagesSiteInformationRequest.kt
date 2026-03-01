package inc.kaizen.client.ocktogon.page.model

data class PagesSiteInformationRequest(
    val cname: String,
    val https_enforced: Boolean,
    val build_type: BuildType,
    val source: PagesSource,
)

enum class BuildType {
    LEGACY,
    WORKFLOW,
}