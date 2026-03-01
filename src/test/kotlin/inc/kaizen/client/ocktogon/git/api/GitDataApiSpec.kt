package inc.kaizen.client.ocktogon.git.api

import inc.kaizen.client.ocktogon.git.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class GitDataApiSpec : FunSpec({
    val api = mockk<GitDataApi>()
    val owner = "owner"; val repo = "repo"
    val blob = mockk<GitBlob>()
    val blobRef = mockk<GitBlobRef>()
    val commit = mockk<GitCommit>()
    val ref = mockk<GitRef>()
    val refs = listOf(ref)
    val tag = mockk<GitTag>()
    val tree = mockk<GitTree>()
    val createBlobReq = CreateBlobRequest(content = "content")
    val createCommitReq = CreateGitCommitRequest(message = "msg", tree = "tree")
    val createRefReq = CreateRefRequest(ref = "refs/heads/main", sha = "abc")
    val updateRefReq = UpdateRefRequest(sha = "newsha")
    val createTagReq = CreateTagRequest(tag = "v1", message = "msg", `object` = "sha", type = "commit")
    val createTreeReq = CreateTreeRequest(tree = listOf())

    test("getBlob returns blob") {
        coEvery { api.getBlob(owner, repo, "sha") } returns blob
        runBlocking { api.getBlob(owner, repo, "sha") shouldBe blob }
    }
    test("createBlob returns blob ref") {
        coEvery { api.createBlob(owner, repo, createBlobReq) } returns blobRef
        runBlocking { api.createBlob(owner, repo, createBlobReq) shouldBe blobRef }
    }
    test("getCommit returns commit") {
        coEvery { api.getCommit(owner, repo, "sha") } returns commit
        runBlocking { api.getCommit(owner, repo, "sha") shouldBe commit }
    }
    test("createCommit returns commit") {
        coEvery { api.createCommit(owner, repo, createCommitReq) } returns commit
        runBlocking { api.createCommit(owner, repo, createCommitReq) shouldBe commit }
    }
    test("getRef returns ref") {
        coEvery { api.getRef(owner, repo, "heads/main") } returns ref
        runBlocking { api.getRef(owner, repo, "heads/main") shouldBe ref }
    }
    test("listMatchingRefs returns refs") {
        coEvery { api.listMatchingRefs(owner, repo, "heads") } returns refs
        runBlocking { api.listMatchingRefs(owner, repo, "heads") shouldBe refs }
    }
    test("createRef returns ref") {
        coEvery { api.createRef(owner, repo, createRefReq) } returns ref
        runBlocking { api.createRef(owner, repo, createRefReq) shouldBe ref }
    }
    test("updateRef returns ref") {
        coEvery { api.updateRef(owner, repo, "heads/main", updateRefReq) } returns ref
        runBlocking { api.updateRef(owner, repo, "heads/main", updateRefReq) shouldBe ref }
    }
    test("deleteRef returns response") {
        coEvery { api.deleteRef(owner, repo, "heads/feature") } returns Response.success(Unit)
        runBlocking { api.deleteRef(owner, repo, "heads/feature").isSuccessful shouldBe true }
    }
    test("getTag returns tag") {
        coEvery { api.getTag(owner, repo, "sha") } returns tag
        runBlocking { api.getTag(owner, repo, "sha") shouldBe tag }
    }
    test("createTag returns tag") {
        coEvery { api.createTag(owner, repo, createTagReq) } returns tag
        runBlocking { api.createTag(owner, repo, createTagReq) shouldBe tag }
    }
    test("getTree returns tree") {
        coEvery { api.getTree(owner, repo, "sha", any()) } returns tree
        runBlocking { api.getTree(owner, repo, "sha") shouldBe tree }
    }
    test("createTree returns tree") {
        coEvery { api.createTree(owner, repo, createTreeReq) } returns tree
        runBlocking { api.createTree(owner, repo, createTreeReq) shouldBe tree }
    }
})

