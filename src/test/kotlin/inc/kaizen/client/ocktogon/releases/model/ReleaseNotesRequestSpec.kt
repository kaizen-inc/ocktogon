package inc.kaizen.client.ocktogon.releases.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ReleaseNotesRequestSpec : StringSpec({
    "ReleaseNotesRequest should instantiate and compare correctly" {
        val req = ReleaseNotesRequest(
            tag_name = "v1.0",
            target_commitish = "main",
            previous_tag_name = "v0.9",
            configuration_file_path = ".github/release.yml"
        )
        req.tag_name shouldBe "v1.0"
        req.previous_tag_name shouldBe "v0.9"
        req.configuration_file_path shouldBe ".github/release.yml"
    }
})
