package com.alexandr.demin.filestorage.mvp.model.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalRepository implements FileRepository<File> {

    public static final String USER_STORAGE_NAME = "MyStorage";

    private final File root;
    private File userStorage;

    public LocalRepository(File root) {
        this.root = root;
    }

    public void initUserStorage() {
        String path = this.root + File.separator + USER_STORAGE_NAME;
        userStorage = new File(path);
        if (!userStorage.exists()) {
            userStorage.mkdir();
        }
    }

    @Override
    public List<File> getFoldersList(File folder) {
        File[] files = folder.listFiles();
        ArrayList<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    @Override
    public List<File> getFilesList(File folder) {
        File[] files = folder.listFiles();
        ArrayList<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file.isFile()) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    @Override
    public File getStorage() {
        return root;
    }

    @Override
    public void createFile(String name, File folder) {
        String path = folder + File.separator + USER_STORAGE_NAME;
        File file = new File(path);
        if (!file.exists()) {
            // TODO: 28.10.2018
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteFile(File file) {
        file.delete();
    }

    @Override
    public void createFolder(String name, File folder) {
        String fullPath = folder + File.separator + name;
        File file = new File(fullPath);
        file.mkdirs();
    }

    @Override
    public void deleteFolder(File folder) {
        folder.delete();
    }

    @Override
    public void writeData(File file, byte[] data) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] readData(File file) {
        return new byte[0];
    }
}
