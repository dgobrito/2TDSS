package com.example.logonpf.smsreceiver;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SMSActivity extends AppCompatActivity {

    private TextView txtMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECEIVE_SMS) !=
                PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 0);

        }

        txtMensagem = (TextView) findViewById(R.id.txtMensagem);

        Intent i = getIntent();
        if (i != null && i.getExtras() != null) {

            txtMensagem.setText(i.getExtras().getString("mensagem"));
        }


    }
}
