package inc.kaizen.client.search.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SearchModelsSpec : StringSpec({

    "CodeSearchItem should instantiate and compare correctly" {
        val item = CodeSearchItem(name = "main.kt", path = "src/main.kt", sha = "abc123", score = 1.0)
        item.name shouldBe "main.kt"
        item.path shouldBe "src/main.kt"
    }

    "CodeSearchResult should instantiate and compare correctly" {
        val item = CodeSearchItem(name = "main.kt")
        val result = CodeSearchResult(total_count = 1, incomplete_results = false, items = listOf(item))
        result.total_count shouldBe 1
        result.items?.size shouldBe 1
    }

    "CommitSearchData should instantiate and compare correctly" {
        val data = CommitSearchData(message = "Initial commit", url = "url", comment_count = 0)
        data.message shouldBe "Initial commit"
    }

    "CommitSearchItem should instantiate and compare correctly" {
        val item = CommitSearchItem(sha = "abc123", html_url = "url", score = 1.0)
        item.sha shouldBe "abc123"
    }

    "CommitSearchResult should instantiate and compare correctly" {
        val item = CommitSearchItem(sha = "abc123")
        val result = CommitSearchResult(total_count = 1, incomplete_results = false, items = listOf(item))
        result.total_count shouldBe 1
    }

    "PullRequestRef should instantiate and compare correctly" {
        val ref = PullRequestRef(html_url = "url", diff_url = "diff_url", patch_url = "patch_url")
        ref.html_url shouldBe "url"
    }

    "IssueSearchItem should instantiate and compare correctly" {
        val item = IssueSearchItem(id = 1, number = 42, title = "Bug fix", state = "open", score = 1.0)
        item.title shouldBe "Bug fix"
        item.state shouldBe "open"
    }

    "IssueSearchResult should instantiate and compare correctly" {
        val item = IssueSearchItem(id = 1, title = "Bug")
        val result = IssueSearchResult(total_count = 1, incomplete_results = false, items = listOf(item))
        result.total_count shouldBe 1
    }

    "LabelSearchItem should instantiate and compare correctly" {
        val item = LabelSearchItem(id = 1, name = "bug", color = "d73a4a", default = true, score = 1.0)
        item.name shouldBe "bug"
        item.default shouldBe true
    }

    "LabelSearchResult should instantiate and compare correctly" {
        val item = LabelSearchItem(id = 1, name = "bug")
        val result = LabelSearchResult(total_count = 1, incomplete_results = false, items = listOf(item))
        result.total_count shouldBe 1
    }

    "RepoSearchResult should instantiate and compare correctly" {
        val result = RepoSearchResult(total_count = 0, incomplete_results = false, items = listOf())
        result.total_count shouldBe 0
    }

    "TopicRelationItem should instantiate and compare correctly" {
        val item = TopicRelationItem(id = 1, name = "related-topic", topic_id = 10, relation_type = "related")
        item.name shouldBe "related-topic"
    }

    "TopicRelation should instantiate and compare correctly" {
        val item = TopicRelationItem(id = 1, name = "related-topic")
        val rel = TopicRelation(topic_relation = item)
        rel.topic_relation shouldBe item
    }

    "TopicAlias should instantiate and compare correctly" {
        val item = TopicRelationItem(id = 1, name = "alias")
        val alias = TopicAlias(topic_relation = item)
        alias.topic_relation shouldBe item
    }

    "TopicSearchItem should instantiate and compare correctly" {
        val item = TopicSearchItem(name = "kotlin", display_name = "Kotlin", featured = true, curated = true, score = 1.0)
        item.name shouldBe "kotlin"
        item.featured shouldBe true
    }

    "TopicSearchResult should instantiate and compare correctly" {
        val item = TopicSearchItem(name = "kotlin")
        val result = TopicSearchResult(total_count = 1, incomplete_results = false, items = listOf(item))
        result.total_count shouldBe 1
    }

    "UserSearchResult should instantiate and compare correctly" {
        val result = UserSearchResult(total_count = 0, incomplete_results = false, items = listOf())
        result.total_count shouldBe 0
        result.incomplete_results shouldBe false
    }
})
