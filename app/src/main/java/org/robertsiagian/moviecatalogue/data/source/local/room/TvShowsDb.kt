package org.robertsiagian.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity

@Database(entities = [TvShowsEntity::class], version = 1, exportSchema = false)
abstract class TvShowsDb : RoomDatabase() {

    abstract val dao : TvShowsDao

    companion object {

        @Volatile
        private var INSTANCE: TvShowsDb? = null

        fun getInstance(context: Context) : TvShowsDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TvShowsDb::class.java,
                        "tvShows.db"
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