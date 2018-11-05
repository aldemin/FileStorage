package com.alexandr.demin.filestorage.mvp.view;

import com.alexandr.demin.filestorage.utils.FileLabel;

public interface FileListViewHolder {
    void setName(String name);
    void setLabel(FileLabel label);
    void setFiles(int count);
    void setFolders(int count);
    void setData(long data);
}
