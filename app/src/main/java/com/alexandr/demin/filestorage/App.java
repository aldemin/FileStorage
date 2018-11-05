package com.alexandr.demin.filestorage;

import android.app.Application;

import com.alexandr.demin.filestorage.mvp.model.di.AppComponent;
import com.alexandr.demin.filestorage.mvp.model.di.DaggerAppComponent;
import com.alexandr.demin.filestorage.mvp.model.di.module.AppModule;

public class App extends Application {

    private static App app;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();
    }

    public static App getApp() {
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
