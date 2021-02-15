package com.razaacademy.whatsapp.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.chatHolder> {
    ImageView imageView;

    @NonNull
    @Override
    public chatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull chatHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class chatHolder extends RecyclerView.ViewHolder {
        public chatHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
