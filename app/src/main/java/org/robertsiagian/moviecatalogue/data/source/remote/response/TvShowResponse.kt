package org.robertsiagian.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse (
    var showsId: String,
    var showsTitle: String,
    var showsDescription: String,
    var showsPubYear: String,
    var showsImage: String
):Parcelable