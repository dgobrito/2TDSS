package esensato.a2017nac03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtTentativas;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTentativas = (EditText) findViewById(R.id.edtTentativas);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
    }

    public void iniciar(View v) {

        Intent s = new Intent(this, JogoService.class);
        s.putExtra("tentativas", Integer.parseInt(edtTentativas.getText().toString()));
        startService(s);

        Intent a = new Intent(this, JogoActivity.class);
        startActivityForResult(a, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i("MAIN", "TERMINADO");
        String resultado = data.getExtras().getString("resultado");
        txtResultado.setText(resultado);

    }
}
