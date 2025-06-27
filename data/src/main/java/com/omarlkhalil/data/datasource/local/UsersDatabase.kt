package com.omarlkhalil.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omarlkhalil.data.dao.UsersDao
import com.omarlkhalil.domain.entity.MadarUser

@Database(entities = [MadarUser::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase(){
    abstract fun usersDao(): UsersDao
}