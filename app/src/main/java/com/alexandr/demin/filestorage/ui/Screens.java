package com.alexandr.demin.filestorage.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alexandr.demin.filestorage.ui.fragment.FileListFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static final class FileListScreen extends SupportAppScreen {

        private Bundle bundle = new Bundle();

        public FileListScreen(int fileHashCode) {
            //todo
            this.bundle.putInt("file", fileHashCode);
        }

        @Override
        public Fragment getFragment() {
            return FileListFragment.newInstance(bundle);
        }
    }

}
