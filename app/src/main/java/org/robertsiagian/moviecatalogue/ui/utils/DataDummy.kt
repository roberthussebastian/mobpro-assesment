package org.robertsiagian.moviecatalogue.ui.utils

import org.robertsiagian.moviecatalogue.data.source.local.entity.MoviesEntity
import org.robertsiagian.moviecatalogue.data.source.local.entity.TvShowsEntity
import org.robertsiagian.moviecatalogue.data.source.remote.response.MoviesResponse
import org.robertsiagian.moviecatalogue.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): List<MoviesEntity> {
        val movies = ArrayList<MoviesEntity>()

        movies.add(MoviesEntity("movies1","Army of the Dead","Army of the Dead adalah sebuah film heist mayat hidup Amerika Serikat garapan Zack Snyder, dari skenario karya Snyder, Shay Hatten dan Joby Harold dan cerita karya Snyder.","14 Mei 2021","https://www.awn.com/sites/default/files/styles/original/public/image/featured/army_of_the_dead1280x720.jpg?itok=en2dwNq4"))
        movies.add(MoviesEntity("movies2","Oxygen","Oxygen adalah film thriller fiksi ilmiah berbahasa Prancis 2021 yang disutradarai dan diproduksi oleh Alexandre Aja, dari skenario oleh Christie LeBlanc. Sebagai bagian dari produksi bersama Amerika-Prancis, film ini dibintangi oleh Mélanie Laurent, Mathieu Amalric, dan Malik Zidi.","12 Mei 2021","https://movieden.net/wp-content/uploads/2021/05/oxygen.jpg"))
        movies.add(MoviesEntity("movies3","Mortal Kombat","Petarung MMA Cole Young, yang terbiasa menerima pukulan demi uang, tidak menyadari warisannya-atau mengapa Kaisar Dunia Luar Shang Tsung telah mengirim prajurit terbaiknya, Sub-Zero, seorang Cryomancer dunia lain, untuk memburu Cole.","14 April 2021","https://cinemags.co.id/wp-content/uploads/2021/03/Mortal-Kombat.jpg"))
        return movies
    }

    fun generateRemoteDummyMovies(): List<MoviesResponse> {
        val movies = ArrayList<MoviesResponse>()

        movies.add(MoviesResponse("movies1","Army of the Dead","Army of the Dead adalah sebuah film heist mayat hidup Amerika Serikat garapan Zack Snyder, dari skenario karya Snyder, Shay Hatten dan Joby Harold dan cerita karya Snyder.","14 Mei 2021","https://www.awn.com/sites/default/files/styles/original/public/image/featured/army_of_the_dead1280x720.jpg?itok=en2dwNq4"))
        movies.add(MoviesResponse("movies2","Oxygen","Oxygen adalah film thriller fiksi ilmiah berbahasa Prancis 2021 yang disutradarai dan diproduksi oleh Alexandre Aja, dari skenario oleh Christie LeBlanc. Sebagai bagian dari produksi bersama Amerika-Prancis, film ini dibintangi oleh Mélanie Laurent, Mathieu Amalric, dan Malik Zidi.","12 Mei 2021","https://movieden.net/wp-content/uploads/2021/05/oxygen.jpg"))
        movies.add(MoviesResponse("movies3","Mortal Kombat","Petarung MMA Cole Young, yang terbiasa menerima pukulan demi uang, tidak menyadari warisannya-atau mengapa Kaisar Dunia Luar Shang Tsung telah mengirim prajurit terbaiknya, Sub-Zero, seorang Cryomancer dunia lain, untuk memburu Cole.","14 April 2021","https://cinemags.co.id/wp-content/uploads/2021/03/Mortal-Kombat.jpg"))
        return movies
    }

    fun generateDummyTvShows(): List<TvShowsEntity> {
        val tvShows = ArrayList<TvShowsEntity>()

        tvShows.add(TvShowsEntity("tvShows1","Girl From Nowhere","A Girl From Nowhere adalah sebuah serial televisi misteri-fantasi Thailand yang disiarkan di Netflix dan dirilis pada tahun 2018. Serial tersebut dibintangi oleh Chicha Amatayakul yang berperan sebagai gadis misterius.","8 Agustus 2018","https://occ-0-1068-92.1.nflxso.net/dnm/api/v6/E8vDc_W8CLv7-yMQu8KMEC7Rrr8/AAAABeoAPxtHJwEirlEGxJo97ls2tHauQDug_SokzfYX_mZmt3hrwFtnG86FeiF893CNTleT0syyz53gSW17j6GxwR07-txQ.jpg?r=1e8"))
        tvShows.add(TvShowsEntity("tvShows2","Vincenzo","Vincenzo adalah seri televisi Korea Selatan tahun 2021 yang menampilkan Song Joong-ki, Jeon Yeo-been, Ok Taec-yeon, Kim Yeo-jin, Kwak Dong-yeon, dan Jo Han-cul.","20 Februari 2021","https://s.kaskus.id/images/2021/02/04/10934197_20210204123022.jpg"))
        tvShows.add(TvShowsEntity("tvShows3","Ragnarok","Ragnarok adalah serial drama fantasi berbahasa Norwegia yang terinspirasi oleh mitologi Nordik dari Netflix yang tayang perdana pada 31 Januari 2020. Ini adalah serial TV berbahasa Norwegia ketiga Netflix, setelah Home for Christmas dan Lilyhammer.","31 Januari 2020","https://www.okeguys.com/wp-content/uploads/2020/02/ragnarok-netflix-review-season-1-1-997x427.jpg"))
        return tvShows
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse> {
        val tvShows = ArrayList<TvShowResponse>()

        tvShows.add(TvShowResponse("tvShows1","Girl From Nowhere","A Girl From Nowhere adalah sebuah serial televisi misteri-fantasi Thailand yang disiarkan di Netflix dan dirilis pada tahun 2018. Serial tersebut dibintangi oleh Chicha Amatayakul yang berperan sebagai gadis misterius.","8 Agustus 2018","https://occ-0-1068-92.1.nflxso.net/dnm/api/v6/E8vDc_W8CLv7-yMQu8KMEC7Rrr8/AAAABeoAPxtHJwEirlEGxJo97ls2tHauQDug_SokzfYX_mZmt3hrwFtnG86FeiF893CNTleT0syyz53gSW17j6GxwR07-txQ.jpg?r=1e8"))
        tvShows.add(TvShowResponse("tvShows2","Vincenzo","Vincenzo adalah seri televisi Korea Selatan tahun 2021 yang menampilkan Song Joong-ki, Jeon Yeo-been, Ok Taec-yeon, Kim Yeo-jin, Kwak Dong-yeon, dan Jo Han-cul.","20 Februari 2021","https://s.kaskus.id/images/2021/02/04/10934197_20210204123022.jpg"))
        tvShows.add(TvShowResponse("tvShows3","Ragnarok","Ragnarok adalah serial drama fantasi berbahasa Norwegia yang terinspirasi oleh mitologi Nordik dari Netflix yang tayang perdana pada 31 Januari 2020. Ini adalah serial TV berbahasa Norwegia ketiga Netflix, setelah Home for Christmas dan Lilyhammer.","31 Januari 2020","https://www.okeguys.com/wp-content/uploads/2020/02/ragnarok-netflix-review-season-1-1-997x427.jpg"))
        return tvShows
    }
}