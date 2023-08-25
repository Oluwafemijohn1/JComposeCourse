package com.example.jcomposecourse.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jcomposecourse.data.getFood
import com.example.jcomposecourse.ui.component.FoodItemWithFloatingButton

@Preview
@Composable
fun LazyVerticalGridFixedDemo() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(getFood().size, key = { i -> i }){ index ->
            FoodItemWithFloatingButton(food = getFood()[index])
        }
    }
}

@Preview
@Composable
fun LazyVerticalGridAdaptiveDemo() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(getFood().size, key = { i -> i }){ index ->
            FoodItemWithFloatingButton(food = getFood()[index])
        }
    }
}