package inc.kaizen.client.billing.model

data class PackageBilling(
    val totalGigabytesBandwidthUsed: Int,
    val totalPaidGigabytesBandwidthUsed: Int,
    val includedGigabytesBandwidth: Int
)