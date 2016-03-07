package com.tinynote.seredasv.views.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tinynote.seredasv.R;
import com.tinynote.seredasv.models.categories.CategoriesModel;

import java.util.LinkedList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private LinkedList<CategoriesModel> categories;

    public CategoriesAdapter(LinkedList<CategoriesModel> categories) {
        this.categories = categories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (categories != null) {
            return categories.size();
        }
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private LinearLayout llColor;
        private TextView tvContent, tvCount;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            llColor = (LinearLayout) itemView.findViewById(R.id.ll_color);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            tvCount = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }
}
