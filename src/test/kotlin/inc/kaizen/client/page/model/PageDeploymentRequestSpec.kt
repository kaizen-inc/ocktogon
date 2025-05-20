package inc.kaizen.client.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PageDeploymentRequestSpec : StringSpec({
    "PageDeploymentRequest should instantiate and compare correctly" {
        val req = PageDeploymentRequest(
            artifact_id = "artifact123",
            artifact_url = "https://example.com/artifact.zip",
            environment = "github-pages",
            pages_build_version = "GITHUB_SHA",
            oidc_token = "token123"
        )
        req.artifact_id shouldBe "artifact123"
        req.artifact_url shouldBe "https://example.com/artifact.zip"
        req.environment shouldBe "github-pages"
        req.pages_build_version shouldBe "GITHUB_SHA"
        req.oidc_token shouldBe "token123"
    }
})
