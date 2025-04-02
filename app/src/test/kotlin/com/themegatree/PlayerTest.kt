package com.themegatree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals

class InitTest {

    @Test
    fun playerName() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputName()
        assertEquals("Shiv", result, "Is name correctly initialized?")
    }

    @Test
    fun playerW() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputW()
        assertEquals(0, result, "Is W correctly initialized?")
    }

    @Test
    fun playerD() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputD()
        assertEquals(0, result, "Is D correctly initialized?")
    }

    @Test
    fun playerL() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputL()
        assertEquals(0, result, "Is D correctly initialized?")
    }

    @Test
    fun playerAA() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputAA()
        assertEquals(0, result, "Is AA correctly initialized?")
    }

    @Test
    fun playerBBB() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputBBB()
        assertEquals(0, result, "Is BBB correctly initialized?")
    }

    @Test
    fun playerCCC() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputCCC()
        assertEquals(0, result, "Is CCC correctly initialized?")
    }

    @Test
    fun playerDDD() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputDDD()
        assertEquals(0, result, "Is DDD correctly initialized?")
    }

 /*
     @Test
    fun playerOPOP() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputOP().size
        assertEquals(0, result, "Is OP correctly initialized?")
    }

    @Test
    fun playerOPOP() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputOPOP().size
        assertEquals(0, result, "Is OPOP correctly initialized?")
    }
*/

}

