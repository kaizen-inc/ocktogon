package inc.kaizen.client.ocktogon.page.model

data class PagesSite(
    val url: String?,
    val status: String?,
    val cname: String?,
    val custom404: Boolean?,
    val html_url: String?,
    val source: PagesSource?,
    val public: Boolean?,
    val pending_domain_unverified_at: String?,
    val protected_domain_state: String?,
    val https_certificate: HttpsCertificate?,
    val https_enforced: Boolean?
)

data class HttpsCertificate(
    val state: String?,
    val description: String?,
    val domains: List<String>?,
    val expires_at: String?
)

data class PagesSource(
    val branch: String,
    val path: String? = null
)
