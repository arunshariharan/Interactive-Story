package arunshariharan.com.interactivestory.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import arunshariharan.com.interactivestory.R;

public class LandingActivity extends Activity {

    private static final String TAG = LandingActivity.class.getSimpleName();

    private EditText mName;
    private EditText mAge;
    private RadioGroup mSexRadioGroup;
    private RadioButton mSex;
    private Button mGetUserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mName = (EditText)findViewById(R.id.nameEditText);
        mAge = (EditText)findViewById(R.id.ageEditText);
        mGetUserData = (Button)findViewById(R.id.dataButton);

        mSexRadioGroup = (RadioGroup)findViewById(R.id.sexRadioGroup);
        int selectedRadioId = mSexRadioGroup.getCheckedRadioButtonId();
        mSex= (RadioButton)findViewById(selectedRadioId);

        listenerMainButton();
    }


    public void listenerMainButton() {
        mGetUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString();
                int age = Integer.valueOf(mAge.getText().toString());
                String sex;
                if(mSex.isChecked())
                    sex = "Male";
                else
                    sex = "Female";

                Log.d(TAG, name );
                Log.d(TAG, sex);

                loadFirstPage(name,sex);
            }
        });
    }

    public void loadFirstPage(String name, String sex) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getString(R.string.user_name),name);
        intent.putExtra(getString(R.string.sex),sex);


        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mName.setText("");
        mAge.setText("");
        mSex.setChecked(false);

    }
}
