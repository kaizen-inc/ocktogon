package inc.kaizen.client.ocktogon.issue.api

import inc.kaizen.client.user.model.User
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import retrofit2.Response

class AssigneeApiSpec : FunSpec({
    val api = mockk<AssigneeApi>()
    val owner = "owner"; val repo = "repo"; val assignee = "octocat"; val issueNumber = 1
    val user = mockk<User>()
    val users = listOf(user)

    test("getRepoAssignees returns users") {
        every { api.getRepoAssignees(owner, repo, any(), any()) } returns users
        api.getRepoAssignees(owner, repo) shouldBe users
    }
    test("canUserBeAssigned returns response") {
        every { api.canUserBeAssigned(owner, repo, assignee) } returns Response.success(Unit)
        api.canUserBeAssigned(owner, repo, assignee).isSuccessful shouldBe true
    }
    test("canUserBeAssignedToIssue returns response") {
        every { api.canUserBeAssignedToIssue(owner, repo, issueNumber, assignee) } returns Response.success(Unit)
        api.canUserBeAssignedToIssue(owner, repo, issueNumber, assignee).isSuccessful shouldBe true
    }
})

