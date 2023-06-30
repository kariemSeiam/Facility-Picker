package com.radiusagent.facilitypicker.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radiusagent.facilitypicker.data.local.models.Option
import com.radiusagent.facilitypicker.databinding.ItemOptionBinding

class FacilityOptionsAdapter(private val options: List<Option>) :
    RecyclerView.Adapter<FacilityOptionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOptionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(options[position])
    }

    override fun getItemCount(): Int {
        return options.size
    }

    inner class ViewHolder(private val binding: ItemOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(option: Option) {
            binding.option = option
            binding.executePendingBindings()
        }
    }
}
