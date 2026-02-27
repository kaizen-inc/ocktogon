package inc.kaizen.client

import inc.kaizen.client.billing.api.BillingApi

fun main(args: Array<String>): Unit = kotlinx.coroutines.runBlocking {
    val service = Ocktogon.createService(
        serviceClass = BillingApi::class.java,
        interceptor = null
    )
    println(service.getOrgActionsBilling("octocat"))
}