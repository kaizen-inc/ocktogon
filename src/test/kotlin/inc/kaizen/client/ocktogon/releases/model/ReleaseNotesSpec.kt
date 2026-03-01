package inc.kaizen.client.ocktogon.releases.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ReleaseNotesSpec : StringSpec({
    "ReleaseNotes should instantiate and compare correctly" {
        val notes = ReleaseNotes(
            body = "Release body",
            name = "Release name"
        )
        notes.body shouldBe "Release body"
        notes.name shouldBe "Release name"
    }
})
