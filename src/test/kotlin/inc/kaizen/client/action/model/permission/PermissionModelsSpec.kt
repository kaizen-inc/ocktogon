package inc.kaizen.client.action.model.permission

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PermissionModelsSpec : StringSpec({

    "AllowedAction enum should have correct values" {
        AllowedAction.values().size shouldBe 3
        AllowedAction.all.name shouldBe "all"
        AllowedAction.local_only.name shouldBe "local_only"
        AllowedAction.selected.name shouldBe "selected"
    }

    "EnabledRepositories enum should have correct values" {
        EnabledRepositories.values().size shouldBe 3
        EnabledRepositories.all.name shouldBe "all"
        EnabledRepositories.none.name shouldBe "none"
        EnabledRepositories.selected.name shouldBe "selected"
    }

    "WorkflowPermission enum should have correct values" {
        WorkflowPermission.values().size shouldBe 2
        WorkflowPermission.read.name shouldBe "read"
        WorkflowPermission.write.name shouldBe "write"
    }

    "AccessLevel should instantiate and compare correctly" {
        val accessLevel = AccessLevel(access_level = "organization")
        accessLevel.access_level shouldBe "organization"
    }

    "ActionPermission should instantiate with optional selected_actions_url" {
        val perm = ActionPermission(
            allowed_actions = AllowedAction.selected,
            enabled = true,
            selected_actions_url = "https://api.github.com/repos/owner/repo/actions/permissions/selected-actions"
        )
        perm.allowed_actions shouldBe AllowedAction.selected
        perm.enabled shouldBe true
        perm.selected_actions_url shouldBe "https://api.github.com/repos/owner/repo/actions/permissions/selected-actions"
    }

    "ActionPermission should instantiate without optional selected_actions_url" {
        val perm = ActionPermission(allowed_actions = AllowedAction.all, enabled = true)
        perm.selected_actions_url shouldBe null
    }

    "AllowedActionsReusableWorkflows should instantiate and compare correctly" {
        val allowed = AllowedActionsReusableWorkflows(
            github_owned_allowed = true,
            patterns_allowed = listOf("owner/*"),
            verified_allowed = false
        )
        allowed.github_owned_allowed shouldBe true
        allowed.patterns_allowed shouldBe listOf("owner/*")
        allowed.verified_allowed shouldBe false
    }

    "DefaultWorkflowPermission should instantiate and compare correctly" {
        val dwp = DefaultWorkflowPermission(
            can_approve_pull_request_reviews = true,
            default_workflow_permissions = WorkflowPermission.write
        )
        dwp.can_approve_pull_request_reviews shouldBe true
        dwp.default_workflow_permissions shouldBe WorkflowPermission.write
    }

    "Permission should instantiate and compare correctly" {
        val permission = Permission(
            allowed_actions = AllowedAction.all,
            enabled_repositories = EnabledRepositories.all,
            selected_actions_url = null
        )
        permission.allowed_actions shouldBe AllowedAction.all
        permission.enabled_repositories shouldBe EnabledRepositories.all
        permission.selected_actions_url shouldBe null
    }
})

