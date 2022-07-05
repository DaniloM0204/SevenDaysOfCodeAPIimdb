import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// ImdbApiClient implementando a nova interface
class ImdbApiClient implements ApiClient {
  private String apiKey;

  public ImdbApiClient(String apiKey) {
    this.apiKey = apiKey;
  }

  /* (non-Javadoc)
   * @see App.ApiClient#getBody()
   */
  public String getBody() {
    try {
      URI apiIMDB = URI.create(
        "https://imdb-api.com/en/API/Top250TVs/" + this.apiKey
      );

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();
      HttpResponse<String> response = client.send(
        request,
        HttpResponse.BodyHandlers.ofString()
      );

      return response.body();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }
}
