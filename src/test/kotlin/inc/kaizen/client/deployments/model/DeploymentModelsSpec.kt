package inc.kaizen.client.deployments.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DeploymentModelsSpec : StringSpec({

    "Deployment should instantiate and compare correctly" {
        val deployment = Deployment(id = 1L, sha = "abc123", ref = "main", task = "deploy", environment = "production")
        deployment.id shouldBe 1L
        deployment.environment shouldBe "production"
    }

    "DeploymentStatus should instantiate and compare correctly" {
        val status = DeploymentStatus(id = 1L, state = "success", environment = "production")
        status.id shouldBe 1L
        status.state shouldBe "success"
    }

    "DeploymentBranchPolicySettings should instantiate and compare correctly" {
        val settings = DeploymentBranchPolicySettings(protected_branches = true, custom_branch_policies = false)
        settings.protected_branches shouldBe true
        settings.custom_branch_policies shouldBe false
    }

    "Environment should instantiate and compare correctly" {
        val env = Environment(id = 1, name = "production", url = "url", html_url = "html_url", can_admins_bypass = true)
        env.id shouldBe 1
        env.name shouldBe "production"
    }

    "EnvironmentsResponse should instantiate and compare correctly" {
        val env = Environment(id = 1, name = "production")
        val resp = EnvironmentsResponse(total_count = 1, environments = listOf(env))
        resp.total_count shouldBe 1
        resp.environments?.size shouldBe 1
    }

    "DeploymentBranchPolicy should instantiate and compare correctly" {
        val policy = DeploymentBranchPolicy(id = 1L, name = "main", type = "branch_policy")
        policy.id shouldBe 1L
        policy.name shouldBe "main"
    }

    "DeploymentBranchPoliciesResponse should instantiate and compare correctly" {
        val policy = DeploymentBranchPolicy(id = 1L, name = "main")
        val resp = DeploymentBranchPoliciesResponse(total_count = 1, branch_policies = listOf(policy))
        resp.total_count shouldBe 1
    }

    "DeploymentProtectionRule should instantiate and compare correctly" {
        val rule = DeploymentProtectionRule(id = 1L, node_id = "node", type = "required_reviewers")
        rule.id shouldBe 1L
        rule.type shouldBe "required_reviewers"
    }

    "DeploymentProtectionRulesResponse should instantiate and compare correctly" {
        val rule = DeploymentProtectionRule(id = 1L, type = "required_reviewers")
        val resp = DeploymentProtectionRulesResponse(total_count = 1, custom_deployment_protection_rules = listOf(rule))
        resp.total_count shouldBe 1
    }

    "CreateDeploymentRequest should instantiate and compare correctly" {
        val req = CreateDeploymentRequest(ref = "main", task = "deploy", environment = "production", description = "Deploy to prod")
        req.ref shouldBe "main"
        req.environment shouldBe "production"
    }

    "CreateDeploymentStatusRequest should instantiate and compare correctly" {
        val req = CreateDeploymentStatusRequest(state = "success", environment = "production")
        req.state shouldBe "success"
        req.environment shouldBe "production"
    }

    "EnvironmentReviewer should instantiate and compare correctly" {
        val reviewer = EnvironmentReviewer(type = "User", id = 1)
        reviewer.type shouldBe "User"
        reviewer.id shouldBe 1
    }

    "CreateEnvironmentRequest should instantiate and compare correctly" {
        val req = CreateEnvironmentRequest(wait_timer = 30, can_admins_bypass = true)
        req.wait_timer shouldBe 30
        req.can_admins_bypass shouldBe true
    }

    "CreateDeploymentBranchPolicyRequest should instantiate and compare correctly" {
        val req = CreateDeploymentBranchPolicyRequest(name = "main", type = "branch")
        req.name shouldBe "main"
        req.type shouldBe "branch"
    }

    "CreateDeploymentProtectionRuleRequest should instantiate and compare correctly" {
        val req = CreateDeploymentProtectionRuleRequest(integration_id = 1)
        req.integration_id shouldBe 1
    }

    "CustomDeploymentRuleIntegrationsResponse should instantiate and compare correctly" {
        val resp = CustomDeploymentRuleIntegrationsResponse(total_count = 0, available_custom_deployment_protection_rule_integrations = listOf())
        resp.total_count shouldBe 0
    }
})

