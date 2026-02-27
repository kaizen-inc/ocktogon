package inc.kaizen.client.repo.api

import inc.kaizen.client.repo.model.RepoInvitation
import inc.kaizen.client.repo.model.UpdateInvitationRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class RepoInvitationApiSpec : FunSpec({
    val api = mockk<RepoInvitationApi>()
    val owner = "owner"; val repo = "repo"; val invitationId = 1L
    val invitation = mockk<RepoInvitation>()
    val invitations = listOf(invitation)
    val updateReq = UpdateInvitationRequest(permissions = "push")

    test("listRepoInvitations returns invitations") {
        coEvery { api.listRepoInvitations(owner, repo, any(), any()) } returns invitations
        runBlocking { api.listRepoInvitations(owner, repo) } shouldBe invitations
    }
    test("updateRepoInvitation returns invitation") {
        coEvery { api.updateRepoInvitation(owner, repo, invitationId, updateReq) } returns invitation
        runBlocking { api.updateRepoInvitation(owner, repo, invitationId, updateReq) } shouldBe invitation
    }
    test("deleteRepoInvitation returns response") {
        coEvery { api.deleteRepoInvitation(owner, repo, invitationId) } returns Response.success(Unit)
        runBlocking { api.deleteRepoInvitation(owner, repo, invitationId).isSuccessful } shouldBe true
    }
    test("listRepoInvitationsForAuthenticatedUser returns invitations") {
        coEvery { api.listRepoInvitationsForAuthenticatedUser(any(), any()) } returns invitations
        runBlocking { api.listRepoInvitationsForAuthenticatedUser() } shouldBe invitations
    }
    test("acceptRepoInvitation returns response") {
        coEvery { api.acceptRepoInvitation(invitationId) } returns Response.success(Unit)
        runBlocking { api.acceptRepoInvitation(invitationId).isSuccessful } shouldBe true
    }
    test("declineRepoInvitation returns response") {
        coEvery { api.declineRepoInvitation(invitationId) } returns Response.success(Unit)
        runBlocking { api.declineRepoInvitation(invitationId).isSuccessful } shouldBe true
    }
})

