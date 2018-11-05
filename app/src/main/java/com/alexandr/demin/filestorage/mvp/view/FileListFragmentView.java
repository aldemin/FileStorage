package com.alexandr.demin.filestorage.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface FileListFragmentView extends MvpView {
    void setRootToolbar();
    void setToolbar(String title);
    void updateList();
    void showFileDialog();
}
