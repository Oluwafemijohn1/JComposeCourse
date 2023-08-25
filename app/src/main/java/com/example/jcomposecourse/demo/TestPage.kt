/*
 * Copyright (c) 2023 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.jcomposecourse.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.jcomposecourse.R

@Preview
@Composable
fun RowDemo() {
  Row(
      modifier = Modifier
          .fillMaxSize()
          .background(Color.LightGray),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceEvenly) {

    Text(
        text = "Item 1",
        modifier = Modifier
            .background(Color.Green)
            .padding(16.dp)
    )

    Text(
        text = "Item 2",
        modifier = Modifier
            .background(Color.Blue)
            .padding(16.dp)
            .align(Alignment.Bottom)
    )
    Text(
        text = "Item 3",
        modifier = Modifier
            .background(Color.Red)
            .padding(16.dp)
    )

  }
}

@Preview
@Composable
fun RowDemoWithSpacerAndWeight() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly) {

        Text(
            text = "Item 1",
            modifier = Modifier
                .background(Color.Green)
                .padding(16.dp)
                .weight(2f)
        )

        Spacer(
            modifier = Modifier
                .background(Color.Transparent)
                .weight(1f)
        )

        Text(
            text = "Item 2",
            modifier = Modifier
                .background(Color.Blue)
                .padding(16.dp)
//            .align(Alignment.Bottom)
        )
        Text(
            text = "Item 3",
            modifier = Modifier
                .background(Color.Red)
                .padding(16.dp)
        )

    }
}

@Preview
@Composable
fun ColumnDemo() {
  Column(
      modifier = Modifier
          .fillMaxSize()
          .background(Color.LightGray),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
  ) {
    Text(
        text = "Item 1",
        modifier = Modifier
            .background(Color.Green)
            .padding(16.dp)
    )
    Text(
        text = "Item 2",
        modifier = Modifier
            .background(Color.Blue)
            .padding(16.dp)
            .align(Alignment.End)
    )
    Text(
        text = "Item 3",
        modifier = Modifier
            .background(Color.Red)
            .padding(16.dp)
    )
  }
}


@Preview
@ExperimentalMaterial3Api
@Composable
fun TextFieldDemo() {

    TextField(
        value = "",
        onValueChange = {},
        placeholder = {
            Text(text = "Enter your name")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )

}

@Preview
@Composable
fun ImageUsage() {
    Image(
        painter = painterResource(id = R.drawable.food_ramen),
        contentDescription = stringResource(id = R.string.ramen),
        modifier = Modifier.size(200.dp),
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.tint(
            color = Color.Red,
//            blendMode = BlendMode.Hue
        )
    )
}


@Composable
fun LoadImageFromUrl(){
    Image(
        // on below line we are adding the image url
        // from which we will  be loading our image.
        painter = rememberAsyncImagePainter("https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png"),

        // on below line we are adding content
        // description for our image.
        contentDescription = "gfg image",

        // on below line we are adding modifier for our
        // image as wrap content for height and width.
        modifier = Modifier
            .wrapContentSize()
            .wrapContentHeight()
            .wrapContentWidth()
    )
}



@Composable
fun LabelCheckBox(
    modifier: Modifier = Modifier,
    label: String? = null,
    checked: Boolean = false,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            modifier = Modifier,
            text = label?:""
        )
    }
}

@Preview
@Composable
fun CheckBoxAndRadioButtonDemo(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LabelCheckBox(
            label = "Label 1",
            checked = true,
            onCheckedChange = { /*TODO*/ }
        )
        LabelCheckBox(
            label = "Label 2",
            checked = false,
            enabled = false,
            onCheckedChange = { /*TODO*/ }
        )

        RadioButton(
            selected = true,
            onClick = { /*TODO*/ },
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue
            )
        )

        RadioButton(selected = false, onClick = { /*TODO*/ })
    }
}









