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

public class SubsetActivity extends AppCompatActivity
        implements View.OnClickListener, SubsetContract.View {

    private TextView textInput;
    private TextView textOutput;
    private EditText edtNumber;
    private Button btnAdd;
    private Button btnSum;

    ArrayList<Integer> setNumbers = new ArrayList<>();

    Subset mSubset;
    SubsetPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subset);

        startComponents();

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
                    alert("Número inválido!");
                    Log.e("Err", "NumberFormatException" + e);
                }
                edtNumber.setText("");
                textInput.setText(setNumbers.toString());
                break;

            case R.id.button_sum:
                mSubset = new Subset(setNumbers);
                mPresenter = new SubsetPresenter(this, mSubset);
                mPresenter.getSubset();
                setNumbers.clear();
                break;
        }
    }

    @Override
    public void showSubset(ArrayList<String> subset) {
        textOutput.setText(subset.toString());
    }

    private void startComponents() {
        textInput = findViewById(R.id.text_input_subset);
        textOutput = findViewById(R.id.text_output_subset);
        edtNumber = findViewById(R.id.edt_input_numbers);
        btnAdd = findViewById(R.id.button_add);
        btnSum = findViewById(R.id.button_sum);
    }

    private void alert(String s) {
        Toast.makeText(SubsetActivity.this, s, Toast.LENGTH_LONG).show();
    }
}
