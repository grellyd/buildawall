package ca.greyham.buildawall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LauncherActivity extends AppCompatActivity {

    //TODO: Connect to server
    //TODO: Query the server for client details
    //TODO: Assign and show fragment with Party Association
    //TODO: Fire intent to launch main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        startServerConversation();
    }


    public void startServerConversation() {
        // Connect with server and receive validation
        // TODO

        // Wait on open connection
        // TODO

        // Learn which party you are a part of and show user
        showPartyAffiliation();
    }

    public void showPartyAffiliation() {
        ImageView imageView = (ImageView) findViewById(R.id.launcher_imageView);
        imageView.setVisibility(View.VISIBLE);

        Button button = (Button) findViewById(R.id.launcher_button);
        button.setVisibility(View.VISIBLE);
    }

    public void buttonGo_Click(View v)
    {
        Intent mainActivity = new Intent(LauncherActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }
}
