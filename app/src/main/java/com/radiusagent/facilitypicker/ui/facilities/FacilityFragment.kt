package com.radiusagent.facilitypicker.ui.facilities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.radiusagent.facilitypicker.data.local.models.Facility
import com.radiusagent.facilitypicker.databinding.FragmentFacilityBinding
import com.radiusagent.facilitypicker.ui.adapters.FacilityAdapter

class FacilityFragment : Fragment(), FacilityContract.View {

    private lateinit var binding: FragmentFacilityBinding
    private lateinit var presenter: FacilityContract.Presenter
    private lateinit var facilityAdapter: FacilityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFacilityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = FacilityPresenter(this)
        facilityAdapter = FacilityAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = facilityAdapter
        }

        presenter.fetchFacilities()
    }

    override fun showFacilities(facilities: List<Facility>) {
        facilityAdapter.setFacilities(facilities)
    }


}
