package com.example.jcomposecourse.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jcomposecourse.R



@Preview
@ExperimentalMaterial3Api
@Composable
fun SearchBarWithCard() {

    var search by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(end = 16.dp, start = 16.dp),
        shape = RoundedCornerShape(100.dp),
    ) {

        TextField(
            modifier = Modifier.fillMaxSize(),
            value = search,
            onValueChange = { search = it },
            leadingIcon = { Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = "search bar") },
            trailingIcon = { Image(painter = painterResource(id = R.drawable.ic_filter), contentDescription = "filter") },
            placeholder = {
                Text(
                    text = "Search for food ...",
                    modifier = Modifier
                        .fillMaxHeight(),
                    textAlign = TextAlign.Center,
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )
    }
}