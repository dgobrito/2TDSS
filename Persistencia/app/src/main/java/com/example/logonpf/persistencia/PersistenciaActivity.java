package com.example.logonpf.persistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class PersistenciaActivity extends AppCompatActivity {

    private BibliotecaDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistencia);
        db = OpenHelperManager.getHelper(this, BibliotecaDB.class);
    }

    public void carregar(View v) {

        LivroBean l1 = new LivroBean();
        l1.setAutor("Pedro");
        l1.setTitulo("A vida de Pedro");

        LivroBean l2 = new LivroBean();
        l2.setAutor("Maria");
        l2.setTitulo("A vida de Maria");

        try {

            Dao<LivroBean, Integer> dao = db.getDao(LivroBean.class);
            dao.create(l1);
            dao.create(l2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ler(View v) {

        try {

            Dao<LivroBean, Integer> dao = db.getDao(LivroBean.class);

            List<LivroBean> livros = dao.queryForAll();
            for (LivroBean livro:livros) {
                Toast.makeText(this, "Titulo: " + livro.getTitulo(),
                        Toast.LENGTH_SHORT).show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
