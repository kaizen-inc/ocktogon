package inc.kaizen.client.ocktogon.packages.model

import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.User

data class Package(
    val id: Int? = null,
    val name: String? = null,
    val package_type: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val version_count: Int? = null,
    val visibility: String? = null,
    val owner: User? = null,
    val repository: Repository? = null,
    val created_at: String? = null,
    val updated_at: String? = null
)

data class PackageVersion(
    val id: Long? = null,
    val name: String? = null,
    val url: String? = null,
    val package_html_url: String? = null,
    val html_url: String? = null,
    val license: String? = null,
    val description: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val deleted_at: String? = null,
    val metadata: PackageVersionMetadata? = null
)

data class PackageVersionMetadata(
    val package_type: String? = null,
    val container: ContainerMetadata? = null,
    val docker: DockerMetadata? = null
)

data class ContainerMetadata(val tags: List<String>? = null)
data class DockerMetadata(val tag: List<String>? = null)

