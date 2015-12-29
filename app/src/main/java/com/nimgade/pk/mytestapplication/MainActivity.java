package com.nimgade.pk.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import app.activities.storage.AssignToCustomerActivity;
import app.activities.storage.CustomerActivity;
import app.activities.storage.PopulatePhoneNumberActivity;
import app.activities.storage.UnUsedPhoneActivity;

/**
 * This is the MainActivity which is parent to the other activities,
 * this helps you navigate to other activity depending on the button pressed in this activity.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button unused_Phone_Number_list;
    private Button populate_Phone_Number;
    private Button customer_list;
    private Button assign_Phone_Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeUI();
    }

    private void initializeUI() {

        unused_Phone_Number_list = (Button) findViewById(R.id.MainActivity_button_UnUsed_Phone_Number);
        unused_Phone_Number_list.setOnClickListener(this);
        populate_Phone_Number = (Button) findViewById(R.id.MainActivity_button_Customer_Phone_Number);
        populate_Phone_Number.setOnClickListener(this);
        customer_list = (Button) findViewById(R.id.MainActivity_button_Populate_Phone_Number);
        customer_list.setOnClickListener(this);
        assign_Phone_Number = (Button) findViewById(R.id.MainActivity_button_Assign_Phone_Number);
        assign_Phone_Number.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.MainActivity_button_UnUsed_Phone_Number:
                startActivity(new Intent(getApplicationContext(), UnUsedPhoneActivity.class));
                break;
            case R.id.MainActivity_button_Customer_Phone_Number:
                startActivity(new Intent(getApplicationContext(), CustomerActivity.class));
                break;
            case R.id.MainActivity_button_Populate_Phone_Number:
                startActivity(new Intent(getApplicationContext(), PopulatePhoneNumberActivity.class));
                break;
            case R.id.MainActivity_button_Assign_Phone_Number:
                startActivity(new Intent(getApplicationContext(), AssignToCustomerActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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
