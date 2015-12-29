package app.activities.storage;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.nimgade.pk.mytestapplication.R;

import classes.Customer;
import classes.PhoneNumber;
import classes.StartUp;
import classes.Validations;

/**
 * This activity used to allow user to assign a phone Number to a customer who has called.
 */
public class AssignToCustomerActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText customer_Name_EditText;
    private AutoCompleteTextView phone_number_AutoCompleteTextView;
    private ImageButton find_phone_number_Button;
    private Button save_Button;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_to_customer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeUI();
    }

    private void initializeUI() {

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinateLayout);
        customer_Name_EditText = (EditText) findViewById(R.id.AssignToCustomerActivity_Customer_Name_editText);
        phone_number_AutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.AssignToCustomerActivity_Phone_Number_editText);

        if (StartUp.getUnusedPhoneNumbers().size()>0) {
            ArrayAdapter<PhoneNumber> adapter = new ArrayAdapter<PhoneNumber>(this, android.R.layout.simple_spinner_dropdown_item, StartUp.getUnusedPhoneNumbers());
            phone_number_AutoCompleteTextView.setAdapter(adapter);
        }
        find_phone_number_Button = (ImageButton) findViewById(R.id.AssignToCustomerActivity_find_Phone_Number_ImageButton);
        find_phone_number_Button.setOnClickListener(this);
        save_Button = (Button) findViewById(R.id.AssignToCustomerActivity_Save_button);
        save_Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AssignToCustomerActivity_Save_button:
                doValidation();
                break;
            case R.id.AssignToCustomerActivity_find_Phone_Number_ImageButton:
                if (StartUp.getUnusedPhoneNumbers().size() > 0) {
                    PhoneNumber phoneNumber = StartUp.getUnusedPhoneNumbers().get(0);
                    phone_number_AutoCompleteTextView.setText("" + phoneNumber.getPhone_Number());
                } else {
                    Snackbar.make(coordinatorLayout, "No Phone Number Available", Snackbar.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void doValidation() {
        String customer_Name = customer_Name_EditText.getText().toString();
        String phone_Number = phone_number_AutoCompleteTextView.getText().toString();


        if (!Validations.isValidCustomerName(customer_Name.trim())) {
            Snackbar.make(coordinatorLayout, "Kindly Provide a valid Customer Name", Snackbar.LENGTH_SHORT).show();
            return;
        }

        if (!Validations.isValidPhoneNumber(phone_Number.trim())) {
            Log.d("AssignToCustomer", phone_Number + " " + Validations.isValidPhoneNumber(phone_Number.trim()));
            Snackbar.make(coordinatorLayout, "Kindly Provide a valid Phone Number", Snackbar.LENGTH_SHORT).show();
            return;
        }

        PhoneNumber phoneNumber = StartUp.findGivenPhoneNumber(phone_Number);

        if (phoneNumber != null) {

            if (!phoneNumber.isAssigned()) {
                phoneNumber.setIsAssigned(true);
                Customer customer = new Customer(customer_Name.trim(), phoneNumber);
                StartUp.getCustomers().add(customer);
                Snackbar.make(coordinatorLayout, "Phone Number has been assigned", Snackbar.LENGTH_SHORT).show();
                customer_Name_EditText.setText("");
                phone_number_AutoCompleteTextView.setText("");
                if (StartUp.getUnusedPhoneNumbers().size()>0) {
                    ArrayAdapter<PhoneNumber> adapter = new ArrayAdapter<PhoneNumber>(this, android.R.layout.simple_spinner_dropdown_item, StartUp.getUnusedPhoneNumbers());
                    phone_number_AutoCompleteTextView.setAdapter(adapter);
                }
            } else {
                Snackbar.make(coordinatorLayout, "Phone Number is already been assigned", Snackbar.LENGTH_SHORT).show();
                return;
            }

        } else {
            Snackbar.make(coordinatorLayout, "Phone Number is not available", Snackbar.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_assign_to_customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }


}
