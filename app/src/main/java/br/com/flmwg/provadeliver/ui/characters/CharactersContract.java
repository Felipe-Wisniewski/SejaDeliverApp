package br.com.flmwg.provadeliver.ui.characters;

/**
 * Contrato das classes View(CharactersActivity) e Presenter(CharactersPresenter).
 * @author Felipe Wisniewski
 */
public interface CharactersContract {

    interface View {
        void showCharacters(String characters);
    }

    interface Presenter {
        void getCharacters();
    }
}
