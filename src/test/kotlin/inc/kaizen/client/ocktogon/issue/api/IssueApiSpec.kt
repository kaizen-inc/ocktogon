package inc.kaizen.client.ocktogon.issue.api

import inc.kaizen.client.issue.model.*
import inc.kaizen.client.issue.model.comment.Comment
import inc.kaizen.client.issue.model.event.Event
import inc.kaizen.client.issue.model.issue.Issue
import inc.kaizen.client.pull.model.Direction
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import retrofit2.Response

class IssueApiSpec : FunSpec({
    val api = mockk<IssueApi>()
    val owner = "owner"; val repo = "repo"; val org = "my-org"
    val issueNumber = 1; val commentId = 1; val eventId = 1
    val issue = mockk<Issue>()
    val issues = listOf(issue)
    val comment = mockk<Comment>()
    val event = mockk<Event>()
    val createIssueReq = CreateIssueRequest(title = "New issue")
    val updateIssueReq = UpdateIssueRequest(state = "closed")
    val lockReq = LockIssueRequest(lock_reason = "off-topic")
    val commentReq = UpdateCommentRequest(body = "Nice!")

    test("getIssues returns issues") {
        every { api.getIssues(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns issues
        api.getIssues(Filter.assigned, State.open, "", SortIssue.created, Direction.desc, "", perPage = 30, page = 1) shouldBe issues
    }
    test("getOrgIssues returns issues") {
        every { api.getOrgIssues(org, any(), any(), any(), any(), any(), any(), any(), any()) } returns issues
        api.getOrgIssues(org, labels = "", since = "") shouldBe issues
    }
    test("getRepoIssues returns issues") {
        every { api.getRepoIssues(owner, repo, any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns issues
        api.getRepoIssues(owner, repo, milestone = "", assignee = "", creator = "", mentioned = "", labels = "", since = "") shouldBe issues
    }
    test("getIssue returns issue") {
        every { api.getIssue(owner, repo, issueNumber) } returns issue
        api.getIssue(owner, repo, issueNumber) shouldBe issue
    }
    test("getLoggedInUserIssues returns issues") {
        every { api.getLoggedInUserIssues(any(), any(), any(), any(), any(), any(), any(), any()) } returns issues
        api.getLoggedInUserIssues(labels = "", since = "") shouldBe issues
    }
    test("getRepoComments returns comments") {
        every { api.getRepoComments(owner, repo, any(), any(), any(), any(), any()) } returns listOf(comment)
        api.getRepoComments(owner, repo, sort = SortComment.created, direction = Direction.asc, since = "") shouldBe listOf(comment)
    }
    test("getRepoComment returns comment") {
        every { api.getRepoComment(owner, repo, commentId) } returns comment
        api.getRepoComment(owner, repo, commentId) shouldBe comment
    }
    test("getIssueComments returns comments") {
        every { api.getIssueComments(owner, repo, issueNumber, any(), any(), any()) } returns listOf(comment)
        api.getIssueComments(owner, repo, issueNumber, since = "") shouldBe listOf(comment)
    }
    test("updateIssueComment returns comment") {
        every { api.updateIssueComment(owner, repo, commentId, commentReq) } returns comment
        api.updateIssueComment(owner, repo, commentId, commentReq) shouldBe comment
    }
    test("deleteIssueComment returns response") {
        every { api.deleteIssueComment(owner, repo, commentId) } returns Response.success(Unit)
        api.deleteIssueComment(owner, repo, commentId).isSuccessful shouldBe true
    }
    test("getRepoIssueEvents returns events") {
        every { api.getRepoIssueEvents(owner, repo, any(), any()) } returns listOf(event)
        api.getRepoIssueEvents(owner, repo) shouldBe listOf(event)
    }
    test("getRepoIssueEvent returns event") {
        every { api.getRepoIssueEvent(owner, repo, eventId) } returns event
        api.getRepoIssueEvent(owner, repo, eventId) shouldBe event
    }
    test("createIssue returns issue") {
        every { api.createIssue(owner, repo, createIssueReq) } returns issue
        api.createIssue(owner, repo, createIssueReq) shouldBe issue
    }
    test("updateIssue returns issue") {
        every { api.updateIssue(owner, repo, issueNumber, updateIssueReq) } returns issue
        api.updateIssue(owner, repo, issueNumber, updateIssueReq) shouldBe issue
    }
    test("lockIssue returns response") {
        every { api.lockIssue(owner, repo, issueNumber, lockReq) } returns Response.success(Unit)
        api.lockIssue(owner, repo, issueNumber, lockReq).isSuccessful shouldBe true
    }
    test("unlockIssue returns response") {
        every { api.unlockIssue(owner, repo, issueNumber) } returns Response.success(Unit)
        api.unlockIssue(owner, repo, issueNumber).isSuccessful shouldBe true
    }
})
