package com.tinynote.seredasv.views.adapters;

import android.content.Context;
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
    private Context context;
    private LinkedList<CategoriesModel> list;

    public CategoriesAdapter(Context context, LinkedList<CategoriesModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoriesModel item = list.get(position);
        holder.llColor.setVisibility(View.VISIBLE);
        holder.llColor.setBackgroundColor(context.getResources().getColor(item.getColor()));
        holder.tvName.setText(item.getName());

        //TODO calc quantity
        holder.tvCount.setText("10");
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
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
        private TextView tvName, tvCount;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            llColor = (LinearLayout) itemView.findViewById(R.id.ll_color);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvCount = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }
}
