package inc.kaizen.client.ocktogon.releases.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ReleaseAssetRequestSpec : StringSpec({
    "ReleaseAssetRequest should instantiate and compare correctly" {
        val req = ReleaseAssetRequest(
            name = "asset",
            label = "label",
            state = "uploaded"
        )
        req.name shouldBe "asset"
        req.label shouldBe "label"
        req.state shouldBe "uploaded"
    }
})
