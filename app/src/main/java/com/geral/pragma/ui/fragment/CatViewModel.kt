package com.geral.pragma.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geral.pragma.R
import com.geral.pragma.data.di.IoDispatcher
import com.geral.pragma.domain.common.fold
import com.geral.pragma.domain.usecase.CatsUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel@Inject constructor(
    private val catsUC: CatsUC,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _catsState: MutableStateFlow<CatsState> =
        MutableStateFlow(CatsState.Loading)

    val catsState: StateFlow<CatsState>
        get() = _catsState.asStateFlow()

    fun getCats() {
        viewModelScope.launch(dispatcher) {
            _catsState.update { CatsState.Loading }
            catsUC.getAllCats().fold(
                onSuccess = { characters ->
                    _catsState.update {
                        CatsState.CatsSuccess(cats = characters)
                    }
                },
                onError = { errorCode: Int, _: String? ->
                    _catsState.update {
                        CatsState.CatsError(errorMessage = R.string.error)
                    }
                },
                onException = { exception ->
                    _catsState.update {
                        CatsState.CatsError(errorMessage = R.string.error)
                    }
                }
            )
        }
    }
}
