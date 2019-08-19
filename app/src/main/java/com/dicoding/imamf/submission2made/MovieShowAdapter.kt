package com.dicoding.imamf.submission2made

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieShowAdapter(private val listItems: List<MovieShow>, private val context: Context,
                       private val mListener: OnItemClicked)
    : RecyclerView.Adapter<MovieShowAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]
        holder.tvTitle.text = item.title
        holder.tvRating.text = item.score
//        holder.tvDesc.text = item.description
        Glide.with(context).load(item.poster).into(holder.imgPoster)
        //holder.imgPoster.setImageResource(item.poster)
        holder.cardView.setOnClickListener {
            mListener.onItemClick(position)
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        // MARK: - Public Properties
        val tvTitle: TextView = itemView!!.findViewById(R.id.tv_title)
        val tvRating: TextView = itemView!!.findViewById(R.id.tv_rating)
//        val tvDesc: TextView = itemView!!.findViewById(R.id.tv_description)
        val imgPoster: ImageView = itemView!!.findViewById(R.id.img_poster)
        val cardView: CardView = itemView!!.findViewById(R.id.cardview_list)
    }

    interface OnItemClicked {
        fun onItemClick(position: Int)
    }
}