package inc.kaizen.client.ocktogon.git.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GitDataModelsSpec : StringSpec({

    "GitBlob should instantiate and compare correctly" {
        val blob = GitBlob(content = "base64content", encoding = "base64", sha = "abc123", size = 100)
        blob.sha shouldBe "abc123"
        blob.encoding shouldBe "base64"
    }

    "GitBlobRef should instantiate and compare correctly" {
        val ref = GitBlobRef(url = "url", sha = "abc123")
        ref.sha shouldBe "abc123"
    }

    "CreateBlobRequest should instantiate and compare correctly" {
        val req = CreateBlobRequest(content = "fun main() {}", encoding = "utf-8")
        req.content shouldBe "fun main() {}"
        req.encoding shouldBe "utf-8"
    }

    "GitCommitAuthorRequest should instantiate and compare correctly" {
        val author = GitCommitAuthorRequest(name = "Octocat", email = "octocat@github.com", date = "2025-01-01T00:00:00Z")
        author.name shouldBe "Octocat"
        author.email shouldBe "octocat@github.com"
    }

    "GitCommit should instantiate and compare correctly" {
        val commit = GitCommit(sha = "abc123", message = "Initial commit", url = "url")
        commit.sha shouldBe "abc123"
        commit.message shouldBe "Initial commit"
    }

    "CreateGitCommitRequest should instantiate and compare correctly" {
        val req = CreateGitCommitRequest(message = "Initial commit", tree = "tree-sha", parents = listOf("parent-sha"))
        req.message shouldBe "Initial commit"
        req.tree shouldBe "tree-sha"
    }

    "GitRefObject should instantiate and compare correctly" {
        val obj = GitRefObject(type = "commit", sha = "abc123", url = "url")
        obj.type shouldBe "commit"
        obj.sha shouldBe "abc123"
    }

    "GitRef should instantiate and compare correctly" {
        val obj = GitRefObject(type = "commit", sha = "abc123")
        val ref = GitRef(ref = "refs/heads/main", node_id = "node", url = "url", `object` = obj)
        ref.ref shouldBe "refs/heads/main"
        ref.`object` shouldBe obj
    }

    "CreateRefRequest should instantiate and compare correctly" {
        val req = CreateRefRequest(ref = "refs/heads/feature", sha = "abc123")
        req.ref shouldBe "refs/heads/feature"
        req.sha shouldBe "abc123"
    }

    "UpdateRefRequest should instantiate and compare correctly" {
        val req = UpdateRefRequest(sha = "newsha", force = true)
        req.sha shouldBe "newsha"
        req.force shouldBe true
    }

    "GitTag should instantiate and compare correctly" {
        val tag = GitTag(tag = "v1.0.0", sha = "abc123", message = "Release v1.0.0")
        tag.tag shouldBe "v1.0.0"
        tag.sha shouldBe "abc123"
    }

    "CreateTagRequest should instantiate and compare correctly" {
        val req = CreateTagRequest(tag = "v1.0.0", message = "Release", `object` = "abc123", type = "commit")
        req.tag shouldBe "v1.0.0"
        req.type shouldBe "commit"
    }

    "GitTreeItem should instantiate and compare correctly" {
        val item = GitTreeItem(path = "src/main.kt", mode = "100644", type = "blob", sha = "abc123")
        item.path shouldBe "src/main.kt"
        item.mode shouldBe "100644"
    }

    "GitTree should instantiate and compare correctly" {
        val item = GitTreeItem(path = "src/main.kt", mode = "100644", type = "blob", sha = "abc123")
        val tree = GitTree(sha = "tree-sha", url = "url", tree = listOf(item), truncated = false)
        tree.sha shouldBe "tree-sha"
        tree.tree?.size shouldBe 1
    }

    "CreateTreeItem should instantiate and compare correctly" {
        val item = CreateTreeItem(path = "src/main.kt", mode = "100644", type = "blob", content = "fun main() {}")
        item.path shouldBe "src/main.kt"
        item.content shouldBe "fun main() {}"
    }

    "CreateTreeRequest should instantiate and compare correctly" {
        val item = CreateTreeItem(path = "src/main.kt", mode = "100644", type = "blob")
        val req = CreateTreeRequest(tree = listOf(item), base_tree = "base-sha")
        req.tree.size shouldBe 1
        req.base_tree shouldBe "base-sha"
    }
})

