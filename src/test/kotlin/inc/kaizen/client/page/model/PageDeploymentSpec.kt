package inc.kaizen.client.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PageDeploymentSpec : StringSpec({
    "PageDeployment should instantiate and compare correctly" {
        val deployment = PageDeployment(
            id = "deploy123",
            status_url = "https://example.com/status",
            page_url = "https://example.com/page"
        )
        deployment.id shouldBe "deploy123"
        deployment.status_url shouldBe "https://example.com/status"
        deployment.page_url shouldBe "https://example.com/page"
    }
})
