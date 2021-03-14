package app.nocamelstyle.birthdatelist.utils

import androidx.room.*
import app.nocamelstyle.birthdatelist.models.Event

@Dao
interface RoomDao {
    @Query("SELECT * FROM events")
    fun getAll(): List<Event>

    @Insert
    fun insert(event: Event)

    @Update
    fun update(event: Event)

    @Delete
    fun delete(event: Event)
}