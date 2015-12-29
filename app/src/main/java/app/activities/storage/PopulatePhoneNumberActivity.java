package app.activities.storage;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nimgade.pk.mytestapplication.R;

import classes.Response;
import classes.StartUp;
import classes.Validations;

/**
 * This activity used populate a individual phone Number in the PhoneNumber List in the Application.
 */
public class PopulatePhoneNumberActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText phone_number_EditText;
    private Button save_Button;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populate_phone_number);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeUI();
    }

    private void initializeUI() {

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinateLayout);
        phone_number_EditText = (EditText) findViewById(R.id.PopulatePhoneNumberActivity_phone_number_editText);
        save_Button = (Button) findViewById(R.id.PopulatePhoneNumberActivity_save_button);
        save_Button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.PopulatePhoneNumberActivity_save_button:
                String phone_Number = phone_number_EditText.getText().toString();
                String tempPhoneNumber = phone_Number.replaceAll("\\D+", "");
                Response response = StartUp.addPhoneNumber(tempPhoneNumber);
                Snackbar.make(coordinatorLayout, "" + response.getMessage(), Snackbar.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    phone_number_EditText.setText("");
                }
                break;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_populate_phone_number, menu);
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
