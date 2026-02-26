package inc.kaizen.client.activity.model

import inc.kaizen.client.common.Repository

data class Notification(
    val id: String? = null,
    val repository: Repository? = null,
    val subject: NotificationSubject? = null,
    val reason: String? = null,
    val unread: Boolean? = null,
    val updated_at: String? = null,
    val last_read_at: String? = null,
    val url: String? = null,
    val subscription_url: String? = null
)

data class NotificationSubject(
    val title: String? = null,
    val url: String? = null,
    val latest_comment_url: String? = null,
    val type: String? = null
)

data class ThreadSubscription(
    val subscribed: Boolean? = null,
    val ignored: Boolean? = null,
    val reason: String? = null,
    val created_at: String? = null,
    val url: String? = null,
    val thread_url: String? = null,
    val repository_url: String? = null
)

data class MarkNotificationsRequest(
    val last_read_at: String? = null,
    val read: Boolean? = null
)

data class ThreadSubscriptionRequest(
    val subscribed: Boolean? = null,
    val ignored: Boolean? = null
)

