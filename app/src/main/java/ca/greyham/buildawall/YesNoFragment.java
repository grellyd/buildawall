package ca.greyham.buildawall;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link YesNoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link YesNoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YesNoFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public YesNoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment YesNoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static YesNoFragment newInstance() {
        YesNoFragment fragment = new YesNoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_yes_no, container, false);

        Context context = this.getActivity();
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        //Yes Button
        Button applyButtonYes = (Button) view.findViewById(R.id.buttonYes);
        applyButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Apply_On_Click", "On click event fired");
                if (mListener != null) {
                    mListener.onFragmentInteraction(true);
                } else {
                    Log.e ("Apply_On_Click", "mListener is null");
                }
            }
        });

        //No Button
        Button applyButtonNo = (Button) view.findViewById(R.id.buttonNo);
        applyButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Apply_On_Click", "On click event fired");
                if (mListener != null) {
                    mListener.onFragmentInteraction(false);
                } else {
                    Log.e ("Apply_On_Click", "mListener is null");
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(boolean pass);
    }
}
