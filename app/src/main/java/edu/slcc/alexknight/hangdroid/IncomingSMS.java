package edu.slcc.alexknight.hangdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class IncomingSMS extends BroadcastReceiver {
    public IncomingSMS() {
    }

    final SmsManager sms = SmsManager.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();

        try {
            if (bundle != null) {
                Log.d("MYLOG", "Bundle: " + bundle);

                final Object[] pdus = (Object[]) bundle.get("pdus");

                String format = bundle.getString("format");

                for (Object pdu:pdus) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdu, format);

                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String message = currentMessage.getDisplayMessageBody();

                    Log.d("MYLOG", "phone: " + phoneNumber + "; message: " + message);

                    Toast.makeText(context, "Text Received from " + phoneNumber, Toast.LENGTH_LONG).show();

                    SharedPreferences preferences = context.getSharedPreferences("TEXT_MSGS", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = preferences.edit();

                    Log.d("MYLOG", "TextedWord: " + message);
                    editor.putString("TextedWord", message);
                    editor.putString("TexterPhone", phoneNumber);

                    editor.commit();
                }
            }
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);
        }
    }
}
