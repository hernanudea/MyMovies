/**
 * Curso en Video
 * https://www.youtube.com/watch?v=uonwBFewofI&t=1s
 * Continuar en 02:04:00 Navegation
 */
package dev.velasquez.mymovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.velasquez.mymovies.MediaItem.*
import dev.velasquez.mymovies.ui.theme.MyMoviesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    MediaItem()
//                    MediaList(item)
//                    MediaList()

//                    var text by rememberSaveable { mutableStateOf("") }
//                    StateSample(
//                        value = text,
//                        onValueChange = { text = it }
//                    )
                    //otr aforma de ahcer lo mismo

                    val (value, onValueChange) = rememberSaveable { mutableStateOf("") }
                    StateSample(
                        value = value,
                        onValueChange = onValueChange
                    )


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    /* estamos pasando el modifier por detento
    y pasandolo como valor del parametro por defecto.
    Debe ser el primer elemento opcional
     */
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
)
@Composable
fun GreetingPreview() {
    MyMoviesTheme {
        /******************************BOX************************************************/
//        Box(modifier = Modifier.fillMaxSize())
//        {
//            Greeting("Hernan", modifier = Modifier.align(Alignment.BottomEnd))
//            Greeting("Android", modifier = Modifier.align(Alignment.CenterStart))
//        }

        /******************************COLUMN************************************************/
//        Column (modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.SpaceAround, // no necesario al usar los weight
//            horizontalAlignment = Alignment.CenterHorizontally
//            ){
//            Greeting("Hernan",modifier = Modifier.background(Color.Blue).weight(2f).fillMaxWidth())
//            Greeting("Android",modifier = Modifier.background(Color.Magenta).weight(1f))
//            Greeting("Compose",modifier = Modifier.background(Color.Cyan).weight(5f))
//        }

        /******************************ROW************************************************/
        /* Es igual que el column, pero ubica todo de manera horizontal
            las propiedeades se llaman horizontalArrangement y verticalAlignment
         */
//        Row (modifier = Modifier.fillMaxSize(),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ){
//            Greeting("Hernan",modifier = Modifier.background(Color.Blue).weight(2f).fillMaxWidth())
//            Greeting("Android",modifier = Modifier.background(Color.Magenta).weight(1f))
//            Greeting("Compose",modifier = Modifier.background(Color.Cyan).weight(5f))
//        }
    }
//    MediaItem()
//    ButtonText()
}

//@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun ButtonText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello Hernan",
            modifier = Modifier
                .clickable { /* ToDo */ }
                .background(Color.Cyan)
                .border(2.dp, Color.Blue)
                .padding(horizontal = 16.dp, vertical = 8.dp)
//                .background(Color.LightGray) // puedo repetir los atrubutos
//                .border(2.dp, Color.Red)
//                .padding(8.dp)
            // El orden importa

        )
    }
}

//@Preview(showBackground = true)
@Composable
fun MainText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello Hernán",
            color = Color.Blue,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            style = MaterialTheme.typography.titleLarge.copy( // podemos copiar cada tipografia y modificarla
                shadow = Shadow(
                    offset = Offset(3f, 3f), blurRadius = 5f,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            ),
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Text(
            text = stringResource(id = R.string.lorem),
            lineHeight = 2.em, //espacio entre lineas
            maxLines = 10,
//            softWrap = false, // el texto no se corta, continua en la misma linea
//            overflow = TextOverflow.Ellipsis, // indic con ... que exite mas texto
            color = Color.Cyan,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}


@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
//            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
//                model = "https://loremflickr.com/400/400/cat?lock=1",
                model = item.thumb,
                contentDescription = "Imagen tomada de internet",
                modifier = Modifier.fillMaxSize(),
//                    .clip(CircleShape)
                contentScale = ContentScale.Crop
            )
            if (item.type == Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = "Play",
                    modifier = Modifier
                        .size(96.dp)
                        .align(Alignment.Center),
                    tint = Color.White
                )
            }

//Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground),
//    contentDescription = null, tint = Color.Green)

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

//@Preview
//@Composable
//fun MediaList() {
//    LazyColumn(
//        contentPadding = PaddingValues(4.dp),
//        verticalArrangement = Arrangement.spacedBy(4.dp)
//
//    ) {
//        items(getMedia()) { item ->
//            MediaListItem(item)
//        }
//    }
//}

@ExperimentalFoundationApi
//@Preview
@Composable
fun MediaList() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(2.dp),
//        columns = GridCells.Fixed(2)
        columns = GridCells.Adaptive(150.dp)
    ) {
        items(getMedia()) { item ->
            MediaListItem(item, Modifier.padding(2.dp))
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun preview() {
//    MediaListItem(item)
//}

//@Preview(showBackground = true, widthDp = 400, heightDp = 400)
@Composable
fun StateSamplePreview() {
    var text by rememberSaveable { mutableStateOf("") }
    MyMoviesTheme {
        StateSample(text, { text = it })
    }
}

