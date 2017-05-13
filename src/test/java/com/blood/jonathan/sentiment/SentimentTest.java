package com.blood.jonathan.sentiment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Jonathan Blood
 */
public class SentimentTest
{
  private static final String POSITIVE_PHRASE = "Funny happy people.";
  private static final String NEGATIVE_PHRASE = "I hate you so much right now.";
  private static final String NEUTRAL_PHRASE = "To be or not to be.";

  private static final String HAPPY_EMOTICON = ":)";
  private static final String SAD_EMOTICON = ":(";
  private static final String NEUTRAL_EMOTICON = "://";

  private Sentiment sentiment;

  @Before
  public void setup() {
    sentiment = Sentiment.getInstance();
  }

  @Test
  public void shouldBeSingleton() {
    Sentiment sentimentToCompare = Sentiment.getInstance();
    assertEquals(true, sentiment == sentimentToCompare);
  }

  @Test
  public void shouldReturnPositiveScore() {
    assertTrue(sentiment.analyze(POSITIVE_PHRASE).getScore() > 0);
  }

  @Test
  public void shouldReturnNegativeScore() {
    assertTrue(sentiment.analyze(NEGATIVE_PHRASE).getScore() < 0);
  }

  @Test
  public void shouldReturnNeutralScore() {
    assertEquals(0,sentiment.analyze(NEUTRAL_PHRASE).getScore());
  }

  @Test
  public void shouldReturnPositiveState() {
    assertEquals(SentimentState.POSITIVE.name(), sentiment.analyze(HAPPY_EMOTICON).getState());
  }

  @Test
  public void shouldReturnNegativeState() {
    assertEquals(SentimentState.NEGATIVE.name(), sentiment.analyze(SAD_EMOTICON).getState());
  }

  @Test
  public void shouldReturnNeutralState() {
    assertEquals(SentimentState.NEUTRAL.name(), sentiment.analyze(NEUTRAL_EMOTICON).getState());
  }

  @Test
  public void shouldContainTwoDetectedWords() {
    assertEquals(2, sentiment.analyze(POSITIVE_PHRASE).getDetectedWords().size());
  }

  @Test(expected=IllegalArgumentException.class)
  public void shouldThrowIllegalArgumentExceptionWhenTextIsNull() {
    sentiment.analyze(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void shouldThrowIllegalArgumentExceptionWhenTextIsEmpty() {
    sentiment.analyze("");
  }
}
