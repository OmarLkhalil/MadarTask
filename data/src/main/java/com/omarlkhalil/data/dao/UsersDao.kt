package com.omarlkhalil.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.omarlkhalil.domain.entity.MadarUser
import kotlinx.coroutines.flow.Flow


@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: MadarUser) : Long

    @Delete
    fun deleteUser(user: MadarUser) : Int

    @Query("SELECT * FROM madar_users WHERE id = :userId")
     fun getUserById(userId: Int): MadarUser


    @Query("SELECT * FROM madar_users")
     fun getAllUsers(): List<MadarUser>
}