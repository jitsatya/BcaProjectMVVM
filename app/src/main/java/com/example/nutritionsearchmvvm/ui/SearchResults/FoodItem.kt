package com.example.nutritionsearchmvvm.ui.SearchResults

import com.example.nutritionsearchmvvm.R
import com.example.nutritionsearchmvvm.data.entities.List
import com.example.nutritionsearchmvvm.databinding.ItemFoodBinding
import com.xwray.groupie.databinding.BindableItem

class FoodItem(
    private val item: List
) : BindableItem<ItemFoodBinding>(){
    override fun getLayout() = R.layout.item_food

    override fun bind(viewBinding: ItemFoodBinding, position: Int) {
        viewBinding.setItem(item)
    }

}