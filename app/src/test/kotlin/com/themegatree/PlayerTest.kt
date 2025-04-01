package com.themegatree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals

class InitTest {

    @Test
    fun playerName() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputName()
        assertEquals("Shiv", result, "Am I Shiv?")
    }
}
