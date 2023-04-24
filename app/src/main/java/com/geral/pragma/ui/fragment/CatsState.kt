package com.geral.pragma.ui.fragment

import androidx.annotation.StringRes
import com.geral.pragma.domain.Cat

sealed class CatsState {
    object Loading : CatsState()
    data class CatsSuccess(val cats: List<Cat>) : CatsState()
    data class CatsError(@StringRes val errorMessage: Int? = null) : CatsState()
}
