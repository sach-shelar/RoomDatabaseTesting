package com.sach.roomdatabasetesting.data

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.sach.roomdatabasetesting.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NoteDaoTest {

    @get:Rule
    val instanceExecutorRule = InstantTaskExecutorRule()
    private lateinit var noteDatabase: NoteDatabase
    lateinit var noteDao: NoteDao
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        noteDatabase = Room.inMemoryDatabaseBuilder(
            context,
            NoteDatabase::class.java,
        ).allowMainThreadQueries().build()

        noteDao = noteDatabase.getNoteDao()
    }

    @Test
    fun insertNote_ExpectedSingleNote() = runBlocking {

        val note = Note(
            0, "India Won the match", "Yesterday, Indian cricket team won the match against Aus"
        )
        noteDao.insertNote(note)

        val result = noteDao.getNoteList().getOrAwaitValue()

        Assert.assertEquals(1, result.size)

    }

    @Test
    fun deleteNote_ExpectedNoResult() = runBlocking{

        val note = Note(
            0, "India Won the match", "Yesterday, Indian cricket team won the match against Aus"
        )
        noteDao.insertNote(note)
        noteDao.delete()

        val result = noteDao.getNoteList().getOrAwaitValue()
        Assert.assertEquals(0, result.size)

    }


    @After
    fun tearDown() {
        noteDatabase.close()
    }
}