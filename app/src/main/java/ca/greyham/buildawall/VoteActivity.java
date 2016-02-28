package ca.greyham.buildawall;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {

    // TODO: Query the server for vote object that describes the current vote.
    // TODO: Show the vote to be considered
    // TODO: Submit the vote choice

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        //new
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment dynamicYesNoFragment = YesNoFragment.newInstance();
        fragmentTransaction.add(R.id.selection_linear_layout, dynamicYesNoFragment, "dynamic_yesNo_fragment_tag");
        fragmentTransaction.commit();
    }
}
