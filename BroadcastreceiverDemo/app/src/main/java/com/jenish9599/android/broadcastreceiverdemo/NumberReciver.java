package com.jenish9599.android.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.YuvImage;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by jenishpatel on 08/12/17.
 */

public class NumberReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        String state  = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        Toast.makeText(context, state,Toast.LENGTH_SHORT).show();
        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();


            Toast.makeText(context,number,Toast.LENGTH_SHORT).show();
            dbHelper.saveNumber(number,sqLiteDatabase);


            dbHelper.close();
        }


        Intent intent1 = new Intent(DbContract.UPDATE_UI_FILTER);
        context.sendBroadcast(intent1);

    }
}
