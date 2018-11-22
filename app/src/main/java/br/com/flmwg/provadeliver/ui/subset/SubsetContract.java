package br.com.flmwg.provadeliver.ui.subset;

import java.util.ArrayList;

public interface SubsetContract {

    interface View {
        void showSubset(ArrayList<String> subset);
    }

    interface Presenter {
        void getSubset();
    }
}
