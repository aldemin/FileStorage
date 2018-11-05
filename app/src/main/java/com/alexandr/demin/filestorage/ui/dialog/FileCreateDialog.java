package com.alexandr.demin.filestorage.ui.dialog;


import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alexandr.demin.filestorage.R;
import com.alexandr.demin.filestorage.mvp.presenter.FileCreatePresenter;
import com.alexandr.demin.filestorage.mvp.view.FileCreateView;
import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

import static butterknife.OnTextChanged.Callback.AFTER_TEXT_CHANGED;

public class FileCreateDialog extends MvpAppCompatDialogFragment implements FileCreateView {

    @InjectPresenter
    FileCreatePresenter presenter;

/*    @BindView(R.id.fr_file_dialog_btn_file)
    RadioButton fileBtn;
    @BindView(R.id.fr_file_dialog_btn_folder)
    RadioButton folderBtn;*/
    @BindView(R.id.fr_file_dialog_filename)
    EditText name;
    @BindView(R.id.fr_file_dialog_btn_cancel)
    Button cancelBtn;
    @BindView(R.id.fr_file_dialog_btn_create)
    Button createBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file_create_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.fr_file_dialog_btn_file)
    @Override
    public void fileBtnPressed() {
        presenter.fileBtnPressed();
    }

    @OnClick(R.id.fr_file_dialog_btn_folder)
    @Override
    public void folderBtnPressed() {
        presenter.folderBtnPressed();
    }

    @OnClick(R.id.fr_file_dialog_btn_create)
    @Override
    public void createBtnPressed() {
        presenter.createBtnPressed();
    }

    @OnClick(R.id.fr_file_dialog_btn_cancel)
    @Override
    public void cancelBtnPressed() {
        presenter.cancelBtnPressed();
    }

    @OnTextChanged(value = R.id.fr_file_dialog_filename, callback = AFTER_TEXT_CHANGED)
    @Override
    public void nameTextChanged(Editable s) {
        //todo
    }

    @Override
    public void cancelDialog() {
        getDialog().cancel();
    }
}
