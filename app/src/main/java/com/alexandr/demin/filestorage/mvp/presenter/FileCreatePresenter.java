package com.alexandr.demin.filestorage.mvp.presenter;

import com.alexandr.demin.filestorage.mvp.view.FileCreateView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class FileCreatePresenter extends MvpPresenter<FileCreateView> {

    private boolean isFile = true;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void fileBtnPressed() {
        isFile = true;
    }

    public void folderBtnPressed() {
        isFile = false;
    }

    public void createBtnPressed() {

    }

    public void cancelBtnPressed() {
        getViewState().cancelDialog();
    }
}
