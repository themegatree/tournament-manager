package com.themegatree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals

class InitTest {

    @Test
    fun initPlayerName() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputName()
        assertEquals("Shiv", result, "Is name correctly initialized?")
    }

    @Test
    fun initPlayerW() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputW()
        assertEquals(0, result, "Is W correctly initialized?")
    }

    @Test
    fun initPlayerD() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputD()
        assertEquals(0, result, "Is D correctly initialized?")
    }

    @Test
    fun initPlayerL() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputL()
        assertEquals(0, result, "Is D correctly initialized?")
    }

    @Test
    fun initPlayerAA() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputAA()
        assertEquals(0, result, "Is AA correctly initialized?")
    }

    @Test
    fun initPlayerBBB() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputBBB()
        assertEquals(0, result, "Is BBB correctly initialized?")
    }

    @Test
    fun initPlayerCCC() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputCCC()
        assertEquals(0, result, "Is CCC correctly initialized?")
    }

    @Test
    fun initPlayerDDD() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputDDD()
        assertEquals(0, result, "Is DDD correctly initialized?")
    }

 /*
     @Test
    fun initPlayerOPOP() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputOP().size
        assertEquals(0, result, "Is OP correctly initialized?")
    }

    @Test
    fun initPlayerOPOP() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputOPOP().size
        assertEquals(0, result, "Is OPOP correctly initialized?")
    }
*/

}

class UpdateTest {

    @Test
    fun updateWName() {
        val testPlayer = Player("Shiv")
        testPlayer.updateW(1)
        val result = testPlayer.outputW()
        assertEquals(1, result, "Can W be changed?")
    }

    
    @Test
    fun updateDName() {
        val testPlayer = Player("Shiv")
        testPlayer.updateD(1)
        val result = testPlayer.outputD()
        assertEquals(1, result, "Can D be changed?")
    }

    @Test
    fun updateLName() {
        val testPlayer = Player("Shiv")
        testPlayer.updateL(1)
        val result = testPlayer.outputL()
        assertEquals(1, result, "Can L be changed?")
    }

    @Test
    fun updateAAName() {
        val testPlayer = Player("Shiv")
        testPlayer.updateAA(1)
        val result = testPlayer.outputAA()
        assertEquals(1, result, "Can AA be changed?")
    }    
    
    @Test
    fun updateBBBName() {
        val testPlayer = Player("Shiv")
        testPlayer.updateBBB(1)
        val result = testPlayer.outputBBB()
        assertEquals(1, result, "Can BBB be changed?")
    }    
    
    @Test
    fun updateCCCName() {
        val testPlayer = Player("Shiv")
        testPlayer.updateCCC(1)
        val result = testPlayer.outputCCC()
        assertEquals(1, result, "Can CCC be changed?")
    }    
    
    @Test
    fun updateDDDName() {
        val testPlayer = Player("Shiv")
        testPlayer.updateDDD(1)
        val result = testPlayer.outputDDD()
        assertEquals(1, result, "Can DDD be changed?")
    }

     /*
     @Test
    fun updatePlayerOPOP() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputOP().size
        assertEquals(0, result, "Is OP correctly initialized?")
    }

    @Test
    fun updatePlayerOPOP() {
        val testPlayer = Player("Shiv")
        val result = testPlayer.outputOPOP().size
        assertEquals(0, result, "Is OPOP correctly initialized?")
    }
*/
}
