package com.example.logonpf.bancoonline;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    private ListView lstMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstMenu = (ListView) findViewById(R.id.menu);
        lstMenu.setOnItemClickListener(this);
        mostrarCC();
    }

    public void contaCorrente(View v) {

        mostrarCC();

    }

    public void aplicacao(View v) {

        mostrarAplicacao();

    }

    private void mostrarCC() {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.frame, new ContaCorrentFragment());
        t.commit();

    }

    private void mostrarAplicacao() {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.frame, new AplicacaoFragment());
        t.commit();

    }

    @Override
    public void onItemClick(AdapterView<?> parent,
                            View view, int position, long id) {

        // fecha o menu lateral automaticamente
        ((DrawerLayout)findViewById(R.id.activity_main)).closeDrawer(lstMenu);

        // conta corrente
        if (position == 0) {
            mostrarCC();
        } else if (position == 1) {
            mostrarAplicacao();
        } else {
            finish();
        }

    }
}
