package br.com.flmwg.provadeliver.ui.subset;

import java.util.ArrayList;

/**
 * Contrato das classes View(SubsetActivity) e Presenter(SubsetPresenter).
 * @author Felipe Wisniewski
 */
public interface SubsetContract {

    interface View {
        void showSubset(ArrayList<String> subset);
    }

    interface Presenter {
        void getSubset();
    }
}
