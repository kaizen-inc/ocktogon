package inc.kaizen.client.ocktogon.licenses.model

import inc.kaizen.client.ocktogon.common.License
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LicenseModelsSpec : StringSpec({

    "LicenseSimple should instantiate and compare correctly" {
        val license = LicenseSimple(key = "mit", name = "MIT License", spdx_id = "MIT", url = "url", node_id = "node")
        license.key shouldBe "mit"
        license.name shouldBe "MIT License"
    }

    "RepoLicenseContent should instantiate and compare correctly" {
        val license = License(key = "mit", name = "MIT License")
        val content = RepoLicenseContent(name = "LICENSE", path = "LICENSE", sha = "abc123", size = 1024, type = "file", encoding = "base64", content = "base64content", license = license)
        content.name shouldBe "LICENSE"
        content.license shouldBe license
    }
})

