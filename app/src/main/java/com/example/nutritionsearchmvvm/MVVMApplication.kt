package com.example.nutritionsearchmvvm

import android.app.Application
import com.example.nutritionsearchmvvm.data.network.MyApi
import com.example.nutritionsearchmvvm.data.network.NetworkConnectionInterceptor
import com.example.nutritionsearchmvvm.data.repositories.SearchRepository
import com.example.nutritionsearchmvvm.ui.home.SearchViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }

        bind() from singleton { MyApi(instance()) }

        bind() from singleton { SearchRepository(instance()) }

        bind() from provider { SearchViewModelFactory(instance()) }

    }
}