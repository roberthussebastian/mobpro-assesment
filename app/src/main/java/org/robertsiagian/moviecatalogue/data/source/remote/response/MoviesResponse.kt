package org.robertsiagian.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesResponse (
    var moviesId: String,
    var titles: String,
    var description: String,
    var pubYear: String,
    var imagePath: String
):Parcelable