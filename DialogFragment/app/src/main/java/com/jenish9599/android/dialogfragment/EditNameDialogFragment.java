package com.jenish9599.android.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jenishpatel on 27/12/17.
 */

public class EditNameDialogFragment extends DialogFragment implements TextView.OnEditorActionListener{

    private EditText editText;
    public EditNameDialogFragment() {
    }



    public interface EditnameDialogListener{
            void onFinishEditDialog(String inputtxt);
    }



    public void sendBackResult() {

        EditnameDialogListener listener = (EditnameDialogListener) getTargetFragment();
        listener.onFinishEditDialog(editText.getText().toString());
        dismiss();
    }


    public static EditNameDialogFragment newInstance(String title){
        EditNameDialogFragment editNameDialogFragment = new EditNameDialogFragment();
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


        editText = (EditText)view.findViewById(R.id.txt_your_name);

        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);

        editText.requestFocus();
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);


        editText.setOnEditorActionListener(this);

        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {

            EditnameDialogListener listener = (EditnameDialogListener) getActivity();
            listener.onFinishEditDialog(editText.getText().toString());
            dismiss();
            return true;
        }
        return false;

    }



}

