package org.robertsiagian.moviecatalogue.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvShows")
data class TvShowsEntity (
        @PrimaryKey(autoGenerate = true)
        var showsId: String,
        var showsTitle: String,
        var showsDescription: String,
        var showsPubYear: String,
        var showsImage: String,
)