package inc.kaizen.client.orgs.model

import inc.kaizen.client.common.User
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrgTeamModelsSpec : StringSpec({

    "TeamMembership should instantiate and compare correctly" {
        val membership = TeamMembership(url = "url", role = "member", state = "active")
        membership.role shouldBe "member"
        membership.state shouldBe "active"
    }

    "TeamMembershipRequest should instantiate and compare correctly" {
        val req = TeamMembershipRequest(role = "maintainer")
        req.role shouldBe "maintainer"
    }

    "TeamRepoPermissionRequest should instantiate and compare correctly" {
        val req = TeamRepoPermissionRequest(permission = "push")
        req.permission shouldBe "push"
    }

    "CreateTeamRequest should instantiate and compare correctly" {
        val req = CreateTeamRequest(name = "backend-team", description = "Backend engineers", privacy = "closed")
        req.name shouldBe "backend-team"
        req.privacy shouldBe "closed"
    }

    "UpdateTeamRequest should instantiate and compare correctly" {
        val req = UpdateTeamRequest(name = "new-team-name", description = "Updated description")
        req.name shouldBe "new-team-name"
        req.description shouldBe "Updated description"
    }

    "TeamDiscussion should instantiate and compare correctly" {
        val author = User(id = 1, login = "octocat")
        val discussion = TeamDiscussion(author = author, title = "New feature discussion", body = "Let's discuss", pinned = false)
        discussion.title shouldBe "New feature discussion"
        discussion.author shouldBe author
    }

    "TeamDiscussionComment should instantiate and compare correctly" {
        val author = User(id = 1, login = "octocat")
        val comment = TeamDiscussionComment(author = author, body = "Great idea!", number = 1)
        comment.body shouldBe "Great idea!"
        comment.number shouldBe 1
    }

    "CreateDiscussionRequest should instantiate and compare correctly" {
        val req = CreateDiscussionRequest(title = "New Discussion", body = "Let's discuss", private = false)
        req.title shouldBe "New Discussion"
        req.private shouldBe false
    }

    "UpdateDiscussionRequest should instantiate and compare correctly" {
        val req = UpdateDiscussionRequest(title = "Updated Title", body = "Updated body")
        req.title shouldBe "Updated Title"
        req.body shouldBe "Updated body"
    }

    "CreateDiscussionCommentRequest should instantiate and compare correctly" {
        val req = CreateDiscussionCommentRequest(body = "My comment")
        req.body shouldBe "My comment"
    }
})

