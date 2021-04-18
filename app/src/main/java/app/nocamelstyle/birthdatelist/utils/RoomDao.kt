package app.nocamelstyle.birthdatelist.utils

import androidx.room.*
import app.nocamelstyle.birthdatelist.models.Event

@Dao
interface RoomDao {

    @Query("SELECT * FROM events")
    fun getAll(): List<Event>

    @Query("SELECT * FROM events WHERE unixtime >= :min AND unixtime <= :max")
    fun getFromPeriod(min: Long, max: Long): List<Event>

//    @Query("SELECT * FROM events WHERE unixtime = :event.")
//    fun getDuplicate(event: Event)

    @Query("SELECT * FROM events WHERE id = :id")
    fun getById(id: Int): Event?

    @Insert
    fun insert(event: Event)

    @Update
    fun update(event: Event)

    @Delete
    fun delete(event: Event)

}