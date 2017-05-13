# java-sentiment
A simple Java AFINN based sentiment analysis library.

## Build
To build and package project run:
```
$ mvn clean package
```

## Usage
```java
Sentiment sentiment = Sentiment.getInstance();
SentimentResult result = sentiment.analyze("I am so happy to be here.");

System.out.println("The score is: " + result.getScore());
System.out.println("The state is: " + result.getState());
System.out.println("The number of detected words are: " + result.getDetectedWords().size());
```
