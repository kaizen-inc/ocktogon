package inc.kaizen.client.billing.model

data class BillingReport(
    val usageItems: List<UsageItem>
)

data class UsageItem(
    val date: String,
    val product: String,
    val sku: String,
    val quantity: Int,
    val unitType: String,
    val pricePerUnit: Double,
    val grossAmount: Double,
    val discountAmount: Double,
    val netAmount: Double,
    val repositoryName: String
)
