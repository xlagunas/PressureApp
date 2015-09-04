package cat.xlagunas.pressureapp.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import cat.xlagunas.pressureapp.R;
import cat.xlagunas.pressureapp.util.DatabaseHelper;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 3000;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                Class nextActivityClass;
                try {
                    nextActivityClass = checkUserCreated() ? DrawerActivity.class : NewUserActivity.class;
                } catch (SQLException e){
                    nextActivityClass = DrawerActivity.class;
                    Log.e(this.getClass().getName(), "Error sql", e);
                }
                    startActivity(new Intent(SplashActivity.this, nextActivityClass));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private boolean checkUserCreated() throws SQLException{
        return getDatabaseHelper().getUserDao().countOf() < 0 ? true : false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
    }

    private DatabaseHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}
