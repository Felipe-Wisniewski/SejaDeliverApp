package br.com.flmwg.provadeliver.ui.characters;

import br.com.flmwg.provadeliver.model.Characters;

public class CharactersPresenter implements CharactersContract.Presenter {

    private CharactersContract.View view;
    private Characters characters;

    public CharactersPresenter(CharactersContract.View view, Characters characters) {
        this.view = view;
        this.characters = characters;
    }

    @Override
    public void getCharacters() {
        view.showCharacters(characters.getBiggerSequence());
    }
}
