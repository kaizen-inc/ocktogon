package inc.kaizen.client.ocktogon.activity.model

data class Event(
    val id: String? = null,
    val type: String? = null,
    val actor: EventActor? = null,
    val repo: EventRepo? = null,
    val org: EventActor? = null,
    val payload: Any? = null,
    val public: Boolean? = null,
    val created_at: String? = null
)

data class EventActor(
    val id: Int? = null,
    val login: String? = null,
    val display_login: String? = null,
    val gravatar_id: String? = null,
    val url: String? = null,
    val avatar_url: String? = null
)

data class EventRepo(
    val id: Int? = null,
    val name: String? = null,
    val url: String? = null
)

