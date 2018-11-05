package com.alexandr.demin.filestorage.mvp.model.di;

import com.alexandr.demin.filestorage.mvp.model.di.module.AppModule;
import com.alexandr.demin.filestorage.mvp.model.di.module.NavigationModule;
import com.alexandr.demin.filestorage.mvp.model.di.module.ServerModule;
import com.alexandr.demin.filestorage.mvp.model.di.module.StorageModule;
import com.alexandr.demin.filestorage.mvp.presenter.FileListFragmentPresenter;
import com.alexandr.demin.filestorage.mvp.presenter.MainActivityPresenter;
import com.alexandr.demin.filestorage.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        StorageModule.class,
        NavigationModule.class,
        ServerModule.class
})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(MainActivityPresenter presenter);
    void inject(FileListFragmentPresenter presenter);
}
