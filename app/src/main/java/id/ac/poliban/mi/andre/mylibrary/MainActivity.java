package id.ac.poliban.mi.andre.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnStore, btnGetAll;
    private EditText etName;
    private DatabaseHelper databaseHelper;
    private TextView tvNames;
    private ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        tvNames = findViewById(R.id.tvNames);

        btnStore = findViewById(R.id.btnStore);
        btnGetAll = findViewById(R.id.btnGet);
        etName = findViewById(R.id.etName);

        btnStore.setOnClickListener(v -> {
            databaseHelper.addStudentDetail(etName.getText().toString());
            etName.setText("");
            Toast.makeText(this, "Stored Successfully!", Toast.LENGTH_LONG).show();
        });

        btnGetAll.setOnClickListener(v -> {
            arrayList = databaseHelper.getAllStudentsList();
            tvNames.setText("");
            for (int i = 0; i < arrayList.size(); i++){
                tvNames.setText(tvNames.getText().toString()+", "+arrayList.get(i));
            }
        });

    }
}
