package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          DashboardScreen(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}

data class Service(val name: String, val icon: ImageVector)

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
  val services = listOf(
    Service("Chat", Icons.Default.Chat),
    Service("Writing", Icons.Default.Edit),
    Service("Translate", Icons.Default.Translate),
    Service("Summarize", Icons.Default.Description)
  )

  Column(modifier = modifier.padding(16.dp)) {
    Text(
      text = "AI Smart Assistant",
      style = MaterialTheme.typography.headlineMedium,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(bottom = 16.dp)
    )
    LazyVerticalGrid(
      columns = GridCells.Fixed(2),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      items(services) { service ->
        ServiceCard(service)
      }
    }
  }
}

@Composable
fun ServiceCard(service: Service) {
  Card(
    modifier = Modifier.fillMaxWidth().height(120.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Column(
      modifier = Modifier.fillMaxSize().padding(16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Icon(service.icon, contentDescription = null, modifier = Modifier.size(32.dp))
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = service.name, style = MaterialTheme.typography.titleMedium)
    }
  }
}
