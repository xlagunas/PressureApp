package cat.xlagunas.pressureapp.ui.activities;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cat.xlagunas.pressureapp.R;
import cat.xlagunas.pressureapp.ui.dialogs.TimePickerFragment;

public class NewUserActivity extends AppCompatActivity {

    @Bind(R.id.alarm_button)
    Button alarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.alarm_button)
    public void onAlarmButtonClick(View v) {
        DialogFragment newFragment = new TimePickerFragment(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                super.onTimeSet(view, hourOfDay, minute);
                Toast.makeText(NewUserActivity.this, "Selected time ["+ hourOfDay + " : " + minute +"]", Toast.LENGTH_LONG).show();
            }
        };
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_user, menu);
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
