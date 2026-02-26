package inc.kaizen.client.common

data class License(
    val key: String? = null,
    val name: String? = null,
    val spdx_id: String? = null,
    val url: String? = null,
    val node_id: String? = null,
    val html_url: String? = null,
    val description: String? = null,
    val implementation: String? = null,
    val permissions: List<String>? = null,
    val conditions: List<String>? = null,
    val limitations: List<String>? = null,
    val body: String? = null,
    val featured: Boolean? = null
)

