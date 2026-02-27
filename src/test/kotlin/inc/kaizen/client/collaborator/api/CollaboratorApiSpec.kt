package inc.kaizen.client.collaborator.api

import inc.kaizen.client.collaborator.model.CollaboratorPermission
import inc.kaizen.client.collaborator.model.Permission
import inc.kaizen.client.user.model.User
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class CollaboratorApiSpec : FunSpec({
    val api = mockk<CollaboratorApi>()
    val owner = "owner"; val repo = "repo"; val username = "octocat"
    val user = mockk<User>()
    val users = listOf(user)
    val permission = mockk<CollaboratorPermission>()

    test("getRepoCollaborators returns users") {
        coEvery { api.getRepoCollaborators(owner, repo, any(), any(), any(), any()) } returns users
        runBlocking { api.getRepoCollaborators(owner, repo) } shouldBe users
    }
    test("isUserACollaborator returns response") {
        coEvery { api.isUserACollaborator(owner, repo, username) } returns Response.success(Unit)
        runBlocking { api.isUserACollaborator(owner, repo, username).isSuccessful } shouldBe true
    }
    test("addUserAsCollaborator returns user") {
        coEvery { api.addUserAsCollaborator(owner, repo, username, any()) } returns user
        runBlocking { api.addUserAsCollaborator(owner, repo, username, Permission.push) } shouldBe user
    }
    test("removeUserAsCollaborator returns response") {
        coEvery { api.removeUserAsCollaborator(owner, repo, username) } returns Response.success(Unit)
        runBlocking { api.removeUserAsCollaborator(owner, repo, username).isSuccessful } shouldBe true
    }
    test("getCollaboratorPermission returns permission") {
        coEvery { api.getCollaboratorPermission(owner, repo, username) } returns permission
        runBlocking { api.getCollaboratorPermission(owner, repo, username) } shouldBe permission
    }
})