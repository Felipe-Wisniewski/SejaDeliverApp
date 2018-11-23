package br.com.flmwg.provadeliver.ui.characters;

public interface CharactersContract {

    interface View {
        void showCharacters(String characters);
    }

    interface Presenter {
        void getCharacters();
    }
}
