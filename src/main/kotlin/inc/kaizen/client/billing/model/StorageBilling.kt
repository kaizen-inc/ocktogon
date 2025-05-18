package inc.kaizen.client.billing.model

data class StorageBilling(
    val daysLeftInBillingCycle: Int,
    val estimatedPaidStorageForMonth: Int,
    val estimatedStorageForMonth: Int
)