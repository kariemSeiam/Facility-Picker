package com.radiusagent.facilitypicker.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radiusagent.facilitypicker.data.local.models.Facility
import com.radiusagent.facilitypicker.databinding.ItemFacilityBinding

class FacilityAdapter : RecyclerView.Adapter<FacilityAdapter.ViewHolder>() {

    private val facilities = mutableListOf<Facility>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFacilityBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(facilities[position])
    }

    override fun getItemCount(): Int {
        return facilities.size
    }

    fun setFacilities(facilities: List<Facility>) {
        this.facilities.clear()
        this.facilities.addAll(facilities)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemFacilityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(facility: Facility) {
            binding.facility = facility
            binding.executePendingBindings()
        }
    }
}
