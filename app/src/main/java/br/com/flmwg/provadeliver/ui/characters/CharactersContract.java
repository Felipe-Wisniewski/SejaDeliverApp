package br.com.flmwg.provadeliver.ui.characters;

import java.util.ArrayList;

public interface CharactersContract {

    interface View {
        void showCharacters(ArrayList<String> subset);
    }

    interface Presenter {
        void getCharacteres();
    }
}
