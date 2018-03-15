package com.room.gopi;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dagger.gopi.daggergopi.R;

public class ItemStudentAdapter extends RecyclerView.Adapter<ItemStudentAdapter.ViewHolder> {

    private List<StudentEntity> list = new ArrayList<>();

    public ItemStudentAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        StudentEntity item = list.get(position);
        holder.stdName.setText(item.name);
        holder.stdAge.setText(item.age + "");
        holder.stdMarks.setText(item.marks + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateData(List<StudentEntity> newDataList) {
        if(newDataList == null || newDataList.isEmpty()) return;
        list.clear();
        list.addAll(newDataList);
        notifyDataSetChanged();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stdName;
        private TextView stdAge;
        private TextView stdMarks;

        public ViewHolder(View view) {
            super(view);
            stdName = (TextView) view.findViewById(R.id.std_name);
            stdAge = (TextView) view.findViewById(R.id.std_age);
            stdMarks = (TextView) view.findViewById(R.id.std_marks);
        }
    }
}
