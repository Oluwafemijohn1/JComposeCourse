package com.example.jcomposecourse.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jcomposecourse.R
import com.example.jcomposecourse.data.Food
import com.example.jcomposecourse.data.getFood


@Preview
@Composable
fun FoodItemWithFloatingButton(
    food: Food = getFood().first(),
    id: Int = 0,
    onItemPressed: (Int) -> Unit = {}
) {

    Card(
        modifier = Modifier
            .width(200.dp)
            .clickable {
                onItemPressed(
                    getFood().indexOf(food)
                )
            }
            .padding(end = 8.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))) {

        Column(modifier = Modifier
            .padding(bottom = 5.dp)
            .fillMaxWidth()) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                painter = painterResource(id = food.banner),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth()) {

                Text(
                    modifier = Modifier,
                    text = food.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.ExtraBold)

                Row(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = "Clock",
                        colorFilter = ColorFilter.tint(
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )

                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "${food.waitTime} mins",
                        style = MaterialTheme.typography.bodySmall)

                }

                Spacer(modifier = Modifier
                    .height(2.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "$${food.originalPrice}",
                        fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        shape = CircleShape,
                        containerColor = MaterialTheme.colorScheme.tertiary) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "Add",
                            colorFilter = ColorFilter.tint(
                                color = contentColorFor(MaterialTheme.colorScheme.tertiary)))
                    }
                }
            }
        }
    }
}