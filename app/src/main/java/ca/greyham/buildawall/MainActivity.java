package ca.greyham.buildawall;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    //TODO: Fire intent to launch selectionActivity
    //TODO: Build and populate the launcher MemberOC list
    //TODO: Query the server for bill tracker details

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // TODO: Get server world state
        // TBRemoved
        List<MemberOC> mocList = new ArrayList<MemberOC>();


        for (MemberOC moc : mocList) {
            fragmentManager.beginTransaction();
            Fragment newMOCFragment = MOCFragment.newInstance("", "");
            fragmentTransaction.add(R.id.mainActivityScrollView, newMOCFragment,"");
        }
    }
}
