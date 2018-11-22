package br.com.flmwg.provadeliver.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.flmwg.provadeliver.R;
import br.com.flmwg.provadeliver.ui.characters.CharactersActivity;
import br.com.flmwg.provadeliver.ui.subset.SubsetActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTestOne;
    private Button btnTestTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        components();

        btnTestOne.setOnClickListener(this);
        btnTestTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_teste1:
                Intent itSub = new Intent(this, SubsetActivity.class);
                startActivity(itSub);
                break;

            case R.id.button_teste2:
                Intent itChar = new Intent(this, CharactersActivity.class);
                startActivity(itChar);
                break;
        }
    }

    private void components() {
        btnTestOne = findViewById(R.id.button_teste1);
        btnTestTwo = findViewById(R.id.button_teste2);
    }
}
