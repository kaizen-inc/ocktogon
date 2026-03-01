package inc.kaizen.client.ocktogon.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PagesSiteRequestSpec : StringSpec({
    "PagesSiteRequest should instantiate and compare correctly" {
        val source = PagesSource(branch = "main", path = "/docs")
        val req = PagesSiteRequest(source = source)
        req.source shouldBe source
    }
})
