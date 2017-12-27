package com.jenish9599.android.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Created by jenishpatel on 27/12/17.
 */

public class AlerDialogFragment extends DialogFragment {

    private EditText editText;
    public AlerDialogFragment() {
    }

    public static AlerDialogFragment newInstance(String title){
        AlerDialogFragment editNameDialogFragment = new AlerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        editNameDialogFragment.setArguments(bundle);

        return editNameDialogFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_name,container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText = (EditText)view.findViewById(R.id.txt_your_name);

        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);

        editText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);


    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage("Are You Sure ?");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               if(dialog != null){
                   dialog.dismiss();
               }
            }
        });




        return alertDialogBuilder.create();


    }

}
