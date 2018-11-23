package br.com.flmwg.provadeliver.ui.subset;

import java.util.ArrayList;

import br.com.flmwg.provadeliver.model.Subset;

/**
 * Classe responsável pela comunicação entre View(SubsetActivity) e Model(Subset).
 * @author Felipe Wisniewski
 */
public class SubsetPresenter implements SubsetContract.Presenter {

    private SubsetContract.View view;
    private Subset subset;

    public SubsetPresenter(SubsetContract.View view, ArrayList<Integer> setNumbers) {
        this.view = view;
        this.subset = new Subset(setNumbers);
    }

    @Override
    public void getSubset() {
        ArrayList<String> resultSubset = subset.subsetMaxSum();
        view.showSubset(resultSubset);
    }
}
