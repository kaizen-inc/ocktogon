package inc.kaizen.client.dependabot.model

import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.User

data class DependabotAlert(
    val number: Int? = null,
    val state: String? = null,
    val dependency: DependabotDependency? = null,
    val security_advisory: DependabotSecurityAdvisory? = null,
    val security_vulnerability: DependabotVulnerability? = null,
    val url: String? = null,
    val html_url: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val dismissed_at: String? = null,
    val dismissed_by: User? = null,
    val dismissed_reason: String? = null,
    val dismissed_comment: String? = null,
    val fixed_at: String? = null,
    val auto_dismissed_at: String? = null
)

data class DependabotDependency(
    val `package`: DependabotPackage? = null,
    val manifest_path: String? = null,
    val scope: String? = null
)

data class DependabotPackage(
    val ecosystem: String? = null,
    val name: String? = null
)

data class DependabotSecurityAdvisory(
    val ghsa_id: String? = null,
    val cve_id: String? = null,
    val summary: String? = null,
    val description: String? = null,
    val vulnerabilities: List<DependabotVulnerability>? = null,
    val severity: String? = null,
    val cvss: DependabotCvss? = null,
    val cwes: List<DependabotCwe>? = null,
    val identifiers: List<DependabotIdentifier>? = null,
    val references: List<DependabotReference>? = null,
    val published_at: String? = null,
    val updated_at: String? = null,
    val withdrawn_at: String? = null
)

data class DependabotVulnerability(
    val `package`: DependabotPackage? = null,
    val severity: String? = null,
    val vulnerable_version_range: String? = null,
    val first_patched_version: DependabotFirstPatchedVersion? = null
)

data class DependabotFirstPatchedVersion(val identifier: String? = null)
data class DependabotCvss(val score: Double? = null, val vector_string: String? = null)
data class DependabotCwe(val cwe_id: String? = null, val name: String? = null)
data class DependabotIdentifier(val value: String? = null, val type: String? = null)
data class DependabotReference(val url: String? = null)

data class DependabotSecret(
    val name: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val visibility: String? = null,
    val selected_repositories_url: String? = null
)

data class DependabotPublicKey(
    val key_id: String? = null,
    val key: String? = null
)

data class DependabotSecretsResponse(
    val total_count: Int? = null,
    val secrets: List<DependabotSecret>? = null
)

data class DependabotSecretRepositoriesResponse(
    val total_count: Int? = null,
    val repositories: List<Repository>? = null
)

data class UpdateDependabotAlertRequest(
    val state: String,
    val dismissed_reason: String? = null,
    val dismissed_comment: String? = null
)

data class CreateDependabotSecretRequest(
    val encrypted_value: String? = null,
    val key_id: String? = null,
    val visibility: String? = null,
    val selected_repository_ids: List<String>? = null
)

data class SetSelectedReposRequest(val selected_repository_ids: List<Int>)

