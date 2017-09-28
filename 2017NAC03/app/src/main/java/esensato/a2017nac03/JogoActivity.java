package esensato.a2017nac03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class JogoActivity extends AppCompatActivity {

    private EditText edtCor;
    private String mensagem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        edtCor = (EditText) findViewById(R.id.edtCor);

    }

    public void conferir(View v) {

        if (Jogo.fim()) {

            mensagem = "Tentativas esgotadas!";
            finish();

        } else {


            String corUsuario = edtCor.getText().toString();
            if (corUsuario.equalsIgnoreCase(Jogo.corSorteada())) {

                mensagem = "Cor certa!";
                finish();

            } else {
                Toast.makeText(this, "Tente novamente!", Toast.LENGTH_SHORT).show();
            }

        }


    }

    @Override
    public void finish() {
        Intent s = new Intent(this, JogoService.class);
        stopService(s);
        Intent r = new Intent();
        r.putExtra("resultado", mensagem);
        setResult(RESULT_OK, r);
        super.finish();
    }
}
