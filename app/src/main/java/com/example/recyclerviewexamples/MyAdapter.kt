package com.example.recyclerviewexamples

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: MutableList<String>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var context: Context

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)

        context = parent.context

        return MyViewHolder(view)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataList.size

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Get element from your dataset at this position and
        // replace the contents of the view with that element
        holder.textView.text = dataList[position]

        val animation = AnimationUtils.loadAnimation(context, R.anim.item_show_anim)
        holder.cardView.startAnimation(animation)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        internal val textView: TextView
        internal val cardView: CardView

        init {
            textView = view.findViewById(R.id.textView)
            cardView = view.findViewById(R.id.cardView)
        }
    }
}