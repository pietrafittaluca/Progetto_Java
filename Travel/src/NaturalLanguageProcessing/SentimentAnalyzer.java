package NaturalLanguageProcessing;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.ejml.simple.SimpleMatrix;
import java.util.Properties;

public class SentimentAnalyzer {

    /*
     * "Very negative" = 0 "Negative" = 1 "Neutral" = 2 "Positive" = 3
     * "Very positive" = 4
     */
    private Properties props;
    private StanfordCoreNLP pipeline;
    private SentimentClassification sentimentClassification;
    private String text;


    public SentimentAnalyzer(String newText){
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and sentiment
        props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
        sentimentClassification = new SentimentClassification();
        text = newText;
    }




    public void analyzeText() {
        if (this.text != null && this.text.length() > 0) {
            // run all Annotators on the text
            Annotation annotation = pipeline.process(this.text);
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
                // this is the parse tree of the current sentence
                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                SimpleMatrix sm = RNNCoreAnnotations.getPredictions(tree);
                this.sentimentClassification.setVeryPositive((float)Math.round(sm.get(4) * 100d));
                this.sentimentClassification.setPositive((float)Math.round(sm.get(3) * 100d));
                this.sentimentClassification.setNeutral((float)Math.round(sm.get(2) * 100d));
                this.sentimentClassification.setNegative((float)Math.round(sm.get(1) * 100d));
                this.sentimentClassification.setVeryNegative((float)Math.round(sm.get(0) * 100d));
                System.out.println("Ho calcolato tutto");
            }
        }
    }
    public SentimentClassification getSentimentClassification() {
        return this.sentimentClassification;
    }

    public String getText(){
        return this.text;
    }
}
