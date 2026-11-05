package com.example.a02_to_do_list_app.reminder

data class IncompleteTaskNotification(
    val count: Int,
    val collapsedNames: String,
    val expandedNames: String,
)

fun incompleteTaskNotification(titles: List<String>): IncompleteTaskNotification? {
    val names = titles.map { it.trim() }.filter { it.isNotEmpty() }
    if (names.isEmpty()) return null
    return IncompleteTaskNotification(
        count = names.size,
        collapsedNames = names.joinToString(separator = ", "),
        expandedNames = names.joinToString(separator = "\n"),
    )
}
