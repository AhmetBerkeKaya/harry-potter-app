import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ahmetberkekaya.harrypotterapp.R
import com.ahmetberkekekaya.harrypotterapp.data.model.Character
import com.ahmetberkekekaya.harrypotterapp.viewmodel.CharacterViewModel

val backgroundGradient = Brush.verticalGradient(
    colors = listOf(Color(0xFF1F1C2C), Color(0xFF928DAB)) // Büyülü gece havası
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterScreen(viewModel: CharacterViewModel, navController: NavHostController) {
    val characterList = viewModel.characters.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = backgroundGradient)
    ) {
        when {
            characterList.isEmpty() && errorMessage == null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color.White)
                }
            }

            errorMessage != null -> {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }

            else -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(characterList) { character ->
                        CharacterItem(character = character) {
                            navController.navigate("characterDetail/${character.name}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character, onClick: () -> Unit) {
    val placeholderImage = R.drawable.placeholder

    val imagePainter = if (character.image.isNullOrBlank()) {
        painterResource(id = placeholderImage)
    } else {
        rememberAsyncImagePainter(character.image)
    }

    val isInfoMissing = character.name.isNullOrBlank() || character.house.isNullOrBlank()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }, // onClick artık buraya geldi
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2E1E3A))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = imagePainter,
                contentDescription = character.name ?: "Karakter görseli",
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(50)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = character.name ?: "İsim bilinmiyor",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = character.house?.uppercase() ?: "Ev bilgisi yok",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = Color(0xFFB39DDB)
            )

            if (isInfoMissing) {
                Text(
                    text = "Bu karakterin bazı bilgileri eksik.",
                    fontSize = 10.sp,
                    color = Color.Red.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


