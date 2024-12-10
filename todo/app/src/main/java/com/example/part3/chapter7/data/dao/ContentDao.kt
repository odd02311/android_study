package com.example.part3.chapter7.data.dao

import androidx.room.*
import com.example.part3.chapter7.model.ContentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContentDao {

    @Query("SELECT * FROM Content")
    fun selectAll() : Flow<List<ContentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // 내부적으로 insert 부분이 자동으로 생성  ORM
    suspend fun insert(item: ContentEntity)

    @Delete
    suspend fun delete(item: ContentEntity)

}