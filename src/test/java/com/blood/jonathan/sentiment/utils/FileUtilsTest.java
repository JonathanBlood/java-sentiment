package com.blood.jonathan.sentiment.utils;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Jonathan Blood
 */
public class FileUtilsTest {

  private static final String TEXT_FILE = "AFINN-emoticon-8.txt";
  private static final String CSV_FILE = "AFINN-emoticon-8.csv";

  @Test
  public void shouldReturnTrueWhenTextFileIsProvided() {
    assertTrue(FileUtils.isTextFile(Paths.get(TEXT_FILE)));
  }

  @Test
  public void shouldReturnTrueWhenCsvFileIsProvided() {
    assertFalse(FileUtils.isTextFile(Paths.get(CSV_FILE)));
  }

  @Test
  public void shouldReturnFalseWhenNullIsProvided() {
    assertFalse(FileUtils.isTextFile(null));
  }
}
