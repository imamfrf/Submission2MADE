package com.dicoding.imamf.submission2made

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //get parcelable object from intent
        val movie = intent.getParcelableExtra<MovieShow>("extra_movie_show")

        tv_title_detail.text = movie.title
        tv_release_date_detail.text = movie.releaseDate
        tv_score_value_detail.text = movie.score
        tv_top_cast_detail.text = movie.topCast
        tv_description_detail.text = movie.description

        img_poster_detail.setImageResource(movie.poster)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
