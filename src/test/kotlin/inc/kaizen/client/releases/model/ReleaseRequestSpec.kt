package inc.kaizen.client.releases.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ReleaseRequestSpec : StringSpec({
    "ReleaseRequest should instantiate and compare correctly" {
        val req = ReleaseRequest(
            tag_name = "v1.0",
            target_commitish = "main",
            name = "ReleaseName",
            body = "body",
            draft = true,
            prerelease = false,
            discussion_category_name = "category",
            generate_release_notes = true,
            make_latest = MakeLatest.TRUE
        )
        req.tag_name shouldBe "v1.0"
        req.draft shouldBe true
        req.make_latest shouldBe MakeLatest.TRUE
    }
})
