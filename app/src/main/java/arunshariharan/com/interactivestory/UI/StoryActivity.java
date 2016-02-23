package arunshariharan.com.interactivestory.UI;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import arunshariharan.com.interactivestory.Model.Choice;
import arunshariharan.com.interactivestory.Model.Page;
import arunshariharan.com.interactivestory.Model.Story;
import arunshariharan.com.interactivestory.R;

public class StoryActivity extends Activity {

    public static final String TAG = StoryActivity.class.getSimpleName();   //Log

    //Declare all the variables that will be used to manipulate the app in this activity
    private Story mStory = new Story();     // Member Variable of Story Class. Use it to access the methods and values of Story class
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));    // the key should exactly be the same as we previously set


        if (mName==null) {
            mName = "Friend";
        }
        Log.d(TAG, mName);

        //Initialise the declared variables - so the xml and the activity elements are connected
        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    //In this method, we will load the objects of the page such as the image, text and buttons
    //Corresponding to that particular page number.
    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);      // Set a new page variable, which gets the page number
                                            // from the Story.class and the specified method

        //Now we need to set the Image from getImageID() getter method from the Page.class. TO do that
        //We need to call the Drawable resource, and then use getDrawable to get the imageId from page class
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());

        //Then use the drawable we obtained to set the image to the imageView
        mImageView.setImageDrawable(drawable);

        //Get the story text from the Page class
        String pageText = mCurrentPage.getText();

        /*
            This is a String Format method in Java
            This replaces the given text (here pageText) with the supplied argument(s) - here it is mName
            If the mName is found in the pageText, it will replace, otherwise it will ignore.
            This is basically a search and replace method inbuilt in java
        */
        pageText = String.format(pageText,mName);
        mTextView.setText(pageText);  //Set the text view from Page class's getter text method

        //If we are reaching final pages, use this.
        if(mCurrentPage.isFinal()) {
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("Play Again");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //finish();       //Since we are returning back to MainActivity from which this activity was initiated, we can just use finish() rather than starting a new intent.
                    Intent intent = new Intent(StoryActivity.this,LandingActivity.class);
                    startActivity(intent);
                }
            });

        }
        else {

            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            // Set onClickListener for these buttons to work
            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }


}
