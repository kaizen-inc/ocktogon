package inc.kaizen.client.billing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PackageBillingTest : StringSpec({
    "PackageBilling should instantiate and compare correctly" {
        val billing = PackageBilling(
            totalGigabytesBandwidthUsed = 50,
            totalPaidGigabytesBandwidthUsed = 10,
            includedGigabytesBandwidth = 100
        )
        billing.totalGigabytesBandwidthUsed shouldBe 50
        billing.totalPaidGigabytesBandwidthUsed shouldBe 10
        billing.includedGigabytesBandwidth shouldBe 100
    }
})
