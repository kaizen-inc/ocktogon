package inc.kaizen.client.billing.model

data class TokenBilling(
    val included_minutes: Int,
    val minutes_used_breakdown: MinutesUsedBreakdown,
    val total_minutes_used: Int,
    val total_paid_minutes_used: Int
)

data class MinutesUsedBreakdown(
    val MACOS: Int,
    val UBUNTU: Int,
    val WINDOWS: Int
)