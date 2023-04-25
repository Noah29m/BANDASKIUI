package com.noah.bandaskiui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noah.bandaskiui.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BandaskiUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary) {
                    HomeScreen()

                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
        ) {

            Text(text = "Hello, \n Noah", modifier = Modifier
                .padding(25.dp),
                fontSize = 20.sp,
                color = Nudeone

            )
            Row(horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),

                ){
                Image(
                    alignment = Alignment.TopEnd
                    ,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(10.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R. drawable.noah),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop

                    )



            }


        }

    }
    ChipSection(chips = listOf("Popular Meals","Salad Foods","Breakfast","Dinner Dishes","Lunch Cuisines"))

}

@Composable
    fun ChipSection(chips:List<String>){
        var selectedChipIndex by remember{
            mutableStateOf(0)
            
        }
    LazyRow(modifier = Modifier.padding(top = 80.dp)){
        items(chips.size){
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) Mustard
                        else Color.White
                    )
                    .padding(15.dp)
            
            ){
                Text(text = chips[it], color = Color.Black)
                
                
            }

        }

    }

    Text(text = "3850 Popular", color = Color.White, modifier = Modifier.padding(top = 155.dp, start = 30.dp))
    CardSection()
    }

@Composable
fun CardSection(){
    Card(

        modifier = Modifier
            .padding(top = 195.dp, start = 15.dp, end = 15.dp)
            .width(105.dp)
            .height(20.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Darkblue,
        border = BorderStroke(width = 1.5.dp,Color.White),
        elevation = 5.dp


    ) {
        Column() {
            Image(painter = painterResource(id = R.drawable.food)
                , contentDescription = "food",
                modifier = Modifier

                    .height(100.dp)
                    .fillMaxWidth(0.5f),
                contentScale = ContentScale.Crop


            )
            Text(text = "" +
                    "",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,

                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center)
        }


    }


}



