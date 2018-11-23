package br.com.flmwg.provadeliver.ui.characters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.flmwg.provadeliver.R;
import br.com.flmwg.provadeliver.model.Characters;

public class CharactersActivity extends AppCompatActivity
        implements View.OnClickListener, CharactersContract.View {

    private TextView textInput;
    private TextView textOutput;
    private EditText edtWord;
    private Button btnSearch;

    private Characters mCharacters;
    private CharactersPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        loadComponents();

        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_search:
                String word = edtWord.getText().toString();
                textInput.setText(word);

                if (word.length() >= 2) {
                    mCharacters = new Characters(word);
                    mPresenter = new CharactersPresenter(this, mCharacters);
                    mPresenter.getCharacters();
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
}
