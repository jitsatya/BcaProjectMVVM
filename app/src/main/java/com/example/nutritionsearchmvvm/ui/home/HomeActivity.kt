package com.example.nutritionsearchmvvm.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.nutritionsearchmvvm.R
import com.example.nutritionsearchmvvm.data.entities.List
import com.example.nutritionsearchmvvm.databinding.ActivityHomeBinding
import com.example.nutritionsearchmvvm.ui.SearchResults.SearchResults
import com.example.nutritionsearchmvvm.util.hide
import com.example.nutritionsearchmvvm.util.show
import com.example.nutritionsearchmvvm.util.toast
import kotlinx.android.synthetic.main.activity_home.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity(), SearchListener, KodeinAware {

    override val kodein by kodein()

    private val factory : SearchViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val viewModel = ViewModelProviders.of(this, factory).get(SearchViewModel::class.java)
        binding.viewmodel  = viewModel

        viewModel.searchListener = this


    }
    override fun onStarted() {
        progressBar.show()
    }

    override fun onSuccess(list: List) {
        progressBar.hide()
        startActivity(Intent(this, SearchResults::class.java))
        toast("${list.item?.get(0)?.name} is the first item in the list")
    }

    override fun onFailure(message: String) {
        progressBar.hide()
            toast(message)
    }
}
