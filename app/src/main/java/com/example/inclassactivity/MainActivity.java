package com.example.inclassactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nameEdtTxt;
    EditText emailEdtTxt;
    RadioGroup radioGroup;
    RadioButton maleRB;
    RadioButton femaleRB;
    Switch lastYearSwitch;
    TextView resultTxtView;
    Spinner facultySpnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        linkViews();
        populateSpinner();



    }
    public void linkViews(){
        nameEdtTxt=(EditText) findViewById(R.id.nameEdtTxt);
        emailEdtTxt=(EditText) findViewById(R.id.emailEdtTxt);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        maleRB=(RadioButton) findViewById(R.id.maleRB);
        femaleRB=(RadioButton) findViewById(R.id.femaleRB);
        lastYearSwitch =(Switch) findViewById(R.id.lastYearSw);
        resultTxtView=(TextView) findViewById(R.id.resultTxtView);
        facultySpnn=(Spinner) findViewById(R.id.facultySpnn);
    }

    public void saveBtnClick(View view) {
        String name=nameEdtTxt.getText().toString();
        String email=emailEdtTxt.getText().toString();
        int id=radioGroup.getCheckedRadioButtonId();
        if (id== -1 || name.isEmpty() || email.isEmpty()){
            Toast.makeText(MainActivity.this,"Enter all information",Toast.LENGTH_SHORT).show();

        }
        else{
            String gender=maleRB.isChecked()? "Male":"Female";
            String lastYear=lastYearSwitch.isChecked()?"Last year":"Not Last Year";
            resultTxtView.setText(name +"\n"+email+"\n"+gender+"\n"+lastYear+"\n"+facultySpnn.getSelectedItem());
        }
    }
    public void populateSpinner(){
        String[] faculties={"IT","Science","Medicine"};
        ArrayAdapter items=new ArrayAdapter(this, android.R.layout.simple_spinner_item,faculties);
        facultySpnn.setAdapter(items);
    }
}