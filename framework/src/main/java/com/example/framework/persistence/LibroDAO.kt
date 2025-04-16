package com.example.framework.persistence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.Libro

@Dao
interface LibroDAO {
    @Query("SELECT * FROM libro WHERE title=:title ORDER BY first_publish_year DESC")
    fun getLibros(title:String): List<Libro>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(gitAccount: Libro)

    @Query("DELETE FROM Libro")
    suspend fun deleteAll()

}