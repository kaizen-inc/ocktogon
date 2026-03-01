package inc.kaizen.client.ocktogon.issue.model

import inc.kaizen.client.common.User
import inc.kaizen.client.issue.model.comment.Comment
import inc.kaizen.client.issue.model.event.Event
import inc.kaizen.client.issue.model.issue.Issue
import inc.kaizen.client.issue.model.label.Label
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class IssueModelsSpec : StringSpec({

    "Filter enum should have correct values" {
        Filter.values().size shouldBe 6
        Filter.assigned.name shouldBe "assigned"
        Filter.all.name shouldBe "all"
    }

    "SortComment enum should have correct values" {
        SortComment.values().size shouldBe 2
        SortComment.created.name shouldBe "created"
        SortComment.updated.name shouldBe "updated"
    }

    "SortIssue enum should have correct values" {
        SortIssue.values().size shouldBe 3
        SortIssue.created.name shouldBe "created"
        SortIssue.comments.name shouldBe "comments"
    }

    "Comment should instantiate and compare correctly" {
        val user = User(id = 1, login = "octocat")
        val comment = Comment(id = 1, body = "Nice issue!", author_association = "OWNER", url = "url", user = user)
        comment.id shouldBe 1
        comment.body shouldBe "Nice issue!"
        comment.user shouldBe user
    }

    "Label should instantiate and compare correctly" {
        val label = Label(color = "d73a4a", default = true, description = "Something isn't working", id = 1, name = "bug", node_id = "node", url = "url")
        label.name shouldBe "bug"
        label.color shouldBe "d73a4a"
        label.default shouldBe true
    }

    "Issue should instantiate and compare correctly" {
        val user = User(id = 1, login = "octocat")
        val issue = Issue(id = 1, number = 42, title = "Fix bug", state = "open", user = user, body = "Description")
        issue.id shouldBe 1
        issue.title shouldBe "Fix bug"
        issue.user shouldBe user
    }

    "Event should instantiate and compare correctly" {
        val actor = User(id = 1, login = "octocat")
        val event = Event(actor = actor, event = "closed", id = 1, commit_id = "abc123")
        event.event shouldBe "closed"
        event.actor shouldBe actor
    }

    "CreateIssueRequest should instantiate and compare correctly" {
        val req = CreateIssueRequest(title = "New bug", body = "Description", assignee = "octocat", labels = listOf("bug"))
        req.title shouldBe "New bug"
        req.labels shouldBe listOf("bug")
    }

    "UpdateIssueRequest should instantiate and compare correctly" {
        val req = UpdateIssueRequest(title = "Updated title", state = "closed", state_reason = "completed")
        req.title shouldBe "Updated title"
        req.state shouldBe "closed"
    }

    "LockIssueRequest should instantiate and compare correctly" {
        val req = LockIssueRequest(lock_reason = "off-topic")
        req.lock_reason shouldBe "off-topic"
    }

    "UpdateCommentRequest should instantiate and compare correctly" {
        val req = UpdateCommentRequest(body = "Updated comment")
        req.body shouldBe "Updated comment"
    }

    "LabelRequest should instantiate and compare correctly" {
        val req = LabelRequest(name = "enhancement", color = "a2eeef", description = "New feature")
        req.name shouldBe "enhancement"
        req.color shouldBe "a2eeef"
    }

    "MilestoneRequest should instantiate and compare correctly" {
        val req = MilestoneRequest(title = "v1.0", state = "open", description = "First milestone", due_on = "2025-12-31T00:00:00Z")
        req.title shouldBe "v1.0"
        req.state shouldBe "open"
    }

    "AddLabelsRequest should instantiate and compare correctly" {
        val req = AddLabelsRequest(labels = listOf("bug", "enhancement"))
        req.labels shouldBe listOf("bug", "enhancement")
    }

    "AssigneesRequest should instantiate and compare correctly" {
        val req = AssigneesRequest(assignees = listOf("octocat", "hubot"))
        req.assignees shouldBe listOf("octocat", "hubot")
    }
})

