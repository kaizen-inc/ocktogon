package inc.kaizen.client.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PagesBuildErrorSpec : StringSpec({
    "PagesBuildError should instantiate and compare correctly" {
        val error = PagesBuildError(message = "Some error")
        error.message shouldBe "Some error"
    }
})
