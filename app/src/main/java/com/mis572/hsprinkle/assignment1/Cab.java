package com.mis572.hsprinkle.assignment1;

import java.text.DecimalFormat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Cab extends ActionBarActivity {

    double mileageRate = 3.25;
    int distance;
    double totalCost;
    String vehicleChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab);

        //stores value of user input
        final EditText miles = (EditText)findViewById(R.id.distance);

        final Spinner vehicle = (Spinner)findViewById(R.id.vehicleChoice);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.preferred_cab, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        vehicle.setAdapter(adapter);

        Button fare = (Button)findViewById(R.id.btnFare);

        fare.setOnClickListener(new OnClickListener(){

            final TextView result = ((TextView)findViewById(R.id.fareResult));
            @Override
            public void onClick(View v){

                distance = Integer.parseInt(miles.getText().toString());
                totalCost = 3.0 + (mileageRate * distance);
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                vehicleChoice = vehicle.getSelectedItem().toString();
                result.setText("The fare for " + distance + " miles in a " + vehicleChoice + " is " + currency.format(totalCost));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
