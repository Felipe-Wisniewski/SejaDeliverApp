package br.com.flmwg.provadeliver.ui.characters;

import br.com.flmwg.provadeliver.model.Characters;

/**
 * Classe responsável pela comunicação entre View(CharactersActivity) e Model(Characters).
 * @author Felipe Wisniewski
 */
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
