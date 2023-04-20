package com.newsapp.feature_news.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.newsapp.R
import com.newsapp.core.util.Constants.Companion.selectedItem
import com.newsapp.core.util.loadPicture
import com.newsapp.feature_news.presentation.viewmodels.NewsViewModel
import com.newsapp.ui.theme.newsBlacklight
import com.newsapp.ui.theme.newsDarkWhiteColor
import com.newsapp.ui.theme.newsGold


@Composable
fun NewsDetailsScreen(navController: NavController) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val viewModel: NewsViewModel = hiltViewModel()


    Scaffold(
        backgroundColor = Color.Transparent,
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize(),
        snackbarHost = { scaffoldState.snackbarHostState }
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .border(
                            width = 1.dp,
                            color = newsGold,
                            shape = RoundedCornerShape(15.dp)
                        ),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 5.dp
                ) {


                    Column(  modifier = Modifier.background(color= newsBlacklight)) {


                        Row(modifier= Modifier
                            .fillMaxWidth()
                            .weight(3f)) {

                            Column(Modifier.fillMaxSize() ) {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight() ,verticalAlignment = Alignment.Top) {
                                    Box(modifier = Modifier.fillMaxSize()){
                                        val image = loadPicture(url = "someUrl", defaultImage = R.drawable.placeholder).value
                                        image?.let{
                                            Image(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                ,
                                                bitmap = it.asImageBitmap(),
                                                contentDescription = "",
                                                contentScale = ContentScale.FillBounds
                                            )
                                        }
                                        Box(modifier = Modifier
                                            .fillMaxSize()
                                            .background(
                                                Brush.verticalGradient(
                                                    colors = listOf(
                                                        Color.Transparent,
                                                        newsBlacklight
                                                    )
                                                )
                                            )){

                                        }
                                        Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize().padding(10.dp)) {
                                            Text(""+ (selectedItem?.title ?: ""), style = TextStyle(color = newsGold, fontSize = 16.sp ))
                                            Text(""+(selectedItem?.description ?: ""), style = TextStyle(color = newsDarkWhiteColor, fontSize = 14.sp ))
                                            Text(""+(selectedItem?.content ?: ""), style = TextStyle(color = newsDarkWhiteColor, fontSize = 16.sp ))
                                            Row(horizontalArrangement = Arrangement.End ,modifier = Modifier.fillMaxWidth()) {
                                                Text(""+(selectedItem?.url ?: ""), style = TextStyle(color = newsGold, fontSize = 16.sp ))
                                            }
                                        }
                                    }
                                }
                            }



                        }


                        Divider(color = newsGold, thickness = 1.dp)
                        Row(modifier= Modifier
                            .fillMaxWidth()
                            .weight(7f) ,) {


                        }


                    }


                }
            }
        }

    }


}


