package org.robertsiagian.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity

@Database(entities = [MoviesEntity::class], version = 1, exportSchema = false)
abstract class MoviesDb : RoomDatabase(){

    abstract val dao : MoviesDao

    companion object {

        @Volatile
        private var INSTANCE: MoviesDb? = null

        fun getInstance(context: Context) : MoviesDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MoviesDb::class.java,
                        "movies.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}