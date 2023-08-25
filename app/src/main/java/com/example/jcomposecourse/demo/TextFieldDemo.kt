package com.example.jcomposecourse.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jcomposecourse.R


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemo2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = { },
            placeholder = {
                Text(
                    text = "Search basket ...",
                    color = Color.Black
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_basket),
                    contentDescription = "Basket",
                    tint = Color.Black
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Favorite",
                    tint = Color.Black
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color.Red,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp)
        )
    }
}