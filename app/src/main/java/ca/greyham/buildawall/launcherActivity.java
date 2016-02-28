package ca.greyham.buildawall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LauncherActivity extends AppCompatActivity {

    //TODO: Connect to server
    //TODO: Query the server for client details
    //TODO: Assign and show fragment with Party Association
    //TODO: Fire intent to launch main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }


    public void buttonGo_Click(View v)
    {
        Intent mainActivity = new Intent(LauncherActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }
}
