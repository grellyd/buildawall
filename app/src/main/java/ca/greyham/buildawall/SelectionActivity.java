package ca.greyham.buildawall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SelectionActivity extends AppCompatActivity {

    //TODO: Query the server for the client ID of the MemberOC who is selecting
    //TODO: For that MOC, show the form committee fragment
    //TODO: 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }
}
