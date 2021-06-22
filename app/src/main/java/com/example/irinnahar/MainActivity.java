package com.example.irinnahar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private String region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_toronto:
                if (checked)
                    region = "Toronto";
                    break;
            case R.id.radio_peel:
                if (checked)
                    region = "Peel";
                    break;
            case R.id.radio_waterloo:
                if (checked)
                    region = "Waterloo";
                    break;
            case R.id.radio_ottawa:
                if (checked)
                    region = "Ottawa";
                    break;
            case R.id.radio_hamilton:
                if (checked)
                    region = "Hamilton";
                    break;

        }
    }

    public void goToChart(View view) {
        Intent intent = new Intent(getBaseContext(), ChartActivity.class);
        intent.putExtra("chosenRegion", region);
        startActivity(intent);
    }
}