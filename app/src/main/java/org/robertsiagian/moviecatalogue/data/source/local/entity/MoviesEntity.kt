package org.robertsiagian.moviecatalogue.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MoviesEntity (
    @PrimaryKey(autoGenerate = true)
    var moviesId: String,
    var titles: String,
    var description: String,
    var pubYear: String,
    var imagePath: String,
)