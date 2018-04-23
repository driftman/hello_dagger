package net.atos.cedre.ui.base;

/**
 * Created by abk on 29/03/2018.
 */

public class BasePresenter <V extends BaseContract.IMvpView> implements BaseContract.IMvpPresenter<V> {

    private V view;

    public BasePresenter() {

    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void onViewInitialized() {

    }


}
