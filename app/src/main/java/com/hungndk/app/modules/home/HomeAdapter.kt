package com.hungndk.app.modules.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hungndk.app.R
import kotlinx.android.synthetic.main.item_post.view.*

class HomeAdapter(private val callback: ((PostItemModel) -> Unit)) : RecyclerView.Adapter<HomeVH>() {
    var items: List<PostItemModel>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH {
        return HomeVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false),
            callback
        )
    }

    override fun getItemCount(): Int = items?.size ?: 0

    override fun onBindViewHolder(holder: HomeVH, position: Int) {
        holder.bind(items!![position])
    }

}

class HomeVH(private val view: View, private val callback: ((PostItemModel) -> Unit)) : RecyclerView.ViewHolder(view) {
    private var item: PostItemModel? = null

    init {
        view.setOnClickListener {
            item?.apply {
                callback.invoke(this)
            }
        }
    }

    fun bind(post: PostItemModel) {
        this.item = post
        view.tvTitle.text = post.getTitle()
        view.tvDesciption.text = post.getDescription()
        Glide.with(view)
            .load(post.getThumbUrl())
            .into(view.ivThumb)
    }
}