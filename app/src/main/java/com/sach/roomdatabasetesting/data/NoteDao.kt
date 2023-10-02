package com.sach.roomdatabasetesting.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("DELETE FROM tbl_note")
    suspend fun delete()

    @Query("SELECT * FROM tbl_note")
    fun getNoteList(): LiveData<List<Note>>

    @Query("SELECT * FROM tbl_note where id=:id")
    suspend fun getNoteById(id: Int): Note

}