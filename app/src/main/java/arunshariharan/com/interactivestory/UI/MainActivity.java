package arunshariharan.com.interactivestory.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import arunshariharan.com.interactivestory.R;


public class MainActivity extends Activity {

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText)findViewById(R.id.nameEditText);
        mStartButton = (Button)findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {    //Just type in the button name and type in setOnClickListener with new View.On... to complete the inner class
            @Override
            public void onClick(View view) {
                String name = mNameField.getText().toString();
                Toast.makeText(MainActivity.this, name,Toast.LENGTH_LONG).show();   //Using MainActivity.this rather than this because, this toast is inside the inner class of
                                                                                    // setOnClickListener and in order to access the actual activity, we use the activity name and then this.

                startStory(name);   //pass the value to setStory so it can be used in intent on new activity.
            }
        });

    }

    private void startStory(String name) {
        Intent intent = new Intent(this,StoryActivity.class);   //Context, the class of the intent action
        intent.putExtra(getString(R.string.key_name),name);
        startActivity(intent);
    }

    //If the activity is resumed or the user presses play again, this method gets activated
    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText(""); // This is to reset the name field when the player plays again or the activity is resumed
    }
}





