package esensato.clickcall;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spAlimentos;
    private EditText edtQuantidade;
    private TextView txtTotalCalorias;

    private List<AlimentoBean> alimentos;
    private ArrayAdapter<AlimentoBean> adpAlimentos;
    private AlimentoBean alimentoSelecionado;
    private int totalCalorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spAlimentos = (Spinner) findViewById(R.id.spAlimento);
        spAlimentos.setOnItemSelectedListener(this);
        edtQuantidade = (EditText) findViewById(R.id.edtQuantidade);
        txtTotalCalorias = (TextView) findViewById(R.id.txtTotal);
        txtTotalCalorias.setText("0");
        txtTotalCalorias.setTextColor(Color.GREEN);

        criarAlimentos();
        popularSpinner();


    }

    private void popularSpinner() {

        adpAlimentos = new ArrayAdapter<AlimentoBean>(this, android.R.layout.simple_spinner_item, alimentos);
        spAlimentos.setAdapter(adpAlimentos);

    }

    private void criarAlimentos() {

        alimentos = new ArrayList<AlimentoBean>();
        alimentos.add(new AlimentoBean("Chocolate", 100));
        alimentos.add(new AlimentoBean("Pão", 80));
        alimentos.add(new AlimentoBean("Leite Light", 50));
        alimentos.add(new AlimentoBean("Alface", 10));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        this.alimentoSelecionado = (AlimentoBean) parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void registrar(View v){

        atualizarCalorias();
        edtQuantidade.setText("");
    }

    private void atualizarCalorias() {

        totalCalorias += alimentoSelecionado.getCalorias();
        txtTotalCalorias.setText(String.valueOf(totalCalorias));

        if (totalCalorias < 300)
            txtTotalCalorias.setTextColor(Color.GREEN);
        else if (totalCalorias >= 300 && totalCalorias <= 600)
            txtTotalCalorias.setTextColor(Color.YELLOW);
        else txtTotalCalorias.setTextColor(Color.RED);

    }
}
