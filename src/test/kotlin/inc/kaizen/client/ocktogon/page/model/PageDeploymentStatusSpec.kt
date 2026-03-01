package inc.kaizen.client.ocktogon.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PageDeploymentStatusSpec : StringSpec({
    "PageDeploymentStatus and BuildStatus should instantiate and compare correctly" {
        val status = PageDeploymentStatus(status = BuildStatus.SUCCEED)
        status.status shouldBe BuildStatus.SUCCEED
    }
})
