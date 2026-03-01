package inc.kaizen.client.ocktogon.securityadvisories.model

import inc.kaizen.client.ocktogon.common.Repository
import inc.kaizen.client.ocktogon.common.Team
import inc.kaizen.client.ocktogon.common.User

data class GlobalSecurityAdvisory(
    val ghsa_id: String? = null,
    val cve_id: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val repository_advisory_url: String? = null,
    val summary: String? = null,
    val description: String? = null,
    val type: String? = null,
    val severity: String? = null,
    val source_code_location: String? = null,
    val identifiers: List<AdvisoryIdentifier>? = null,
    val references: List<String>? = null,
    val published_at: String? = null,
    val updated_at: String? = null,
    val github_reviewed_at: String? = null,
    val nvd_published_at: String? = null,
    val withdrawn_at: String? = null,
    val vulnerabilities: List<AdvisoryVulnerability>? = null,
    val cvss: AdvisoryCvss? = null,
    val cwes: List<AdvisoryCwe>? = null,
    val credits: List<AdvisoryCredit>? = null
)

data class RepositoryAdvisory(
    val ghsa_id: String? = null,
    val cve_id: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val summary: String? = null,
    val description: String? = null,
    val severity: String? = null,
    val author: User? = null,
    val publisher: User? = null,
    val identifiers: List<AdvisoryIdentifier>? = null,
    val state: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val published_at: String? = null,
    val closed_at: String? = null,
    val withdrawn_at: String? = null,
    val submission: Any? = null,
    val vulnerabilities: List<AdvisoryVulnerability>? = null,
    val cvss: AdvisoryCvss? = null,
    val cwes: List<AdvisoryCwe>? = null,
    val cwe_ids: List<String>? = null,
    val credits: List<AdvisoryCredit>? = null,
    val credits_detailed: List<Any>? = null,
    val collaborating_users: List<User>? = null,
    val collaborating_teams: List<Team>? = null,
    val private_fork: Repository? = null
)

data class AdvisoryIdentifier(val value: String? = null, val type: String? = null)

data class AdvisoryVulnerability(
    val `package`: AdvisoryPackage? = null,
    val severity: String? = null,
    val vulnerable_version_range: String? = null,
    val first_patched_version: String? = null,
    val vulnerable_functions: List<String>? = null
)

data class AdvisoryPackage(val ecosystem: String? = null, val name: String? = null)
data class AdvisoryCvss(val score: Double? = null, val vector_string: String? = null)
data class AdvisoryCwe(val cwe_id: String? = null, val name: String? = null)
data class AdvisoryCredit(val user: User? = null, val type: String? = null)

data class CreateRepositoryAdvisoryRequest(
    val summary: String,
    val description: String,
    val cve_id: String? = null,
    val vulnerabilities: List<AdvisoryVulnerabilityRequest>? = null,
    val cwe_ids: List<String>? = null,
    val credits: List<AdvisoryCreditRequest>? = null,
    val severity: String? = null,
    val cvss_vector_string: String? = null,
    val start_private_fork: Boolean? = null
)

data class UpdateRepositoryAdvisoryRequest(
    val summary: String? = null,
    val description: String? = null,
    val cve_id: String? = null,
    val vulnerabilities: List<AdvisoryVulnerabilityRequest>? = null,
    val cwe_ids: List<String>? = null,
    val credits: List<AdvisoryCreditRequest>? = null,
    val severity: String? = null,
    val cvss_vector_string: String? = null,
    val state: String? = null,
    val collaborating_users: List<String>? = null,
    val collaborating_teams: List<String>? = null
)

data class AdvisoryVulnerabilityRequest(
    val `package`: AdvisoryPackage,
    val vulnerable_version_range: String? = null,
    val patched_versions: String? = null,
    val vulnerable_functions: List<String>? = null
)

data class AdvisoryCreditRequest(val login: String, val type: String)

data class PrivateVulnerabilityReportRequest(
    val summary: String,
    val description: String,
    val vulnerabilities: List<AdvisoryVulnerabilityRequest>? = null,
    val cwe_ids: List<String>? = null,
    val severity: String? = null,
    val cvss_vector_string: String? = null,
    val start_private_fork: Boolean? = null
)

