package inc.kaizen.client.gists.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GistModelsSpec : StringSpec({

    "GistFile should instantiate and compare correctly" {
        val file = GistFile(filename = "hello.kt", type = "application/x-kotlin", language = "Kotlin", size = 100, truncated = false, content = "fun main() {}")
        file.filename shouldBe "hello.kt"
        file.language shouldBe "Kotlin"
    }

    "GistChangeStatus should instantiate and compare correctly" {
        val status = GistChangeStatus(total = 10, additions = 8, deletions = 2)
        status.total shouldBe 10
        status.additions shouldBe 8
    }

    "GistCommit should instantiate and compare correctly" {
        val status = GistChangeStatus(total = 5, additions = 5, deletions = 0)
        val commit = GistCommit(url = "url", version = "abc123", change_status = status, committed_at = "2025-01-01T00:00:00Z")
        commit.version shouldBe "abc123"
        commit.change_status shouldBe status
    }

    "GistFork should instantiate and compare correctly" {
        val fork = GistFork(url = "url", id = "fork-id", created_at = "2025-01-01T00:00:00Z")
        fork.id shouldBe "fork-id"
    }

    "Gist should instantiate and compare correctly" {
        val file = GistFile(filename = "hello.kt", content = "fun main() {}")
        val gist = Gist(id = "gist-id", description = "My gist", public = true, files = mapOf("hello.kt" to file))
        gist.id shouldBe "gist-id"
        gist.public shouldBe true
        gist.files?.containsKey("hello.kt") shouldBe true
    }

    "GistComment should instantiate and compare correctly" {
        val comment = GistComment(id = 1, body = "Great gist!", author_association = "NONE", url = "url")
        comment.id shouldBe 1
        comment.body shouldBe "Great gist!"
    }

    "GistFileRequest should instantiate and compare correctly" {
        val req = GistFileRequest(content = "fun main() {}", filename = "hello.kt")
        req.content shouldBe "fun main() {}"
    }

    "CreateGistRequest should instantiate and compare correctly" {
        val fileReq = GistFileRequest(content = "fun main() {}")
        val req = CreateGistRequest(description = "My gist", files = mapOf("hello.kt" to fileReq), public = true)
        req.description shouldBe "My gist"
        req.public shouldBe true
        req.files.containsKey("hello.kt") shouldBe true
    }

    "UpdateGistRequest should instantiate and compare correctly" {
        val fileReq = GistFileRequest(content = "updated content")
        val req = UpdateGistRequest(description = "Updated gist", files = mapOf("hello.kt" to fileReq))
        req.description shouldBe "Updated gist"
    }

    "CreateGistCommentRequest should instantiate and compare correctly" {
        val req = CreateGistCommentRequest(body = "Nice gist!")
        req.body shouldBe "Nice gist!"
    }
})

