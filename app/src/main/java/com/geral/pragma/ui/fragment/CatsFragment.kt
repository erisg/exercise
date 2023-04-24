package com.geral.pragma.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.geral.pragma.databinding.CatsFragmentBinding
import com.geral.pragma.ui.fragment.compose.CatsScreen
import com.geral.pragma.ui.fragment.compose.PragmaTheme
import com.geral.pragma.ui.util.observeFlows
import com.geral.pragma.ui.util.setCustomContent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatsFragment : Fragment() {
    private val binding: CatsFragmentBinding by lazy {
        CatsFragmentBinding.inflate(layoutInflater)
    }

    private val viewModel: CatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCats()
        setupCollectors()

    }

    private fun setupCollectors() {
        observeFlows { coroutineScope ->
            coroutineScope.launch {
                viewModel.catsState.collect { state ->
                    when (state) {
                        CatsState.Loading -> {
                            Toast.makeText(requireContext(),"cargando",Toast.LENGTH_LONG).show()
                        }
                        is CatsState.CatsSuccess -> {
                            binding.ComposeCats.setCustomContent {
                                PragmaTheme {
                                    CatsScreen(cats = state.cats)
                                }
                            }
                        }
                        is CatsState.CatsError -> {
                            Toast.makeText(requireContext(),"error",Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}
