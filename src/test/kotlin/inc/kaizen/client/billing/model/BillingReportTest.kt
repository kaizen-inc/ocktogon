package inc.kaizen.client.billing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BillingReportTest : StringSpec({
    "BillingReport and UsageItem should instantiate and compare correctly" {
        val item = UsageItem(
            date = "2025-05-19",
            product = "actions",
            sku = "sku123",
            quantity = 5,
            unitType = "minutes",
            pricePerUnit = 0.5,
            grossAmount = 2.5,
            discountAmount = 0.5,
            netAmount = 2.0,
            repositoryName = "kaizen/ocktogon"
        )
        val report = BillingReport(usageItems = listOf(item))
        report.usageItems.size shouldBe 1
        report.usageItems[0] shouldBe item
    }
})
