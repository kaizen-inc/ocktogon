package inc.kaizen.client.ocktogon.billing.model

data class StorageBilling(
    val daysLeftInBillingCycle: Int,
    val estimatedPaidStorageForMonth: Int,
    val estimatedStorageForMonth: Int
)