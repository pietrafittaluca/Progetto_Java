package WebScraping.Page.TablePage.Review;

import NaturalLanguageProcessing.SentimentAnalyzer;
import NaturalLanguageProcessing.SentimentClassification;

public class Review {
        private String text_content;
        private SentimentClassification sentimentClassification;

        public Review(String newText_content){
            System.out.println("Sono nel costruttore di review");
            text_content = newText_content;
            this.analyzeText_content();
        }

        public void analyzeText_content(){
            SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer(text_content);
            sentimentAnalyzer.analyzeText();
            this.sentimentClassification = sentimentAnalyzer.getSentimentClassification();
        }

        public SentimentClassification getSentimentClassification(){
            if(this.sentimentClassification == null)
                this.analyzeText_content();
            return this.sentimentClassification;
        }

        public String getText_content(){
          return this.text_content;
        }
}
