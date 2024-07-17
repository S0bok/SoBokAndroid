package com.example.sobokandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GuideAdapter(
    private val guides: List<Guide>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<GuideAdapter.GuideViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(guide: Guide)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guide_recycler_view, parent, false)
        return GuideViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        val guide = guides[position]
        holder.bind(guide, itemClickListener)
    }

    override fun getItemCount(): Int {
        return guides.size
    }

    class GuideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.guide_title)
        private val detailTextView: TextView = itemView.findViewById(R.id.guide_detail)
        private val dateTextView: TextView = itemView.findViewById(R.id.guide_date)

        fun bind(guide: Guide, clickListener: OnItemClickListener) {
            titleTextView.text = guide.title
            detailTextView.text = guide.detail
            dateTextView.text = guide.date

            itemView.setOnClickListener {
                clickListener.onItemClick(guide)
            }
        }
    }
}