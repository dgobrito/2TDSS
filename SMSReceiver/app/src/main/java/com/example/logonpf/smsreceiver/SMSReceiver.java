package com.example.logonpf.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String str = "";
        SmsMessage[] smsMessages =
                Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage message : smsMessages) {

            str += "De: " + message.getOriginatingAddress();
            str += " Msg: ";
            str += message.getMessageBody();
            str += "\n";

        }

        Intent i = new Intent(context, SMSActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("mensagem", str);
        context.startActivity(i);
    }
}
