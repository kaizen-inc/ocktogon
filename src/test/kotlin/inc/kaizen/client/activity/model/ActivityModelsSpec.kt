package inc.kaizen.client.activity.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ActivityModelsSpec : StringSpec({

    "EventActor should instantiate and compare correctly" {
        val actor = EventActor(id = 1, login = "octocat", display_login = "octocat", gravatar_id = "", url = "url", avatar_url = "avatar")
        actor.id shouldBe 1
        actor.login shouldBe "octocat"
    }

    "EventRepo should instantiate and compare correctly" {
        val repo = EventRepo(id = 1, name = "owner/repo", url = "url")
        repo.id shouldBe 1
        repo.name shouldBe "owner/repo"
    }

    "Event should instantiate and compare correctly" {
        val actor = EventActor(id = 1, login = "octocat")
        val repo = EventRepo(id = 1, name = "owner/repo", url = "url")
        val event = Event(id = "1", type = "PushEvent", actor = actor, repo = repo, public = true, created_at = "2025-01-01T00:00:00Z")
        event.type shouldBe "PushEvent"
        event.actor shouldBe actor
        event.repo shouldBe repo
    }

    "NotificationSubject should instantiate and compare correctly" {
        val subject = NotificationSubject(title = "Issue title", url = "url", latest_comment_url = "comment_url", type = "Issue")
        subject.title shouldBe "Issue title"
        subject.type shouldBe "Issue"
    }

    "Notification should instantiate and compare correctly" {
        val notification = Notification(id = "1", reason = "mention", unread = true, url = "url")
        notification.id shouldBe "1"
        notification.unread shouldBe true
    }

    "ThreadSubscription should instantiate and compare correctly" {
        val sub = ThreadSubscription(subscribed = true, ignored = false, reason = null, created_at = "2025-01-01T00:00:00Z", url = "url", thread_url = "thread_url")
        sub.subscribed shouldBe true
        sub.ignored shouldBe false
    }

    "MarkNotificationsRequest should instantiate and compare correctly" {
        val req = MarkNotificationsRequest(last_read_at = "2025-01-01T00:00:00Z", read = true)
        req.last_read_at shouldBe "2025-01-01T00:00:00Z"
        req.read shouldBe true
    }

    "ThreadSubscriptionRequest should instantiate and compare correctly" {
        val req = ThreadSubscriptionRequest(subscribed = true, ignored = false)
        req.subscribed shouldBe true
        req.ignored shouldBe false
    }

    "RepoSubscription should instantiate and compare correctly" {
        val sub = RepoSubscription(subscribed = true, ignored = false, reason = null, created_at = "2025-01-01T00:00:00Z", url = "url", repository_url = "repo_url")
        sub.subscribed shouldBe true
        sub.repository_url shouldBe "repo_url"
    }

    "SetRepoSubscriptionRequest should instantiate and compare correctly" {
        val req = SetRepoSubscriptionRequest(subscribed = true, ignored = false)
        req.subscribed shouldBe true
        req.ignored shouldBe false
    }
})

