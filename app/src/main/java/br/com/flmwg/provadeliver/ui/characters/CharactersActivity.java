package br.com.flmwg.provadeliver.ui.characters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.flmwg.provadeliver.R;
import br.com.flmwg.provadeliver.model.Characters;
import br.com.flmwg.provadeliver.ui.characters.CharactersContract;

public class CharactersActivity extends AppCompatActivity implements CharactersContract.View,
        View.OnClickListener {

    private CharactersPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);



//        presenter = new CharactersPresenter(this, Characters());
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showCharacters(ArrayList<String> subset) {

    }
}
