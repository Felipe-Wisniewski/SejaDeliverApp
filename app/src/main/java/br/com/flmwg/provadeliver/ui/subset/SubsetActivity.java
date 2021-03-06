package br.com.flmwg.provadeliver.ui.subset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.flmwg.provadeliver.R;
import br.com.flmwg.provadeliver.model.Subset;

/**
 * UI do teste do subconjunto da máxima soma, entrada de dados e saída do resultado.
 * @author Felipe Wisniewski
 */
public class SubsetActivity extends AppCompatActivity
        implements View.OnClickListener, SubsetContract.View {

    private TextView textInput;
    private TextView textOutput;
    private EditText edtNumber;
    private Button btnAdd;
    private Button btnSum;

    ArrayList<Integer> setNumbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subset);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadComponents();

        btnAdd.setOnClickListener(this);
        btnSum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:
                try {
                    int number = Integer.valueOf(edtNumber.getText().toString());
                    setNumbers.add(number);
                }catch (NumberFormatException e) {
                    alert(getResources().getString(R.string.error_number_format));
                    Log.e("Err", "NumberFormatException" + e);
                }
                edtNumber.setText("");
                textInput.setText(setNumbers.toString());
                break;

            case R.id.button_sum:
                SubsetPresenter mPresenter = new SubsetPresenter(this, setNumbers);
                mPresenter.getSubset();
                setNumbers.clear();
                break;
        }
    }

    @Override
    public void showSubset(ArrayList<String> subset) {
        textOutput.setText(subset.toString());
    }

    private void loadComponents() {
        textInput = findViewById(R.id.text_input_subset);
        textOutput = findViewById(R.id.text_output_subset);
        edtNumber = findViewById(R.id.edt_input_number);
        btnAdd = findViewById(R.id.button_add);
        btnSum = findViewById(R.id.button_sum);
    }

    private void alert(String msg) {
        Toast.makeText(SubsetActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
