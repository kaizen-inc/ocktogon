package inc.kaizen.client.ocktogon

import inc.kaizen.client.ocktogon.billing.api.BillingApi
import kotlin.jvm.java

fun main(args: Array<String>): Unit = kotlinx.coroutines.runBlocking {
    val service = Ocktogon.createService(
        serviceClass = BillingApi::class.java,
        interceptor = null
    )
    println(service.getOrgActionsBilling("octocat"))
}