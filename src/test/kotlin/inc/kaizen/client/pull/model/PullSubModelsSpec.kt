package inc.kaizen.client.pull.model

import inc.kaizen.client.common.HRef
import inc.kaizen.client.pull.model.commit.Commit
import inc.kaizen.client.pull.model.commit.PullCommit
import inc.kaizen.client.pull.model.commit.Tree
import inc.kaizen.client.pull.model.commit.Verification
import inc.kaizen.client.pull.model.file.PullFile
import inc.kaizen.client.pull.model.pull.Head
import inc.kaizen.client.pull.model.pull.Links
import inc.kaizen.client.pull.model.pull.RequestedTeam
import inc.kaizen.client.pull.model.review.ReviewComment
import inc.kaizen.client.pull.model.reviewer.RequestedReviewer
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PullSubModelsSpec : StringSpec({

    "Tree should instantiate and compare correctly" {
        val tree = Tree(sha = "tree-sha", url = "url")
        tree.sha shouldBe "tree-sha"
    }

    "Verification should instantiate and compare correctly" {
        val ver = Verification(verified = true, reason = "valid")
        ver.verified shouldBe true
        ver.reason shouldBe "valid"
    }

    "Commit should instantiate and compare correctly" {
        val commit = Commit(message = "Initial commit", comment_count = 0)
        commit.message shouldBe "Initial commit"
        commit.comment_count shouldBe 0
    }

    "PullCommit should instantiate and compare correctly" {
        val pullCommit = PullCommit(sha = "abc123", html_url = "url")
        pullCommit.sha shouldBe "abc123"
    }

    "PullFile should instantiate and compare correctly" {
        val file = PullFile(additions = 10, blob_url = "url", changes = 15, contents_url = "cUrl", deletions = 5, filename = "src/main.kt", patch = "@@ ...", raw_url = "rawUrl", sha = "abc123", status = "modified")
        file.filename shouldBe "src/main.kt"
        file.additions shouldBe 10
        file.status shouldBe "modified"
    }

    "ReviewComment should instantiate and compare correctly" {
        val comment = ReviewComment(id = 1, body = "Please fix", path = "src/main.kt", line = 10, side = "RIGHT")
        comment.id shouldBe 1
        comment.body shouldBe "Please fix"
    }

    "RequestedReviewer should instantiate and compare correctly" {
        val req = RequestedReviewer(teams = listOf(), users = listOf())
        req.teams?.size shouldBe 0
        req.users?.size shouldBe 0
    }

    "Head should instantiate and compare correctly" {
        val head = Head(label = "octocat:feature", ref = "feature", sha = "abc123")
        head.label shouldBe "octocat:feature"
        head.ref shouldBe "feature"
        head.sha shouldBe "abc123"
    }

    "pull.Links should instantiate and compare correctly" {
        val href = HRef(href = "https://api.github.com")
        val links = Links(self = href, html = href, commits = href, statuses = href)
        links.self?.href shouldBe "https://api.github.com"
        links.commits?.href shouldBe "https://api.github.com"
    }

    "RequestedTeam should instantiate and compare correctly" {
        val team = RequestedTeam(
            description = "Dev team", html_url = "url", id = 1,
            members_url = "url", name = "devs", node_id = "node",
            notification_setting = "notifications_enabled", permission = "push",
            privacy = "closed", repositories_url = "url", slug = "devs", url = "url"
        )
        team.name shouldBe "devs"
        team.permission shouldBe "push"
        team.privacy shouldBe "closed"
    }

    "review.Links should instantiate and compare correctly" {
        val href = HRef(href = "https://api.github.com")
        val links = inc.kaizen.client.pull.model.review.Links(self = href, html = href, pull_request = href)
        links.self?.href shouldBe "https://api.github.com"
        links.pull_request?.href shouldBe "https://api.github.com"
    }
})
