package ca.greyham.buildawall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //TODO: Fire intent to launch selectionActivity
    //TODO: Build and populate the launcher MemberOC list
    //TODO: Query the server for bill tracker details

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //new
    public void buttonGo_Click(View v)
    {
        Intent selectionActivity = new Intent(MainActivity.this, SelectionActivity.class);
        startActivity(selectionActivity);
    }
}
