package arunshariharan.com.interactivestory.Model;

/**
 * Created by arunshariharan on 2/22/2016.
 */
public class Page {
    private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean isFinal = false;    //To Check if we are in the final pages of the app


    //Constructor 1 - with all data in for pages 0 to 5
    public Page(int imageId, String text, Choice choice1, Choice choice2) {
        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    //Constructor 1 - with only 2 data in for final pages
    public Page(int imageId, String text) {
        mImageId = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        isFinal = true;
    }

    //Getters and Setters
    //Use Code -> Generate -> Getter and Setter to set these values automatically
    //Use settings -> code layout -> Java -> Code Generation to type in "m" as a prefix to remove Prefix of m from
    //Getters and Setters

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }
}
