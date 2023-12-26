import androidx.compose.runtime.mutableStateListOf
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

  val posts = mutableStateListOf<Post>()

  private val httpClient = HttpClient() {
    install(ContentNegotiation) {
      json()
    }
  }

  internal fun getPosts() {
    viewModelScope.launch {
      posts.addAll(
        httpClient.get("https://jsonplaceholder.typicode.com/posts")
          .body<List<Post>>()
      )
    }
  }
}