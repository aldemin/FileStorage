package com.alexandr.demin.filestorage.mvp.model.di.module;

import com.alexandr.demin.filestorage.mvp.model.repository.LocalRepository;
import com.alexandr.demin.filestorage.mvp.model.repository.RemoteRepository;
import com.alexandr.demin.filestorage.mvp.model.repository.Storage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        LocalRepoModule.class,
        RemoteRepoModule.class
})
@Singleton
public class StorageModule {

    @Provides
    @Singleton
    public Storage storage(LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new Storage(localRepository, remoteRepository);
    }

}
