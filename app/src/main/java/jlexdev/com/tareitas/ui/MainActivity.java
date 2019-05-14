package jlexdev.com.tareitas.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import jlexdev.com.tareitas.R;
import jlexdev.com.tareitas.db.entity.Tareita;
import jlexdev.com.tareitas.viewmodel.TareitaViewModel;

public class MainActivity extends AppCompatActivity {

    private static final int NEW_TAREITA_ACTIVITY_REQUEST_CODE = 1;
    private TareitaViewModel tareitaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TareitaAdapter adapter = new TareitaAdapter(this);
        recyclerView.setAdapter(adapter);

        // ViewModel
        tareitaViewModel = ViewModelProviders.of(this).get(TareitaViewModel.class);
        tareitaViewModel.getAllTareitas().observe(this, new Observer<List<Tareita>>() {
            @Override
            public void onChanged(@Nullable List<Tareita> tareitas) {
                adapter.setTareitas(tareitas);
            }
        });

        // Fab
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NewTareitaActivity.class);
                startActivityForResult(intent, NEW_TAREITA_ACTIVITY_REQUEST_CODE);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_TAREITA_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String title = data.getStringExtra(NewTareitaActivity.EXTRA_TITLE);
            String description = data.getStringExtra(NewTareitaActivity.EXTRA_DESCRIPTION);

            Tareita tareita = new Tareita(title, description);
            tareitaViewModel.insert(tareita);

            Toast.makeText(this, R.string.tareita_saved, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.tareita_not_saved, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
