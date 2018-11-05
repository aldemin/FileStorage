package com.alexandr.demin.filestorage.mvp.presenter;

import com.alexandr.demin.filestorage.App;
import com.alexandr.demin.filestorage.mvp.model.repository.Storage;
import com.alexandr.demin.filestorage.mvp.view.MainActivityView;
import com.alexandr.demin.filestorage.ui.Screens;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {

    @Inject
    Router router;
    @Inject
    Storage storage;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        App.getApp().getAppComponent().inject(MainActivityPresenter.this);
        //todo
        router.replaceScreen(new Screens.FileListScreen(0));
    }

    public void backPressed() {
        router.exit();
    }
}
