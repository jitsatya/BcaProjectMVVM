package com.example.nutritionsearchmvvm.ui.SearchResults

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.nutritionsearchmvvm.R
import com.example.nutritionsearchmvvm.data.entities.List
import com.example.nutritionsearchmvvm.ui.home.SearchViewModel
import com.example.nutritionsearchmvvm.ui.home.SearchViewModelFactory
import com.example.nutritionsearchmvvm.util.Coroutines
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SearchResults : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: SearchViewModelFactory by instance()
    private lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)
        viewModel = ViewModelProviders.of(this, factory).get(SearchViewModel::class.java)
        val list:List = intent.getSerializableExtra("list") as List



    }

}
