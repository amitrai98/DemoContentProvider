package com.evon.amitrai.democontentprovider;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by amitrai on 5/10/17.
 * User for :-
 */

public class ProviderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProviderData> dataList;

    public ProviderAdapter(List<ProviderData> dataList){
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new MHolderView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MHolderView mHolderView = (MHolderView) holder;
        ProviderData data = dataList.get(position);
        if (data != null){
            if (data.getMessage() != null)
                mHolderView.tvItemContent.setText(data.getMessage());

            if (data.getTitle() != null)
                mHolderView.tvItemPlate.setText(data.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MHolderView extends RecyclerView.ViewHolder{

        TextView tvItemPlate, tvItemContent;
        public MHolderView(View itemView) {
            super(itemView);

            tvItemPlate = itemView.findViewById(R.id.tvItemPlate);
            tvItemContent = itemView.findViewById(R.id.tvItemContent);
        }
    }
}
