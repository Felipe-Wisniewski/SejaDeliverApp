package br.com.flmwg.provadeliver.ui.subset;

import java.util.ArrayList;

import br.com.flmwg.provadeliver.model.Subset;

public class SubsetPresenter implements SubsetContract.Presenter {

    private SubsetContract.View view;
    private Subset subset;

    public SubsetPresenter(SubsetContract.View view, Subset subset) {
        this.view = view;
        this.subset = subset;
    }

    @Override
    public void getSubset() {
        ArrayList<String> resultSubset = subset.subsetMaxSum();
        view.showSubset(resultSubset);
    }
}
