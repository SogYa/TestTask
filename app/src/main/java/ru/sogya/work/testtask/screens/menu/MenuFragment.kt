package ru.sogya.work.testtask.screens.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.sogya.work.testtask.R
import ru.sogya.work.testtask.databinding.FragmentMenuBinding
import ru.sogya.work.testtask.screens.menu.adapters.CategoryAdapter
import ru.sogya.work.testtask.screens.menu.adapters.HintsAdapter
import ru.sogya.work.testtask.screens.menu.adapters.MenuAdapter
@AndroidEntryPoint
class MenuFragment : Fragment(R.layout.fragment_menu) {
    private val vm: MenuVM by viewModels()
    private lateinit var binding: FragmentMenuBinding
    private val categoryAdapter = CategoryAdapter()
    private val menuAdapter = MenuAdapter()
    private val hintAdapter = HintsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        vm.getCategoryLiveData().observe(viewLifecycleOwner){
           categoryAdapter.updateCategoryList(it)
        }
        vm.getMenuLiveData().observe(viewLifecycleOwner){
            menuAdapter.updateMenuList(it)
            binding.loadingLayout.visibility = View.GONE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            menuRecyclerView.adapter = menuAdapter
            menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            hintRecyclerView.adapter = hintAdapter
            hintRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            categoryRecyclerView.adapter = categoryAdapter
            categoryRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}