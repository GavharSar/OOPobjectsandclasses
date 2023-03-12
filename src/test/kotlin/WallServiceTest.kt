package ru.netology

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
        val post1 = Post(5, 6, "Anna", "Netology", 12_12_21, 8)
        val post2 = Post(49, 55, "Gyliya", "I am student", 23_05_12, 66)
        WallService.add(post1)
        WallService.add(post2)
        val update = Post(49, 55, "Gyliya", "I am student", 23_05_12, 100, true)
        val result = WallService.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val post1 = Post(5, 6, "Anna", "Netology", 12_12_21, 8)
        val post2 = Post(49, 55, "Gyliya", "I am student", 23_05_12, 66)
        WallService.add(post1)
        WallService.add(post2)
        val update = Post(58, 55, "Gyliya", "I am student", 23_05_12, 100, true)
        val result = WallService.update(update)
        assertFalse(result)
    }

    @Test
    fun addNotZero() {
        val post = Post(3,5,"Petya", "Text", 12_05_19, 9)
        WallService.add(post)
        val result = post.id
        assertEquals(3, result)
    }
}