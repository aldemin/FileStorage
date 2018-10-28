package com.alexandr.demin.filestorage.mvp.model.repository;

import java.util.List;

public interface FileRepository<T> {

    List<T> getFoldersList(String path);
    List<T> getFilesList(String path);
    void createFile(String name, String path);
    void deleteFile(T file);
    void createFolder(String name, String path);
    void deleteFolder(T folder);
    void writeData(T file, byte[] data);
    byte[] readData(T file);

}
