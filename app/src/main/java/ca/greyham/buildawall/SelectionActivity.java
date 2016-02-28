package ca.greyham.buildawall;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SelectionActivity extends AppCompatActivity {

    //TODO: Query the server for the client ID of the MemberOC who is selecting
    //TODO: For that MOC, show the form committee fragment, and blank for the others
    //TODO: After the selection is made, send the results to the server with the chosen members
    //TODO: For other MOCs show the committee approval fragment, and blank for the leader
    //TODO: Show if the selection passed. If not, return to step one with the query
    //TODO: If passed then fire the intent to the vote activity
    //TODO: If failed five times, fire the intent to the main_activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // TODO: Get server world state
        // TBRemoved
        List<MemberOC> mocList = new ArrayList<MemberOC>();

        for (MemberOC moc : mocList) {
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            Fragment newMOCCheckboxFragment = MOCCheckboxFragment.newInstance(moc.getName());
            fragmentTransaction.add(R.id.selection_scroll_view, newMOCCheckboxFragment,"");
        }

        Fragment dynamicYesNoFragment = YesNoFragment.newInstance();
        fragmentTransaction.add(R.id.selection_linear_layout, dynamicYesNoFragment, "dynamic_yesNo_fragment_tag");
        fragmentTransaction.commit();
    }

    public void onFragmentInteraction(boolean pass)
    {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .hide(fragmentManager.findFragmentByTag("dynamic_yesNo_fragment_tag"))
                .commit();

        //revive/wait response from the server

        if(pass){
            //vote passed: fire the intent to voteActivity
            Intent voteActivity = new Intent(SelectionActivity.this, VoteActivity.class);
            startActivity(voteActivity);

        }else{
            //vote failed: this the list of clients, wait for response, keep going selection(in selectionActivity)
            //vote failed: or already five times, go back to main activity
            Intent mainActivity = new Intent(SelectionActivity.this, MainActivity.class);
            startActivity(mainActivity);
        }


    }
}
