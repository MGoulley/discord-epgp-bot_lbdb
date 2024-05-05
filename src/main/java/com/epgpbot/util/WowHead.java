package com.epgpbot.util;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

public class WowHead {

  private final String url;

  public WowHead(String url) {
    this.url = url;
  }

  public String getItem(String id) {
    HttpClient client = HttpClient.newBuilder().followRedirects(Redirect.NORMAL).build();
    String itemUrl =  url + "item=" + id;
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(itemUrl)).build();
    HttpResponse<String> response;
    try {
      response = client.send(request, BodyHandlers.ofString());
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
      Document doc = docBuilder.parse(new InputSource(new StringReader(response.body())));
      Element root = doc.getDocumentElement();
      NodeList nameNodesList = root.getElementsByTagName("head");
      ArrayList<String> nameValues = null;
      // Now iterate through the Nodelist to get the values you want.
      for (int i=0; i<nameNodesList.getLength(); i++){
          nameValues.add(nameNodesList.item(i).getTextContent());
      }
      String result = response.body();
      System.out.println("URL: " + itemUrl);
      System.out.println("response body: " + result);
      return result;
    } catch (IOException | InterruptedException | ParserConfigurationException | SAXException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
}
