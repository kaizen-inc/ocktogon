package inc.kaizen.client.ocktogon.licenses.model

import inc.kaizen.client.ocktogon.common.License

data class LicenseSimple(
    val key: String? = null,
    val name: String? = null,
    val url: String? = null,
    val spdx_id: String? = null,
    val node_id: String? = null,
    val html_url: String? = null
)

data class RepoLicenseContent(
    val name: String? = null,
    val path: String? = null,
    val sha: String? = null,
    val size: Int? = null,
    val url: String? = null,
    val html_url: String? = null,
    val git_url: String? = null,
    val download_url: String? = null,
    val type: String? = null,
    val content: String? = null,
    val encoding: String? = null,
    val license: License? = null
)

