package inc.kaizen.client.ocktogon.action.model.oidc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OIDCTemplateSpec : StringSpec({

    "OIDCTemplate should instantiate with default use_default false" {
        val template = OIDCTemplate(include_claim_keys = listOf("repo", "context"))
        template.use_default shouldBe false
        template.include_claim_keys shouldBe listOf("repo", "context")
    }

    "OIDCTemplate should instantiate with explicit use_default true" {
        val template = OIDCTemplate(use_default = true, include_claim_keys = emptyList())
        template.use_default shouldBe true
        template.include_claim_keys.size shouldBe 0
    }

    "OIDCTemplate equality should work correctly" {
        val t1 = OIDCTemplate(use_default = false, include_claim_keys = listOf("repo"))
        val t2 = OIDCTemplate(use_default = false, include_claim_keys = listOf("repo"))
        t1 shouldBe t2
    }
})

