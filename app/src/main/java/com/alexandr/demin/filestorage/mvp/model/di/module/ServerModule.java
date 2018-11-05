package com.alexandr.demin.filestorage.mvp.model.di.module;

import com.alexandr.demin.filestorage.Server;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class ServerModule {

    @Provides
    @Singleton
    public Server server(@Named("url") String url) {
        return new Server(url);
    }
}
