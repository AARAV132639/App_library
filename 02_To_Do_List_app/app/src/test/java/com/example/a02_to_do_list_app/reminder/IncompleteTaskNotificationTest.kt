package com.example.a02_to_do_list_app.reminder

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class IncompleteTaskNotificationTest {
    @Test
    fun emptyListProducesNoNotification() {
        assertNull(incompleteTaskNotification(emptyList()))
    }

    @Test
    fun blankTitlesProduceNoNotification() {
        assertNull(incompleteTaskNotification(listOf(" ", "")))
    }

    @Test
    fun includesCountAndEveryName() {
        val message = incompleteTaskNotification(listOf(" Buy milk ", "Walk dog"))
        assertEquals(2, message?.count)
        assertEquals("Buy milk, Walk dog", message?.collapsedNames)
        assertEquals("Buy milk\nWalk dog", message?.expandedNames)
    }
}
