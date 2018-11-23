package br.com.flmwg.provadeliver.ui.characters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.flmwg.provadeliver.R;
import br.com.flmwg.provadeliver.model.Characters;
import br.com.flmwg.provadeliver.ui.subset.SubsetActivity;

/**
 * UI do teste da sequência de caracteres que mais aparecem, entrada de dados e saída do resultado.
 * @author Felipe Wisniewski
 */
public class CharactersActivity extends AppCompatActivity
        implements View.OnClickListener, CharactersContract.View {

    private TextView textInput;
    private TextView textOutput;
    private EditText edtWord;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadComponents();

        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_search:
                String word = edtWord.getText().toString();

                if (word.length() >= 2 || !word.equals("")) {
                    textInput.setText(word);
                    CharactersPresenter mPresenter = new CharactersPresenter(this, word);
                    mPresenter.getCharacters();
                }else {
                    alert(getResources().getString(R.string.error_word_format));
                }

                edtWord.setText("");
                break;
        }
    }

    @Override
    public void showCharacters(String characters) {
        textOutput.setText(characters);
    }

    private void loadComponents() {
        textInput = findViewById(R.id.text_input_word);
        textOutput = findViewById(R.id.text_output_characters);
        edtWord = findViewById(R.id.edt_input_word);
        btnSearch = findViewById(R.id.button_search);
    }

    private void alert(String msg) {
        Toast.makeText(CharactersActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
