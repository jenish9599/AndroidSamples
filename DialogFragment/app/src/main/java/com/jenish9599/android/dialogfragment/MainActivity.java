package com.jenish9599.android.dialogfragment;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EditNameDialogFragment.EditnameDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showEditDialog();

    }


    private void showAlertDialog(){
        AlerDialogFragment alertDialog = AlerDialogFragment.newInstance("TITLE");
        alertDialog.show(getFragmentManager(),"Tag");
    }

    private void showEditDialog(){
        EditNameDialogFragment alertDialog = EditNameDialogFragment.newInstance("Some title");
        alertDialog.show(getFragmentManager(),"Tag");
    }

    @Override
    public void onFinishEditDialog(String inputtxt) {
        Toast.makeText(this, "Hi, " + inputtxt, Toast.LENGTH_SHORT).show();
    }
}
