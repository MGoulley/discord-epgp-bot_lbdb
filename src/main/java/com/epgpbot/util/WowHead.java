package com.epgpbot.util;



public class WowHead {

  private final String url;
  private HttpURLConnection connection = null;

  public WowHead(String url) {
    this.url = url;
  }

  private String getItem(String id) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com/"))
                .build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    System.out.println("response body: " + response.body());
  }
}
