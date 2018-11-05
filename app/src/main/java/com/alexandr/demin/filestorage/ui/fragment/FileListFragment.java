package com.alexandr.demin.filestorage.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexandr.demin.filestorage.R;
import com.alexandr.demin.filestorage.mvp.presenter.FileListFragmentPresenter;
import com.alexandr.demin.filestorage.mvp.view.FileListFragmentView;
import com.alexandr.demin.filestorage.ui.dialog.FileCreateDialog;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FileListFragment extends MvpAppCompatFragment implements FileListFragmentView {

    @InjectPresenter
    FileListFragmentPresenter presenter;

    @BindView(R.id.fr_file_list)
    RecyclerView fileList;
    @BindView(R.id.fr_file_list_fab)
    FloatingActionButton fab;
    @BindView(R.id.fr_file_toolbar)
    Toolbar toolbar;

    private FileListAdapter adapter;

    @ProvidePresenter
    public FileListFragmentPresenter fileListFragmentPresenter() {
        //todo key
        return new FileListFragmentPresenter(getArguments().getInt("file"));
    }

    public static FileListFragment newInstance(Bundle bundle) {
        FileListFragment fileListFragment = new FileListFragment();
        fileListFragment.setArguments(bundle);
        return fileListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file_list, container, false);
        ButterKnife.bind(this, view);
        inflateRecyclerView();
        return view;
    }

    private void inflateRecyclerView() {
        adapter = new FileListAdapter(presenter.getFileListPresenter());
        fileList.setAdapter(adapter);
        fileList.setLayoutManager(new LinearLayoutManager(getContext()));
        fileList.setItemAnimator(new DefaultItemAnimator());
    }

    @OnClick(R.id.fr_file_list_fab)
    public void fabPressed() {
        presenter.fabPressed();
    }

    @Override
    public void showFileDialog() {
        DialogFragment dialogFragment = new FileCreateDialog();
        dialogFragment.setCancelable(false);
        dialogFragment.show(getFragmentManager(),"dialog");
    }

    @Override
    public void setRootToolbar() {
        ((MvpAppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((MvpAppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    public void setToolbar(String title) {
        ((MvpAppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((MvpAppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        ((MvpAppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MvpAppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }
}
