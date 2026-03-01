package inc.kaizen.client.ocktogon.search.api

import inc.kaizen.client.search.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class SearchApiSpec : FunSpec({
    val api = mockk<SearchApi>()
    val codeResult = CodeSearchResult(total_count = 0, incomplete_results = false, items = listOf())
    val commitResult = CommitSearchResult(total_count = 0, incomplete_results = false, items = listOf())
    val issueResult = IssueSearchResult(total_count = 0, incomplete_results = false, items = listOf())
    val labelResult = LabelSearchResult(total_count = 0, incomplete_results = false, items = listOf())
    val repoResult = RepoSearchResult(total_count = 0, incomplete_results = false, items = listOf())
    val topicResult = TopicSearchResult(total_count = 0, incomplete_results = false, items = listOf())
    val userResult = UserSearchResult(total_count = 0, incomplete_results = false, items = listOf())

    test("searchCode returns result") {
        coEvery { api.searchCode("kotlin", any(), any(), any(), any()) } returns codeResult
        runBlocking { api.searchCode("kotlin") shouldBe codeResult }
    }
    test("searchCommits returns result") {
        coEvery { api.searchCommits("fix bug", any(), any(), any(), any()) } returns commitResult
        runBlocking { api.searchCommits("fix bug") shouldBe commitResult }
    }
    test("searchIssuesAndPullRequests returns result") {
        coEvery { api.searchIssuesAndPullRequests("is:open", any(), any(), any(), any()) } returns issueResult
        runBlocking { api.searchIssuesAndPullRequests("is:open") shouldBe issueResult }
    }
    test("searchLabels returns result") {
        coEvery { api.searchLabels(1, "bug", any(), any(), any(), any()) } returns labelResult
        runBlocking { api.searchLabels(1, "bug") shouldBe labelResult }
    }
    test("searchRepositories returns result") {
        coEvery { api.searchRepositories("kotlin", any(), any(), any(), any()) } returns repoResult
        runBlocking { api.searchRepositories("kotlin") shouldBe repoResult }
    }
    test("searchTopics returns result") {
        coEvery { api.searchTopics("kotlin", any(), any()) } returns topicResult
        runBlocking { api.searchTopics("kotlin") shouldBe topicResult }
    }
    test("searchUsers returns result") {
        coEvery { api.searchUsers("octocat", any(), any(), any(), any()) } returns userResult
        runBlocking { api.searchUsers("octocat") shouldBe userResult }
    }
})

