package com.example.jcomposecourse.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jcomposecourse.R


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PriceBar(
    price: Double? = 0.0,
    originalPrice: Double? = 0.0,
) {
    var qty by remember {
        mutableStateOf(1)
    }

    Box(modifier = Modifier
        .height(60.dp)
        .fillMaxWidth()){

        Row(modifier = Modifier) {

            Text(
                text = "$${ price?:originalPrice }",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary)

            if (price != null){

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "$${originalPrice}",
                    fontWeight = FontWeight.Medium,
                    textDecoration = TextDecoration.LineThrough
                )

            }
        }


        Box(
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight()
                .background(
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(35.dp)
                )
                .clip(RoundedCornerShape(35.dp))
                .align(Alignment.CenterEnd),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                FloatingActionButton(onClick = { qty = if (qty > 0) --qty else 0  },
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .size(45.dp),
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_remove),
                        contentDescription = "Add")
                }

                TextField(
                    value = "$qty",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,),
                    onValueChange = { },
                    modifier = Modifier
                        .width(45.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colorScheme.onTertiary,
                        containerColor = MaterialTheme.colorScheme.tertiary)
                )

                FloatingActionButton(onClick = { qty++ },
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .size(45.dp),
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add")

                }

            }

        }

    }

}