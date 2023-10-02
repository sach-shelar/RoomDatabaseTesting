package com.sach.roomdatabasetesting.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val description:String,
)