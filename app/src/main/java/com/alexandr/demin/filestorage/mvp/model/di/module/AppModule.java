package com.alexandr.demin.filestorage.mvp.model.di.module;

import android.os.Environment;

import com.alexandr.demin.filestorage.App;
import com.alexandr.demin.filestorage.R;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    public App app() {
        return app;
    }

    @Provides
    @Named("rootFile")
    @Singleton
    public File rootPath() {
        return app.getExternalFilesDir(Environment.getRootDirectory().toString());
    }

    @Provides
    @Named("url")
    @Singleton
    public String hostUrl() {
        return app.getString(R.string.host_url);
    }

}
