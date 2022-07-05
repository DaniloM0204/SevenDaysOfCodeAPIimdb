import java.util.List;

interface Content extends Comparable<Content> {
  String title();
  String urlImage();
  String rating();
  String year();
}

interface JsonParser {
  List<? extends Content> parse();
}

interface ApiClient {
  String getBody();
}
