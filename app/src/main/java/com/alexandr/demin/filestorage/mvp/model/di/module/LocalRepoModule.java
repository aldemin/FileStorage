package com.alexandr.demin.filestorage.mvp.model.di.module;

import com.alexandr.demin.filestorage.mvp.model.repository.LocalRepository;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class LocalRepoModule {

    @Singleton
    @Provides
    public LocalRepository localRepository(@Named("rootFile")File root) {
        return new LocalRepository(root);
    }

}
