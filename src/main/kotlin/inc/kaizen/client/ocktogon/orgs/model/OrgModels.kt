package inc.kaizen.client.ocktogon.orgs.model

import inc.kaizen.client.common.Organization
import inc.kaizen.client.common.User

data class OrgMembership(
    val url: String? = null,
    val state: String? = null,
    val role: String? = null,
    val organization_url: String? = null,
    val organization: Organization? = null,
    val user: User? = null
)

data class OrgInvitation(
    val id: Int? = null,
    val login: String? = null,
    val email: String? = null,
    val role: String? = null,
    val created_at: String? = null,
    val failed_at: String? = null,
    val failed_reason: String? = null,
    val inviter: User? = null,
    val team_count: Int? = null,
    val node_id: String? = null,
    val invitation_teams_url: String? = null,
    val invitation_source: String? = null
)

data class UpdateOrgRequest(
    val billing_email: String? = null,
    val company: String? = null,
    val email: String? = null,
    val twitter_username: String? = null,
    val location: String? = null,
    val name: String? = null,
    val description: String? = null,
    val has_organization_projects: Boolean? = null,
    val has_repository_projects: Boolean? = null,
    val default_repository_permission: String? = null,
    val members_can_create_repositories: Boolean? = null,
    val members_can_create_public_repositories: Boolean? = null,
    val members_can_create_private_repositories: Boolean? = null,
    val members_can_create_internal_repositories: Boolean? = null,
    val members_allowed_repository_creation_type: String? = null,
    val members_can_create_pages: Boolean? = null,
    val members_can_create_public_pages: Boolean? = null,
    val members_can_create_private_pages: Boolean? = null,
    val members_can_fork_private_repositories: Boolean? = null,
    val web_commit_signoff_required: Boolean? = null,
    val blog: String? = null,
    val advanced_security_enabled_for_new_repositories: Boolean? = null,
    val dependabot_alerts_enabled_for_new_repositories: Boolean? = null,
    val dependabot_security_updates_enabled_for_new_repositories: Boolean? = null,
    val dependency_graph_enabled_for_new_repositories: Boolean? = null,
    val secret_scanning_enabled_for_new_repositories: Boolean? = null,
    val secret_scanning_push_protection_enabled_for_new_repositories: Boolean? = null
)

data class SetOrgMembershipRequest(val role: String? = null)
data class UpdateOrgMembershipRequest(val state: String)
data class ConvertCollaboratorRequest(val async: Boolean? = null)

data class CreateOrgInvitationRequest(
    val invitee_id: Int? = null,
    val email: String? = null,
    val role: String? = null,
    val team_ids: List<Int>? = null
)

data class CredentialAuthorization(
    val login: String? = null,
    val credential_id: Int? = null,
    val credential_type: String? = null,
    val token_last_eight: String? = null,
    val credential_authorized_at: String? = null,
    val credential_accessed_at: String? = null,
    val authorized_credential_id: Int? = null,
    val authorized_credential_title: String? = null,
    val authorized_credential_note: String? = null,
    val authorized_credential_expires_at: String? = null,
    val fingerprint: String? = null,
    val scopes: List<String>? = null
)

data class CustomRole(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val base_role: String? = null,
    val permissions: List<String>? = null,
    val organization: Organization? = null,
    val created_at: String? = null,
    val updated_at: String? = null
)

data class CustomRolesResponse(
    val total_count: Int? = null,
    val custom_roles: List<CustomRole>? = null
)

data class CustomRoleRequest(
    val name: String,
    val description: String? = null,
    val base_role: String,
    val permissions: List<String>
)

