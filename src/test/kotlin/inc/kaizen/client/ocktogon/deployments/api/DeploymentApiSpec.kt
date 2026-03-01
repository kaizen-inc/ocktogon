package inc.kaizen.client.ocktogon.deployments.api

import inc.kaizen.client.ocktogon.deployments.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class DeploymentApiSpec : FunSpec({
    val deployApi = mockk<DeploymentApi>()
    val envApi = mockk<EnvironmentApi>()
    val owner = "owner"; val repo = "repo"; val envName = "production"
    val deploymentId = 1L; val statusId = 1L; val policyId = 1L; val ruleId = 1L
    val deployment = mockk<Deployment>()
    val deploymentStatus = mockk<DeploymentStatus>()
    val environment = mockk<Environment>()
    val envResponse = EnvironmentsResponse(total_count = 1, environments = listOf(environment))
    val branchPolicy = mockk<DeploymentBranchPolicy>()
    val branchPoliciesResponse = DeploymentBranchPoliciesResponse(total_count = 1, branch_policies = listOf(branchPolicy))
    val protectionRule = mockk<DeploymentProtectionRule>()
    val createDeployReq = CreateDeploymentRequest(ref = "main")
    val createStatusReq = CreateDeploymentStatusRequest(state = "success")
    val createEnvReq = CreateEnvironmentRequest(wait_timer = 30)
    val createPolicyReq = CreateDeploymentBranchPolicyRequest(name = "main")
    val createProtectionReq = CreateDeploymentProtectionRuleRequest(integration_id = 1)

    test("listDeployments returns deployments") {
        coEvery { deployApi.listDeployments(owner, repo, any(), any(), any(), any(), any(), any()) } returns listOf(deployment)
        runBlocking { deployApi.listDeployments(owner, repo) shouldBe listOf(deployment) }
    }
    test("createDeployment returns deployment") {
        coEvery { deployApi.createDeployment(owner, repo, createDeployReq) } returns deployment
        runBlocking { deployApi.createDeployment(owner, repo, createDeployReq) shouldBe deployment }
    }
    test("getDeployment returns deployment") {
        coEvery { deployApi.getDeployment(owner, repo, deploymentId) } returns deployment
        runBlocking { deployApi.getDeployment(owner, repo, deploymentId) shouldBe deployment }
    }
    test("deleteDeployment returns response") {
        coEvery { deployApi.deleteDeployment(owner, repo, deploymentId) } returns Response.success(Unit)
        runBlocking { deployApi.deleteDeployment(owner, repo, deploymentId).isSuccessful shouldBe true }
    }
    test("listDeploymentStatuses returns statuses") {
        coEvery { deployApi.listDeploymentStatuses(owner, repo, deploymentId, any(), any()) } returns listOf(deploymentStatus)
        runBlocking { deployApi.listDeploymentStatuses(owner, repo, deploymentId) shouldBe listOf(deploymentStatus) }
    }
    test("createDeploymentStatus returns status") {
        coEvery { deployApi.createDeploymentStatus(owner, repo, deploymentId, createStatusReq) } returns deploymentStatus
        runBlocking { deployApi.createDeploymentStatus(owner, repo, deploymentId, createStatusReq) shouldBe deploymentStatus }
    }
    test("getDeploymentStatus returns status") {
        coEvery { deployApi.getDeploymentStatus(owner, repo, deploymentId, statusId) } returns deploymentStatus
        runBlocking { deployApi.getDeploymentStatus(owner, repo, deploymentId, statusId) shouldBe deploymentStatus }
    }
    test("listEnvironments returns environments response") {
        coEvery { envApi.listEnvironments(owner, repo, any(), any()) } returns envResponse
        runBlocking { envApi.listEnvironments(owner, repo) shouldBe envResponse }
    }
    test("getEnvironment returns environment") {
        coEvery { envApi.getEnvironment(owner, repo, envName) } returns environment
        runBlocking { envApi.getEnvironment(owner, repo, envName) shouldBe environment }
    }
    test("createOrUpdateEnvironment returns environment") {
        coEvery { envApi.createOrUpdateEnvironment(owner, repo, envName, any()) } returns environment
        runBlocking { envApi.createOrUpdateEnvironment(owner, repo, envName) shouldBe environment }
    }
    test("deleteEnvironment returns response") {
        coEvery { envApi.deleteEnvironment(owner, repo, envName) } returns Response.success(Unit)
        runBlocking { envApi.deleteEnvironment(owner, repo, envName).isSuccessful shouldBe true }
    }
    test("listDeploymentBranchPolicies returns policies response") {
        coEvery { envApi.listDeploymentBranchPolicies(owner, repo, envName, any(), any()) } returns branchPoliciesResponse
        runBlocking { envApi.listDeploymentBranchPolicies(owner, repo, envName) shouldBe branchPoliciesResponse }
    }
    test("createDeploymentBranchPolicy returns policy") {
        coEvery { envApi.createDeploymentBranchPolicy(owner, repo, envName, createPolicyReq) } returns branchPolicy
        runBlocking { envApi.createDeploymentBranchPolicy(owner, repo, envName, createPolicyReq) shouldBe branchPolicy }
    }
    test("getDeploymentBranchPolicy returns policy") {
        coEvery { envApi.getDeploymentBranchPolicy(owner, repo, envName, policyId) } returns branchPolicy
        runBlocking { envApi.getDeploymentBranchPolicy(owner, repo, envName, policyId) shouldBe branchPolicy }
    }
    test("updateDeploymentBranchPolicy returns policy") {
        coEvery { envApi.updateDeploymentBranchPolicy(owner, repo, envName, policyId, createPolicyReq) } returns branchPolicy
        runBlocking { envApi.updateDeploymentBranchPolicy(owner, repo, envName, policyId, createPolicyReq) shouldBe branchPolicy }
    }
    test("deleteDeploymentBranchPolicy returns response") {
        coEvery { envApi.deleteDeploymentBranchPolicy(owner, repo, envName, policyId) } returns Response.success(Unit)
        runBlocking { envApi.deleteDeploymentBranchPolicy(owner, repo, envName, policyId).isSuccessful shouldBe true }
    }
    test("listDeploymentProtectionRules returns response") {
        val rulesResp = DeploymentProtectionRulesResponse(total_count = 1, custom_deployment_protection_rules = listOf(protectionRule))
        coEvery { envApi.listDeploymentProtectionRules(owner, repo, envName) } returns rulesResp
        runBlocking { envApi.listDeploymentProtectionRules(owner, repo, envName) shouldBe rulesResp }
    }
    test("createDeploymentProtectionRule returns rule") {
        coEvery { envApi.createDeploymentProtectionRule(owner, repo, envName, createProtectionReq) } returns protectionRule
        runBlocking { envApi.createDeploymentProtectionRule(owner, repo, envName, createProtectionReq) shouldBe protectionRule }
    }
    test("disableDeploymentProtectionRule returns response") {
        coEvery { envApi.disableDeploymentProtectionRule(owner, repo, envName, ruleId) } returns Response.success(Unit)
        runBlocking { envApi.disableDeploymentProtectionRule(owner, repo, envName, ruleId).isSuccessful shouldBe true }
    }
    test("getDeploymentProtectionRule returns rule") {
        coEvery { envApi.getDeploymentProtectionRule(owner, repo, envName, ruleId) } returns protectionRule
        runBlocking { envApi.getDeploymentProtectionRule(owner, repo, envName, ruleId) shouldBe protectionRule }
    }
})

