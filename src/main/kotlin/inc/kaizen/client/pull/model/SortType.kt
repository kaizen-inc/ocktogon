package inc.kaizen.client.pull.model

enum class SortType(private val value: String) {

    created("created"),
    updated("updated"),
    popularity("popularity"),
    long_running("long-running");

    override fun toString() = value
}
