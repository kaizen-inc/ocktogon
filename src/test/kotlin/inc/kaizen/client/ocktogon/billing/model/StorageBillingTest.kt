package inc.kaizen.client.ocktogon.billing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StorageBillingTest : StringSpec({
    "StorageBilling should instantiate and compare correctly" {
        val billing = StorageBilling(
            daysLeftInBillingCycle = 5,
            estimatedPaidStorageForMonth = 1000,
            estimatedStorageForMonth = 1200
        )
        billing.daysLeftInBillingCycle shouldBe 5
        billing.estimatedPaidStorageForMonth shouldBe 1000
        billing.estimatedStorageForMonth shouldBe 1200
    }
})
