package com.alexandr.demin.filestorage.mvp.model.di.module;

import com.alexandr.demin.filestorage.Server;
import com.alexandr.demin.filestorage.mvp.model.repository.RemoteRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class RemoteRepoModule {

    @Singleton
    @Provides
    public RemoteRepository remoteRepository(Server server) {
        return new RemoteRepository(server);
    }

}
