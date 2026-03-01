package inc.kaizen.client.ocktogon.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PagesBuildSpec : StringSpec({
    "PagesBuild should instantiate and compare correctly" {
        val error = PagesBuildError(message = "error message")
        val user = null // Replace with a User mock or instance if needed
        val build = PagesBuild(
            url = "https://example.com/build",
            status = "built",
            error = error,
            pusher = user,
            commit = "commit-sha",
            created_at = "2025-05-20T12:00:00Z",
            updated_at = "2025-05-20T12:10:00Z"
        )
        build.url shouldBe "https://example.com/build"
        build.status shouldBe "built"
        build.error shouldBe error
        build.commit shouldBe "commit-sha"
        build.created_at shouldBe "2025-05-20T12:00:00Z"
        build.updated_at shouldBe "2025-05-20T12:10:00Z"
    }
})
