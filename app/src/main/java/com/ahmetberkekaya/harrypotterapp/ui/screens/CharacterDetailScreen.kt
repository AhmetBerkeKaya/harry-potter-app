import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.IconButton
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ahmetberkekekaya.harrypotterapp.data.model.Character

@Composable
fun CharacterDetailScreen(character: Character, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F1C2C))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Geri butonu
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack, // Varsayılan geri ok simgesi
                contentDescription = "Geri",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Karakter adı
        Text(
            text = character.name ?: "İsim yok",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Karakter resmi
        Image(
            painter = rememberAsyncImagePainter(character.image ?: ""),
            contentDescription = character.name,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(20)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Ev bilgisi
        Text(
            text = "Ev: ${character.house ?: "Bilinmiyor"}",
            fontSize = 18.sp,
            color = Color.White
        )

        // Doğum tarihi
        Text(
            text = "Doğum tarihi: ${character.dateOfBirth ?: "Yok"}",
            fontSize = 18.sp,
            color = Color.White
        )

        // Aktör bilgisi
        Text(
            text = "Aktör: ${character.actor ?: "Bilinmiyor"}",
            fontSize = 18.sp,
            color = Color.White
        )
    }
}
