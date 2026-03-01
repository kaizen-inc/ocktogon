package inc.kaizen.client.ocktogon.orgs.model

import inc.kaizen.client.common.Organization
import inc.kaizen.client.common.User
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrgModelsSpec : StringSpec({

    "OrgMembership should instantiate and compare correctly" {
        val org = Organization(id = 1, login = "my-org")
        val user = User(id = 1, login = "octocat")
        val membership = OrgMembership(url = "url", state = "active", role = "member", organization = org, user = user)
        membership.state shouldBe "active"
        membership.role shouldBe "member"
        membership.organization shouldBe org
    }

    "OrgInvitation should instantiate and compare correctly" {
        val inv = OrgInvitation(id = 1, login = "newuser", email = "new@example.com", role = "direct_member", team_count = 2)
        inv.login shouldBe "newuser"
        inv.role shouldBe "direct_member"
    }

    "UpdateOrgRequest should instantiate and compare correctly" {
        val req = UpdateOrgRequest(name = "Updated Org", email = "admin@example.com", billing_email = "billing@example.com")
        req.name shouldBe "Updated Org"
        req.billing_email shouldBe "billing@example.com"
    }

    "SetOrgMembershipRequest should instantiate and compare correctly" {
        val req = SetOrgMembershipRequest(role = "admin")
        req.role shouldBe "admin"
    }

    "UpdateOrgMembershipRequest should instantiate and compare correctly" {
        val req = UpdateOrgMembershipRequest(state = "active")
        req.state shouldBe "active"
    }

    "ConvertCollaboratorRequest should instantiate and compare correctly" {
        val req = ConvertCollaboratorRequest(async = true)
        req.async shouldBe true
    }

    "CreateOrgInvitationRequest should instantiate and compare correctly" {
        val req = CreateOrgInvitationRequest(invitee_id = 1, email = "new@example.com", role = "direct_member", team_ids = listOf(1, 2))
        req.invitee_id shouldBe 1
        req.team_ids shouldBe listOf(1, 2)
    }

    "CredentialAuthorization should instantiate and compare correctly" {
        val cred = CredentialAuthorization(login = "octocat", credential_id = 1, credential_type = "personal_access_token")
        cred.login shouldBe "octocat"
        cred.credential_type shouldBe "personal_access_token"
    }

    "CustomRole should instantiate and compare correctly" {
        val role = CustomRole(id = 1, name = "ci-role", description = "CI runner role", base_role = "read", permissions = listOf("workflows"))
        role.name shouldBe "ci-role"
        role.permissions shouldBe listOf("workflows")
    }

    "CustomRolesResponse should instantiate and compare correctly" {
        val role = CustomRole(id = 1, name = "ci-role", base_role = "read", permissions = listOf("workflows"))
        val resp = CustomRolesResponse(total_count = 1, custom_roles = listOf(role))
        resp.total_count shouldBe 1
        resp.custom_roles?.size shouldBe 1
    }

    "CustomRoleRequest should instantiate and compare correctly" {
        val req = CustomRoleRequest(name = "ci-role", description = "For CI", base_role = "read", permissions = listOf("workflows"))
        req.name shouldBe "ci-role"
        req.base_role shouldBe "read"
    }
})

