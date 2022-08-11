package com.example.core.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.core.ViewModelFactory
import com.example.core.navigation.FlowCoordinator
import com.example.core.viewmodel.BaseViewModel
import dagger.Lazy
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding, C : FlowCoordinator<*>, VM : BaseViewModel<C>> :
    Fragment() {

    @Inject
    lateinit var factory: Lazy<ViewModelFactory>
    protected lateinit var viewModel: VM
    private var viewBinding: VB? = null
    protected val binding: VB
        get() = viewBinding ?: error("INIT BINDING")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDi()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = initBinding(inflater, container)

        viewModel = ViewModelProvider(viewModelStore, factory.get())[getViewModelClass()]
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()

        viewBinding = null
        clearComponent()
    }

    abstract fun clearComponent()
    abstract fun getViewModelClass(): Class<VM>
    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    abstract fun injectDi()
}