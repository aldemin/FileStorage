package com.alexandr.demin.filestorage.mvp.view;

import android.text.Editable;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface FileCreateView extends MvpView {
    void fileBtnPressed();
    void folderBtnPressed();
    void createBtnPressed();
    void cancelBtnPressed();
    void nameTextChanged(Editable s);
    void cancelDialog();
}
