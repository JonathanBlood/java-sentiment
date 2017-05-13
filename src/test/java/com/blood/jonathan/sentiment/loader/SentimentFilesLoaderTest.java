package com.blood.jonathan.sentiment.loader;

import com.blood.jonathan.sentiment.loader.SentimentFilesLoader;
import com.blood.jonathan.sentiment.loader.SentimentLoader;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Jonathan Blood
 */
public class SentimentFilesLoaderTest {

  private SentimentLoader sentimentLoader = new SentimentFilesLoader();

  @Test
  public void shouldHaveLoadedSentimentData()
  {
    Map<String, Integer> sentiments = sentimentLoader.loadData();
    assertFalse(sentiments.isEmpty());
  }
}
