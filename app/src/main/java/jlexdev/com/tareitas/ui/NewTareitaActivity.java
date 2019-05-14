package jlexdev.com.tareitas.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jlexdev.com.tareitas.R;

public class NewTareitaActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "jlexdev.com.tareitas.ui.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "jlexdev.com.tareitas.ui.EXTRA_DESCRIPTION";

    private EditText etNewTitle;
    private EditText etNewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tareita);

        // Fields
        etNewTitle = findViewById(R.id.et_new_title);
        etNewDescription = findViewById(R.id.et_new_description);

        // Save
        final Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                if (TextUtils.isEmpty(etNewTitle.getText())) {
                    setResult(RESULT_CANCELED, intent);
                } else {
                    String title = etNewTitle.getText().toString();
                    String description = etNewDescription.getText().toString();

                    intent.putExtra(EXTRA_TITLE, title);
                    intent.putExtra(EXTRA_DESCRIPTION, description);

                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });

    }

}
