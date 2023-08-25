package com.example.jcomposecourse.demo

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jcomposecourse.data.getCategories
import com.example.jcomposecourse.data.getFood
import com.example.jcomposecourse.ui.component.FoodCategoryItem
import com.example.jcomposecourse.ui.component.FoodItemWithFloatingButton


@Preview
@Composable
fun LazyColumnDemo() {
    LazyColumn(modifier = Modifier
        .fillMaxHeight()){

        items(
            getFood(),
            key = { item -> item.name },
        ) { item ->
            FoodItemWithFloatingButton(food = item)
        }
    }
}

@Preview
@Composable
fun LazyRowDemo() {
    LazyRow(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
    ) {
        items(getCategories()) { item ->
            FoodCategoryItem(icon = item.image, category = item.name)
        }
    }
}