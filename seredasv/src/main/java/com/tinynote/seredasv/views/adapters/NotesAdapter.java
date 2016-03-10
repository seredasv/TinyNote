package com.tinynote.seredasv.views.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tinynote.seredasv.R;
import com.tinynote.seredasv.models.notes.NotesModel;

import java.util.Date;
import java.util.LinkedList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private static final int TEXT_LENGTH = 80;

    private Context context;
    private LinkedList<NotesModel> list;

    public NotesAdapter(Context context, LinkedList<NotesModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NotesModel item = list.get(position);
        holder.llColor.setBackgroundColor(Color.parseColor(item.getCategory().getColor()));

        Date date = item.getDate();
        holder.tvWeekDay.setText(String.valueOf(date.getDay()));
        holder.tvDate.setText(String.valueOf(date.getDate()));
        holder.tvTime.setText(String.valueOf(date.getHours()) + ":" + String.valueOf(date.getMinutes()));

        holder.tvTitle.setText(item.getTitle());
        holder.tvContent.setText(item.getContent().substring(0, TEXT_LENGTH));

        if (item.getCategory().getName() != null && item.getCategory().getName().length() > 0) {
            holder.llCategory.setVisibility(View.VISIBLE);
            holder.tvCategory.setText(item.getCategory().getName());
        } else {
            holder.llCategory.setVisibility(View.GONE);
        }

        if (item.getTags() != null && item.getTags().size() > 0) {
            holder.llTag.setVisibility(View.VISIBLE);
            holder.tvTag.setText(String.valueOf(item.getTags().size()));
        } else {
            holder.llTag.setVisibility(View.GONE);
        }

        if (item.getLocation().getName() != null && item.getLocation().getName().length() > 0) {
            holder.llLocation.setVisibility(View.VISIBLE);
            holder.tvLocation.setText(item.getLocation().getName());
        } else {
            holder.llLocation.setVisibility(View.GONE);
        }
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
        private LinearLayout llColor, llCategory, llTag, llLocation;
        private TextView tvWeekDay, tvDate, tvTime, tvTitle, tvContent, tvCategory, tvTag, tvLocation;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);

            llColor = (LinearLayout) itemView.findViewById(R.id.ll_color);
            llCategory = (LinearLayout) itemView.findViewById(R.id.ll_category);
            llTag = (LinearLayout) itemView.findViewById(R.id.ll_tag);
            llLocation = (LinearLayout) itemView.findViewById(R.id.ll_location);

            tvWeekDay = (TextView) itemView.findViewById(R.id.tv_week_day);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
            tvTag = (TextView) itemView.findViewById(R.id.tv_tag);
            tvLocation = (TextView) itemView.findViewById(R.id.tv_location);
        }
    }
}
