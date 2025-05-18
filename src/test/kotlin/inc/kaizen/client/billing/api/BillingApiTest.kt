package inc.kaizen.client.billing.api

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import inc.kaizen.client.billing.model.*

class BillingApiTest : StringSpec({
    "BillingApi interface methods should return expected mocked responses" {
        val api = mockk<BillingApi>()
        val tokenBilling = TokenBilling(100, MinutesUsedBreakdown(1,2,3), 10, 5)
        val packageBilling = PackageBilling(10, 2, 20)
        val storageBilling = StorageBilling(3, 100, 120)
        val billingReport = BillingReport(listOf())

        coEvery { api.getOrgActionsBilling("org") } returns Response.success(tokenBilling)
        coEvery { api.getOrgPackagesBilling("org") } returns Response.success(packageBilling)
        coEvery { api.getOrgSharedStorageBilling("org") } returns Response.success(storageBilling)
        coEvery { api.getOrganizationBillingReport("org", any(), any(), any(), any()) } returns Response.success(billingReport)

        runBlocking {
            api.getOrgActionsBilling("org").body() shouldBe tokenBilling
            api.getOrgPackagesBilling("org").body() shouldBe packageBilling
            api.getOrgSharedStorageBilling("org").body() shouldBe storageBilling
            api.getOrganizationBillingReport("org").body() shouldBe billingReport
        }
    }
})
