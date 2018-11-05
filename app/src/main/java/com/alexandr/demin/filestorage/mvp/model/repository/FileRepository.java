package com.alexandr.demin.filestorage.mvp.model.repository;

import java.util.List;

import javax.jcr.RepositoryException;

public interface FileRepository<T> {

    List<T> getFoldersList(T folder) throws RepositoryException;
    List<T> getFilesList(T folder) throws RepositoryException;
    T getStorage() throws RepositoryException;
    void createFile(String name, T folder) throws RepositoryException;
    void deleteFile(T file) throws RepositoryException;
    void createFolder(String name, T folder) throws RepositoryException;
    void deleteFolder(T folder) throws RepositoryException;
    void writeData(T file, byte[] data) throws RepositoryException;
    byte[] readData(T file);

}
