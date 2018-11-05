package com.alexandr.demin.filestorage.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alexandr.demin.filestorage.R;
import com.alexandr.demin.filestorage.mvp.presenter.FileListFragmentPresenter;
import com.alexandr.demin.filestorage.mvp.view.FileListViewHolder;
import com.alexandr.demin.filestorage.utils.FileLabel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FileListAdapter extends RecyclerView.Adapter<FileListAdapter.ViewHolder> {

    private FileListFragmentPresenter.FileListPresenter presenter;

    public FileListAdapter(FileListFragmentPresenter.FileListPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.file_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        presenter.bindFileList(i, viewHolder);
    }

    @Override
    public int getItemCount() {
        return presenter.getFileCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements FileListViewHolder {

        @BindView(R.id.file_item_file)
        RelativeLayout fileLayout;
        @BindView(R.id.file_item_folder)
        RelativeLayout folderLayout;
        @BindView(R.id.file_item_name)
        TextView fileName;
        @BindView(R.id.file_item_folder_folders_count)
        TextView foldersCount;
        @BindView(R.id.file_item_folder_files_count)
        TextView filesCount;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void setName(String name) {
            fileName.setText(name);
        }

        @Override
        public void setLabel(FileLabel label) {
            if (label == FileLabel.FOLDER) {
                fileLayout.setVisibility(View.GONE);
                folderLayout.setVisibility(View.VISIBLE);
            } else {
                fileLayout.setVisibility(View.VISIBLE);
                folderLayout.setVisibility(View.GONE);
            }
        }

        @Override
        public void setFiles(int count) {
            filesCount.setText(count);
        }

        @Override
        public void setFolders(int count) {
            foldersCount.setText(count);
        }

        @Override
        public void setData(long data) {

        }
    }

}
