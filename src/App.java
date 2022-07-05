import java.io.PrintWriter;
import java.util.List;

public class App {

  public static void main(String[] args) throws Exception {
    System.out.println("Chamando API");
    String apiKey = "sua chave";
    String json = new ImdbApiClient(apiKey).getBody();

    System.out.println("Parsing do JSON");
    JsonParser jsonParser = new ImdbMovieJsonParser(json);
    List<? extends Content> contentList = jsonParser.parse();

    System.out.println("Gerando HTML");
    PrintWriter writer = new PrintWriter("content.html");
    new HtmlGenerator(writer).generate(contentList);
    writer.close();
  }
}
