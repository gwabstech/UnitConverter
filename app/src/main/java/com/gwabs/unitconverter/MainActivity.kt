package com.gwabs.unitconverter

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gwabs.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    UnitConverter(context = context)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UnitConverter(modifier: Modifier = Modifier, context: Context) {
    var unit by remember { mutableStateOf(" ") }
    var result by remember { mutableStateOf("") }

    val textStyle = TextStyle(
        color = Color(0xfffd01c2),
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 2.sp
    )
    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        // here all the ui element is going to be displayed
        Text(
            text = stringResource(R.string.unit_converter),
            style = textStyle

        )
        Spacer(modifier = modifier.height(20.dp))
        OutlinedTextField(
            value = unit,

            label = {
                Text(text = "Enter value")
            },
            onValueChange = {
                unit = it

            },
            shape = RoundedCornerShape(10.dp),
            maxLines = 1
        )
        Spacer(modifier = modifier.height(20.dp))
        Row(
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(modifier = modifier) {
                Button(
                    onClick = {

                    }
                ) {
                    Text(text = stringResource(R.string.select))
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = stringResource(R.string.arrow_don)
                    )
                    DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                        DropdownMenuItem(text = { Text(text = "Unit") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Kilometers") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })

                    }
                }
            }
            Box(modifier = modifier) {
                Button(
                    onClick = {
                        Toast.makeText(context, "CLicked", Toast.LENGTH_SHORT).show()
                        result = unit
                    }
                ) {
                    Text(text = stringResource(R.string.select))
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = stringResource(R.string.arrow_don)
                    )
                    DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                        DropdownMenuItem(text = { Text(text = "Unit") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Kilometers") }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })

                    }

                }
            }

        }
        Spacer(modifier = modifier.height(10.dp))
        Text(
            textAlign = TextAlign.Justify,
            text = "Result: $result",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

        )


    }

}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    UnitConverterTheme {
        val context = LocalContext.current
        UnitConverter(context = context)
    }
}