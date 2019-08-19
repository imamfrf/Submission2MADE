package com.dicoding.imamf.submission2made


import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    //movies' attribute
    private var dataTitle: Array<String>? = null
    private var dataReleaseDate: Array<String>? = null
    private var dataScore: Array<String>? = null
    private var dataTopCast: Array<String>? = null
    private var dataDescription: Array<String>? = null
    private var dataPoster: TypedArray? = null
    private var movies: ArrayList<MovieShow>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepare()
        addItem()

        recyclerV_movie.apply {
            adapter = MovieShowAdapter(movies!!, context,
                object : MovieShowAdapter.OnItemClicked {
                override fun onItemClick(position: Int){
                    Toast.makeText(context, movies!![position].title+" Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("extra_movie_show", movies!![position])
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

    }

    private fun prepare() {

        //attribute initialization
        dataTitle = resources.getStringArray(R.array.data_title_movie)
        dataReleaseDate = resources.getStringArray(R.array.data_release_date_movie)
        dataScore = resources.getStringArray(R.array.data_score_movie)
        dataTopCast = resources.getStringArray(R.array.data_top_cast_movie)
        dataDescription = resources.getStringArray(R.array.data_description_movie)
        dataPoster = resources.obtainTypedArray(R.array.data_poster_movie)


    }

    private fun addItem() {

        //insert item to movie list
        movies = ArrayList()

        for (i in 0 until dataTitle!!.size ) {
            val movie = MovieShow(
                dataTitle!![i], dataReleaseDate!![i], dataScore!![i], dataTopCast!![i],
                dataDescription!![i], dataPoster!!.getResourceId(i, -1)
            )

            movies!!.add(movie)
        }

    }
}
