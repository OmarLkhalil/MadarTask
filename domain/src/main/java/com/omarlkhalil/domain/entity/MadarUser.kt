package com.omarlkhalil.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "madar_users")
data class MadarUser(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String? =null,
    @ColumnInfo(name = "age") val age: Int? = null,
    @ColumnInfo(name = "jobtitle") val jobtitle: String? = null,
    @ColumnInfo(name = "gender") val gender: String? = null,
)