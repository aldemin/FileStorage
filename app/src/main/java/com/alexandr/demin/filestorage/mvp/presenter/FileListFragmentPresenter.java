package com.alexandr.demin.filestorage.mvp.presenter;

import com.alexandr.demin.filestorage.App;
import com.alexandr.demin.filestorage.mvp.model.repository.Storage;
import com.alexandr.demin.filestorage.mvp.view.FileListFragmentView;
import com.alexandr.demin.filestorage.mvp.view.FileListViewHolder;
import com.alexandr.demin.filestorage.utils.FileLabel;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class FileListFragmentPresenter extends MvpPresenter<FileListFragmentView> {

    @Inject
    Router router;
    @Inject
    Storage storage;

    private FileListPresenter fileListPresenter = new FileListPresenter();
    private List<File> fileList = new ArrayList<>();
    private int fileHashCode;
    private boolean isRoot;

    public FileListFragmentPresenter(int fileHashCode) {
        this.fileHashCode = fileHashCode;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        App.getApp().getAppComponent().inject(FileListFragmentPresenter.this);
        initFileList();
        initToolbar();
        getViewState().updateList();
    }

    public void initToolbar() {
        if (isRoot) {
            getViewState().setRootToolbar();
        } else {
            getViewState().setToolbar("title");
        }
    }

    public void initFileList() {
        File root = this.storage.getLocalRepo().getStorage();
        if (root.hashCode() == this.fileHashCode || this.fileHashCode == 0) {
            this.fileList = fileToList(root);
            this.isRoot = true;
        } else {
            this.isRoot = false;
            this.fileList = find(root, fileHashCode);
        }
    }

    public List<File> find(File folder ,int fileHashCode) {
        List<File> files = fileToList(folder);
        for (File file : files) {
            if (file.isDirectory()) {
                if (file.hashCode() == fileHashCode) {
                    return fileToList(file);
                } else {
                    find(file, fileHashCode);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<File> fileToList(File folder) {
        if (folder.isFile()) {
            throw new RuntimeException("This is not a folder");
        }
        return Arrays.asList(folder.listFiles());
    }

    public FileListPresenter getFileListPresenter() {
        return fileListPresenter;
    }

    public void fabPressed() {
        getViewState().showFileDialog();
    }

    public class FileListPresenter{

        public void bindFileList(int position, FileListViewHolder view) {
            if (fileList != null) {
                File file = fileList.get(position);
                if (file != null) {
                    view.setName(file.getName());
                    if (file.isDirectory()) {
                        view.setLabel(FileLabel.FOLDER);
                    } else {
                        view.setLabel(FileLabel.FILE);
                    }
                }
            }
        }

        public int getFileCount() {
            return fileList.size();
        }
    }
}
