package com.vmmontes.mytest.kernel.presentation

import com.vmmontes.mytest.kernel.coroutines.mainContext
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class CoroutinesPresenter<T> : CoroutineScope, Presenter<T>() {
    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + mainContext


    override fun onAttach(view: T) {
        super.onAttach(view)
        job = Job()
    }

    override fun onDetach() {
        super.onDetach()
        job.cancel()
    }
}
