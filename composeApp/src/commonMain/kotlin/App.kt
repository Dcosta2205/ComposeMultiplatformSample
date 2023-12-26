import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App() {
  MaterialTheme {
    val postViewModel = getViewModel(Unit, viewModelFactory { PostViewModel() })


    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      Button(onClick = { postViewModel.getPosts() }) {
        Text("Click me!")
      }
      LazyColumn(modifier = Modifier.fillMaxHeight()) {

        items(postViewModel.posts) { post ->
          Card(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            elevation = 2.dp
          ) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
              Text(text = post.title, style = MaterialTheme.typography.body1, color = Color.Black)
              Spacer(Modifier.height(12.dp))
              Text(text = post.body, style = MaterialTheme.typography.body2, color = Color.Black)
            }
          }
        }
      }
    }
  }
}

