package NaturalLanguageProcessing;

public class SentimentClassification {
    float veryPositive;
    float positive;
    float neutral;
    float negative;
    float veryNegative;
    public SentimentClassification(){};
    public float getVeryPositive() {
        return this.veryPositive;
    }
    public float getPositive() {
        return this.positive;
    }
    public float getNeutral() {
        return this.neutral;
    }
    public float getNegative() {
        return this.negative;
    }
    public float getVeryNegative() {
        return this.veryNegative;
    }
    public void setVeryPositive(float newVeryPositive) {
            this.veryPositive = newVeryPositive;
        }
    public void setPositive(float newPositive) {
            this.positive = newPositive;
        }
    public void setNeutral(float newNeutral) {
            this.neutral = newNeutral;
        }
    public void setNegative(float newNegative) {
            this.negative = newNegative;
        }
    public void setVeryNegative(float newVeryNegative) {
            this.veryNegative = newVeryNegative;
        }
    }