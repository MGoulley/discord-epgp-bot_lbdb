package com.epgpbot.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WowHeadTests {

  @Test  
  public void testGetItem() {  
    WowHead wowHeadAPi = new WowHead("https://www.wowhead.com/cata/");
    String expected = "AAAAA";
    String result = wowHeadAPi.getItem("49306");
    System.out.println("Resultat : " + result);
	  assertEquals(expected, result);  
  }
}
