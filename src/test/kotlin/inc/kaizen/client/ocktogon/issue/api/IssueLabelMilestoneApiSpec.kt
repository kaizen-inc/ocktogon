package inc.kaizen.client.ocktogon.issue.api

import inc.kaizen.client.ocktogon.common.Label
import inc.kaizen.client.ocktogon.common.Milestone
import inc.kaizen.client.ocktogon.common.User
import inc.kaizen.client.ocktogon.issue.model.AddLabelsRequest
import inc.kaizen.client.ocktogon.issue.model.AssigneesRequest
import inc.kaizen.client.ocktogon.issue.model.LabelRequest
import inc.kaizen.client.ocktogon.issue.model.MilestoneRequest
import inc.kaizen.client.ocktogon.issue.model.issue.Issue
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class IssueLabelApiSpec : FunSpec({
    val api = mockk<IssueLabelApi>()
    val owner = "owner"; val repo = "repo"; val issueNumber = 1; val milestoneNumber = 1
    val label = mockk<Label>()
    val labels = listOf(label)
    val labelReq = LabelRequest(name = "bug", color = "red")
    val addLabelsReq = AddLabelsRequest(labels = listOf("bug"))

    test("listLabelsForRepo returns labels") {
        coEvery { api.listLabelsForRepo(owner, repo, any(), any()) } returns labels
        runBlocking { api.listLabelsForRepo(owner, repo) } shouldBe labels
    }
    test("createLabel returns label") {
        coEvery { api.createLabel(owner, repo, labelReq) } returns label
        runBlocking { api.createLabel(owner, repo, labelReq) } shouldBe label
    }
    test("getLabel returns label") {
        coEvery { api.getLabel(owner, repo, "bug") } returns label
        runBlocking { api.getLabel(owner, repo, "bug") } shouldBe label
    }
    test("updateLabel returns label") {
        coEvery { api.updateLabel(owner, repo, "bug", labelReq) } returns label
        runBlocking { api.updateLabel(owner, repo, "bug", labelReq) } shouldBe label
    }
    test("deleteLabel returns response") {
        coEvery { api.deleteLabel(owner, repo, "bug") } returns Response.success(Unit)
        runBlocking { api.deleteLabel(owner, repo, "bug").isSuccessful } shouldBe true
    }
    test("listLabelsForIssue returns labels") {
        coEvery { api.listLabelsForIssue(owner, repo, issueNumber, any(), any()) } returns labels
        runBlocking { api.listLabelsForIssue(owner, repo, issueNumber) } shouldBe labels
    }
    test("addLabelsToIssue returns labels") {
        coEvery { api.addLabelsToIssue(owner, repo, issueNumber, addLabelsReq) } returns labels
        runBlocking { api.addLabelsToIssue(owner, repo, issueNumber, addLabelsReq) } shouldBe labels
    }
    test("setLabelsForIssue returns labels") {
        coEvery { api.setLabelsForIssue(owner, repo, issueNumber, addLabelsReq) } returns labels
        runBlocking { api.setLabelsForIssue(owner, repo, issueNumber, addLabelsReq) } shouldBe labels
    }
    test("removeAllLabelsFromIssue returns response") {
        coEvery { api.removeAllLabelsFromIssue(owner, repo, issueNumber) } returns Response.success(Unit)
        runBlocking { api.removeAllLabelsFromIssue(owner, repo, issueNumber).isSuccessful } shouldBe true
    }
    test("removeLabelFromIssue returns labels") {
        coEvery { api.removeLabelFromIssue(owner, repo, issueNumber, "bug") } returns labels
        runBlocking { api.removeLabelFromIssue(owner, repo, issueNumber, "bug") } shouldBe labels
    }
    test("listLabelsForMilestone returns labels") {
        coEvery { api.listLabelsForMilestone(owner, repo, milestoneNumber, any(), any()) } returns labels
        runBlocking { api.listLabelsForMilestone(owner, repo, milestoneNumber) } shouldBe labels
    }
})

class IssueMilestoneApiSpec : FunSpec({
    val api = mockk<IssueMilestoneApi>()
    val owner = "owner"; val repo = "repo"; val milestoneNumber = 1
    val milestone = mockk<Milestone>()
    val milestones = listOf(milestone)
    val milestoneReq = MilestoneRequest(title = "v1.0")

    test("listMilestones returns milestones") {
        coEvery { api.listMilestones(owner, repo, any(), any(), any(), any(), any()) } returns milestones
        runBlocking { api.listMilestones(owner, repo) } shouldBe milestones
    }
    test("createMilestone returns milestone") {
        coEvery { api.createMilestone(owner, repo, milestoneReq) } returns milestone
        runBlocking { api.createMilestone(owner, repo, milestoneReq) } shouldBe milestone
    }
    test("getMilestone returns milestone") {
        coEvery { api.getMilestone(owner, repo, milestoneNumber) } returns milestone
        runBlocking { api.getMilestone(owner, repo, milestoneNumber) } shouldBe milestone
    }
    test("updateMilestone returns milestone") {
        coEvery { api.updateMilestone(owner, repo, milestoneNumber, milestoneReq) } returns milestone
        runBlocking { api.updateMilestone(owner, repo, milestoneNumber, milestoneReq) } shouldBe milestone
    }
    test("deleteMilestone returns response") {
        coEvery { api.deleteMilestone(owner, repo, milestoneNumber) } returns Response.success(Unit)
        runBlocking { api.deleteMilestone(owner, repo, milestoneNumber).isSuccessful } shouldBe true
    }
})

class IssueAssigneeApiSpec : FunSpec({
    val api = mockk<IssueAssigneeApi>()
    val owner = "owner"; val repo = "repo"; val issueNumber = 1; val assignee = "octocat"
    val user = mockk<User>()
    val issue = mockk<Issue>()
    val assigneesReq = AssigneesRequest(assignees = listOf(assignee))

    test("listAssignees returns users") {
        coEvery { api.listAssignees(owner, repo, any(), any()) } returns listOf(user)
        runBlocking { api.listAssignees(owner, repo) } shouldBe listOf(user)
    }
    test("checkUserCanBeAssigned returns response") {
        coEvery { api.checkUserCanBeAssigned(owner, repo, assignee) } returns Response.success(Unit)
        runBlocking { api.checkUserCanBeAssigned(owner, repo, assignee).isSuccessful } shouldBe true
    }
    test("addAssignees returns issue") {
        coEvery { api.addAssignees(owner, repo, issueNumber, assigneesReq) } returns issue
        runBlocking { api.addAssignees(owner, repo, issueNumber, assigneesReq) } shouldBe issue
    }
    test("removeAssignees returns issue") {
        coEvery { api.removeAssignees(owner, repo, issueNumber, assigneesReq) } returns issue
        runBlocking { api.removeAssignees(owner, repo, issueNumber, assigneesReq) } shouldBe issue
    }
    test("checkUserCanBeAssignedToIssue returns response") {
        coEvery { api.checkUserCanBeAssignedToIssue(owner, repo, issueNumber, assignee) } returns Response.success(Unit)
        runBlocking { api.checkUserCanBeAssignedToIssue(owner, repo, issueNumber, assignee).isSuccessful } shouldBe true
    }
})

class IssueTimelineApiSpec : FunSpec({
    val api = mockk<IssueTimelineApi>()
    val owner = "owner"; val repo = "repo"; val issueNumber = 1

    test("listTimelineEvents returns events") {
        coEvery { api.listTimelineEvents(owner, repo, issueNumber, any(), any()) } returns listOf()
        runBlocking { api.listTimelineEvents(owner, repo, issueNumber) } shouldBe listOf()
    }
})

