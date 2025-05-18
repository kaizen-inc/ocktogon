package inc.kaizen.client.billing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TokenBillingTest : StringSpec({
    "TokenBilling and MinutesUsedBreakdown should instantiate and compare correctly" {
        val breakdown = MinutesUsedBreakdown(MACOS = 10, UBUNTU = 20, WINDOWS = 30)
        val billing = TokenBilling(
            included_minutes = 100,
            minutes_used_breakdown = breakdown,
            total_minutes_used = 60,
            total_paid_minutes_used = 10
        )
        billing.included_minutes shouldBe 100
        billing.minutes_used_breakdown shouldBe breakdown
        billing.total_minutes_used shouldBe 60
        billing.total_paid_minutes_used shouldBe 10
    }
})
