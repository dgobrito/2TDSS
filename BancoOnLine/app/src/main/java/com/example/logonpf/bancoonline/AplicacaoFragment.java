package com.example.logonpf.bancoonline;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AplicacaoFragment
        extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // v = tela do fragment
        View v = inflater.inflate(R.layout.fragment_aplicacao,
                container, false);

        v.findViewById(R.id.btnAplicar).setOnClickListener(this);
        v.findViewById(R.id.btnResgatar).setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAplicar) {
            Log.i("EVENTO", "Gerou evento: APLICACAO!!!!");
        } else if (v.getId() == R.id.btnResgatar) {
            Log.i("EVENTO", "Gerou evento: RESGATE!!!!");
        }
    }
}
