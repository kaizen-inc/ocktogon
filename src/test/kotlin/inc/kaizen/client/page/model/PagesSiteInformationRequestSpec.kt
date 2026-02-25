package inc.kaizen.client.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PagesSiteInformationRequestSpec : StringSpec({
    "PagesSiteInformationRequest and BuildType should instantiate and compare correctly" {
        val source = PagesSource(branch = "main", path = null)
        val req = PagesSiteInformationRequest(
            cname = "cname.example.com",
            https_enforced = true,
            build_type = BuildType.WORKFLOW,
            source = source
        )
        req.cname shouldBe "cname.example.com"
        req.https_enforced shouldBe true
        req.build_type shouldBe BuildType.WORKFLOW
        req.source shouldBe source
    }
})
