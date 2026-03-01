package inc.kaizen.client.ocktogon.releases.model

import inc.kaizen.client.ocktogon.user.model.User
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ReleaseAssetSpec : StringSpec({
    "ReleaseAsset should instantiate and compare correctly" {
        val user = User(
            avatar_url = "avatar",
            bio = null,
            blog = null,
            collaborators = null,
            company = null,
            created_at = null,
            disk_usage = null,
            email = null,
            events_url = "events",
            followers = null,
            followers_url = "followers_url",
            following = null,
            following_url = "following_url",
            gists_url = "gists_url",
            gravatar_id = "gravatar",
            hireable = null,
            html_url = "html",
            id = 1,
            location = null,
            login = "login",
            name = "UserName",
            node_id = "node",
            organizations_url = "orgs_url",
            owned_private_repos = null,
            plan = null,
            private_gists = null,
            public_gists = null,
            public_repos = null,
            received_events_url = "received_events_url",
            repos_url = "repos_url",
            site_admin = false,
            starred_url = "starred_url",
            subscriptions_url = "subs_url",
            total_private_repos = null,
            twitter_username = null,
            two_factor_authentication = null,
            type = "User",
            updated_at = null,
            url = "url"
        )
        val asset = ReleaseAsset(
            browser_download_url = "url",
            content_type = "type",
            created_at = "2025-05-20",
            download_count = 10,
            id = 1,
            label = "label",
            name = "asset",
            node_id = "node",
            size = 100,
            state = "uploaded",
            updated_at = "2025-05-20",
            uploader = user,
            url = "url"
        )
        asset.name shouldBe "asset"
        asset.id shouldBe 1
        asset.uploader shouldBe user
    }
})
