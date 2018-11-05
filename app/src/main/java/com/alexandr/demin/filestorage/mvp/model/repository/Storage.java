package com.alexandr.demin.filestorage.mvp.model.repository;

import io.reactivex.Completable;

public class Storage {

    LocalRepository localRepo;
    RemoteRepository remoteRepo;

    public Storage(LocalRepository localRepo, RemoteRepository remoteRepo) {
        this.localRepo = localRepo;
        this.remoteRepo = remoteRepo;
    }


    public Completable synchronize() {
        return Completable.create(emitter -> {
            this.initRootFolder();
        });
    }

    private void initRootFolder() {
        this.localRepo.initUserStorage();
    }

    public LocalRepository getLocalRepo() {
        return localRepo;
    }

    public void setLocalRepo(LocalRepository localRepo) {
        this.localRepo = localRepo;
    }

    public RemoteRepository getRemoteRepo() {
        return remoteRepo;
    }

    public void setRemoteRepo(RemoteRepository remoteRepo) {
        this.remoteRepo = remoteRepo;
    }

}
