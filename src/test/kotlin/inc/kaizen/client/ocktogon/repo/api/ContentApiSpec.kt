package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.repo.model.ContentFile
import inc.kaizen.client.repo.model.CreateOrUpdateFileRequest
import inc.kaizen.client.repo.model.DeleteFileRequest
import inc.kaizen.client.repo.model.FileCommitResponse
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class ContentApiSpec : FunSpec({
    val api = mockk<ContentApi>()
    val owner = "owner"; val repo = "repo"
    val contentFile = mockk<ContentFile>()
    val fileCommitResp = mockk<FileCommitResponse>()
    val createReq = CreateOrUpdateFileRequest(message = "add file", content = "Y29udGVudA==")
    val deleteReq = DeleteFileRequest(message = "delete file", sha = "abc123")

    test("getReadme returns content file") {
        coEvery { api.getReadme(owner, repo, any()) } returns contentFile
        runBlocking { api.getReadme(owner, repo) } shouldBe contentFile
    }
    test("getReadmeInDir returns content file") {
        coEvery { api.getReadmeInDir(owner, repo, "docs", any()) } returns contentFile
        runBlocking { api.getReadmeInDir(owner, repo, "docs") } shouldBe contentFile
    }
    test("getContent returns content") {
        coEvery { api.getContent(owner, repo, "README.md", any()) } returns contentFile
        runBlocking { api.getContent(owner, repo, "README.md") } shouldBe contentFile
    }
    test("createOrUpdateFileContent returns file commit response") {
        coEvery { api.createOrUpdateFileContent(owner, repo, "README.md", createReq) } returns fileCommitResp
        runBlocking { api.createOrUpdateFileContent(owner, repo, "README.md", createReq) } shouldBe fileCommitResp
    }
    test("deleteFile returns file commit response") {
        coEvery { api.deleteFile(owner, repo, "README.md", deleteReq) } returns fileCommitResp
        runBlocking { api.deleteFile(owner, repo, "README.md", deleteReq) } shouldBe fileCommitResp
    }
    test("downloadTarball returns response") {
        coEvery { api.downloadTarball(owner, repo, "main") } returns Response.success(Unit)
        runBlocking { api.downloadTarball(owner, repo, "main").isSuccessful } shouldBe true
    }
    test("downloadZipball returns response") {
        coEvery { api.downloadZipball(owner, repo, "main") } returns Response.success(Unit)
        runBlocking { api.downloadZipball(owner, repo, "main").isSuccessful } shouldBe true
    }
})

