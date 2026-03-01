package inc.kaizen.client.ocktogon.orgs.api

import inc.kaizen.client.common.*
import inc.kaizen.client.orgs.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class OrgApiSpec : FunSpec({
    val api = mockk<OrgApi>()
    val org = "my-org"; val username = "octocat"; val hookId = 1L; val credId = 1
    val organization = mockk<Organization>()
    val orgs = listOf(organization)
    val user = mockk<User>()
    val users = listOf(user)
    val membership = mockk<OrgMembership>()
    val invitation = mockk<OrgInvitation>()
    val hook = mockk<Hook>()
    val delivery = mockk<HookDelivery>()
    val customRole = mockk<CustomRole>()
    val customRolesResponse = mockk<CustomRolesResponse>()
    val credAuth = mockk<CredentialAuthorization>()
    val updateOrgReq = UpdateOrgRequest(name = "Updated Org")
    val setMembershipReq = SetOrgMembershipRequest(role = "admin")
    val updateMembershipReq = UpdateOrgMembershipRequest(state = "active")
    val createInviteReq = CreateOrgInvitationRequest(role = "direct_member")
    val createHookReq = mockk<CreateHookRequest>()
    val updateHookReq = mockk<UpdateHookRequest>()
    val customRoleReq = CustomRoleRequest(name = "ci-role", base_role = "read", permissions = listOf("workflows"))

    test("listOrganizations returns orgs") {
        coEvery { api.listOrganizations(any(), any()) } returns orgs
        runBlocking { api.listOrganizations() } shouldBe orgs
    }
    test("listOrgsForAuthenticatedUser returns orgs") {
        coEvery { api.listOrgsForAuthenticatedUser(any(), any()) } returns orgs
        runBlocking { api.listOrgsForAuthenticatedUser() } shouldBe orgs
    }
    test("listOrgsForUser returns orgs") {
        coEvery { api.listOrgsForUser(username, any(), any()) } returns orgs
        runBlocking { api.listOrgsForUser(username) } shouldBe orgs
    }
    test("getOrg returns org") {
        coEvery { api.getOrg(org) } returns organization
        runBlocking { api.getOrg(org) } shouldBe organization
    }
    test("updateOrg returns org") {
        coEvery { api.updateOrg(org, updateOrgReq) } returns organization
        runBlocking { api.updateOrg(org, updateOrgReq) } shouldBe organization
    }
    test("deleteOrg returns response") {
        coEvery { api.deleteOrg(org) } returns Response.success(Unit)
        runBlocking { api.deleteOrg(org).isSuccessful } shouldBe true
    }
    test("listOrgMembers returns users") {
        coEvery { api.listOrgMembers(org, any(), any(), any(), any()) } returns users
        runBlocking { api.listOrgMembers(org) } shouldBe users
    }
    test("checkOrgMembership returns response") {
        coEvery { api.checkOrgMembership(org, username) } returns Response.success(Unit)
        runBlocking { api.checkOrgMembership(org, username).isSuccessful } shouldBe true
    }
    test("removeOrgMember returns response") {
        coEvery { api.removeOrgMember(org, username) } returns Response.success(Unit)
        runBlocking { api.removeOrgMember(org, username).isSuccessful } shouldBe true
    }
    test("getOrgMembership returns membership") {
        coEvery { api.getOrgMembership(org, username) } returns membership
        runBlocking { api.getOrgMembership(org, username) } shouldBe membership
    }
    test("setOrgMembership returns membership") {
        coEvery { api.setOrgMembership(org, username, setMembershipReq) } returns membership
        runBlocking { api.setOrgMembership(org, username, setMembershipReq) } shouldBe membership
    }
    test("removeOrgMembership returns response") {
        coEvery { api.removeOrgMembership(org, username) } returns Response.success(Unit)
        runBlocking { api.removeOrgMembership(org, username).isSuccessful } shouldBe true
    }
    test("listOrgMembershipsForAuthenticatedUser returns memberships") {
        coEvery { api.listOrgMembershipsForAuthenticatedUser(any(), any(), any()) } returns listOf(membership)
        runBlocking { api.listOrgMembershipsForAuthenticatedUser() } shouldBe listOf(membership)
    }
    test("getOrgMembershipForAuthenticatedUser returns membership") {
        coEvery { api.getOrgMembershipForAuthenticatedUser(org) } returns membership
        runBlocking { api.getOrgMembershipForAuthenticatedUser(org) } shouldBe membership
    }
    test("updateOrgMembershipForAuthenticatedUser returns membership") {
        coEvery { api.updateOrgMembershipForAuthenticatedUser(org, updateMembershipReq) } returns membership
        runBlocking { api.updateOrgMembershipForAuthenticatedUser(org, updateMembershipReq) } shouldBe membership
    }
    test("listPublicOrgMembers returns users") {
        coEvery { api.listPublicOrgMembers(org, any(), any()) } returns users
        runBlocking { api.listPublicOrgMembers(org) } shouldBe users
    }
    test("listPendingInvitations returns invitations") {
        coEvery { api.listPendingInvitations(org, any(), any(), any(), any()) } returns listOf(invitation)
        runBlocking { api.listPendingInvitations(org) } shouldBe listOf(invitation)
    }
    test("createInvitation returns invitation") {
        coEvery { api.createInvitation(org, createInviteReq) } returns invitation
        runBlocking { api.createInvitation(org, createInviteReq) } shouldBe invitation
    }
    test("cancelInvitation returns response") {
        coEvery { api.cancelInvitation(org, 1L) } returns Response.success(Unit)
        runBlocking { api.cancelInvitation(org, 1L).isSuccessful } shouldBe true
    }
    test("listBlockedUsers returns users") {
        coEvery { api.listBlockedUsers(org, any(), any()) } returns users
        runBlocking { api.listBlockedUsers(org) } shouldBe users
    }
    test("blockUser returns response") {
        coEvery { api.blockUser(org, username) } returns Response.success(Unit)
        runBlocking { api.blockUser(org, username).isSuccessful } shouldBe true
    }
    test("unblockUser returns response") {
        coEvery { api.unblockUser(org, username) } returns Response.success(Unit)
        runBlocking { api.unblockUser(org, username).isSuccessful } shouldBe true
    }
    test("listSamlSsoAuthorizations returns credentials") {
        coEvery { api.listSamlSsoAuthorizations(org, any(), any(), any()) } returns listOf(credAuth)
        runBlocking { api.listSamlSsoAuthorizations(org) } shouldBe listOf(credAuth)
    }
    test("removeSamlSsoAuthorization returns response") {
        coEvery { api.removeSamlSsoAuthorization(org, credId) } returns Response.success(Unit)
        runBlocking { api.removeSamlSsoAuthorization(org, credId).isSuccessful } shouldBe true
    }
    test("listWebhooks returns hooks") {
        coEvery { api.listWebhooks(org, any(), any()) } returns listOf(hook)
        runBlocking { api.listWebhooks(org) } shouldBe listOf(hook)
    }
    test("createWebhook returns hook") {
        coEvery { api.createWebhook(org, createHookReq) } returns hook
        runBlocking { api.createWebhook(org, createHookReq) } shouldBe hook
    }
    test("getWebhook returns hook") {
        coEvery { api.getWebhook(org, hookId) } returns hook
        runBlocking { api.getWebhook(org, hookId) } shouldBe hook
    }
    test("updateWebhook returns hook") {
        coEvery { api.updateWebhook(org, hookId, updateHookReq) } returns hook
        runBlocking { api.updateWebhook(org, hookId, updateHookReq) } shouldBe hook
    }
    test("deleteWebhook returns response") {
        coEvery { api.deleteWebhook(org, hookId) } returns Response.success(Unit)
        runBlocking { api.deleteWebhook(org, hookId).isSuccessful } shouldBe true
    }
    test("pingWebhook returns response") {
        coEvery { api.pingWebhook(org, hookId) } returns Response.success(Unit)
        runBlocking { api.pingWebhook(org, hookId).isSuccessful } shouldBe true
    }
    test("listDeliveriesForWebhook returns deliveries") {
        coEvery { api.listDeliveriesForWebhook(org, hookId, any(), any()) } returns listOf(delivery)
        runBlocking { api.listDeliveriesForWebhook(org, hookId) } shouldBe listOf(delivery)
    }
    test("getWebhookDelivery returns delivery") {
        coEvery { api.getWebhookDelivery(org, hookId, 1L) } returns delivery
        runBlocking { api.getWebhookDelivery(org, hookId, 1L) } shouldBe delivery
    }
    test("listCustomRoles returns custom roles response") {
        coEvery { api.listCustomRoles(org) } returns customRolesResponse
        runBlocking { api.listCustomRoles(org) } shouldBe customRolesResponse
    }
    test("createCustomRole returns custom role") {
        coEvery { api.createCustomRole(org, customRoleReq) } returns customRole
        runBlocking { api.createCustomRole(org, customRoleReq) } shouldBe customRole
    }
    test("getCustomRole returns custom role") {
        coEvery { api.getCustomRole(org, 1L) } returns customRole
        runBlocking { api.getCustomRole(org, 1L) } shouldBe customRole
    }
    test("updateCustomRole returns custom role") {
        coEvery { api.updateCustomRole(org, 1L, customRoleReq) } returns customRole
        runBlocking { api.updateCustomRole(org, 1L, customRoleReq) } shouldBe customRole
    }
    test("deleteCustomRole returns response") {
        coEvery { api.deleteCustomRole(org, 1L) } returns Response.success(Unit)
        runBlocking { api.deleteCustomRole(org, 1L).isSuccessful } shouldBe true
    }
})
