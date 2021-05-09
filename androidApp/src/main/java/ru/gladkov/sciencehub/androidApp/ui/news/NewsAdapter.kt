package ru.gladkov.sciencehub.androidApp.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.gladkov.sciencehub.androidApp.databinding.INewBinding
import ru.gladkov.sciencehub.androidApp.domain.models.HubbleNew

class NewsAdapter(
    private val onItemClick: (item: HubbleNew) -> Unit,
) : ListAdapter<HubbleNew, NewsAdapter.AdapterViewHolder>(
    object : DiffUtil.ItemCallback<HubbleNew>() {
        override fun areItemsTheSame(
            oldItem: HubbleNew,
            newItem: HubbleNew
        ): Boolean {
            return oldItem.newsId == newItem.newsId
        }

        override fun areContentsTheSame(
            oldItem: HubbleNew,
            newItem: HubbleNew
        ): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            INewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(getItem(holder.adapterPosition))
    }

    inner class AdapterViewHolder(private val itemBinding: INewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: HubbleNew) {
            with(itemBinding) {
                tvNewInfo.text = item.newsName
                tvNewInfo.setOnClickListener {
                    onItemClick(item)
                }
            }
        }
    }
}
