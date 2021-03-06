package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.details.DeviationDetailsActivity_;
import br.com.bloder.helloworld_bloder_verisoft.preferences.UiModePrefs_;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

public class DeviationListAdapter extends RecyclerView.Adapter<DeviationListAdapter.InternalViewHolder> {

    private List<Deviation> deviationList;
    private final Context context;
    private final UiModePrefs_ prefs;

    public DeviationListAdapter(List<Deviation> deviations, Context context, UiModePrefs_ prefs){
        this.deviationList = deviations;
        this.context = context;
        this.prefs = prefs;
    }

    @Override
    public int getItemViewType(int position) {
        return UI_MODE.current(prefs).ordinal();
    }

    @Override
    public InternalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InternalViewHolder();
    }

    @Override
    public void onBindViewHolder(InternalViewHolder holder, final int position) {
        holder.bind(deviationList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviationDetailsActivity_.intent(context)
                        .userName(deviationList.get(position).authorName)
                        .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .userUrlImage(deviationList.get(position).authorImageUrl)
                        .deviationImageUrl(deviationList.get(position).imageUrl)
                        .deviationName(deviationList.get(position).title)
                        .start();
            }
        });
    }

    public void addNewDeviations(List<Deviation> deviations) {
        int oldSize = deviationList.size();
        deviationList.addAll(deviations);
        this.notifyItemRangeInserted(oldSize, deviationList.size());
    }

    @Override
    public int getItemCount() {
        return deviationList.size();
    }

    public class InternalViewHolder extends RecyclerView.ViewHolder{

        public InternalViewHolder() {
            super(UI_MODE.current(prefs) == UI_MODE.SIMPLE ? DeviationViewHolder_.build(context) : DeviationOneColumnViewHolder_.build(context));
        }

        public void bind(Deviation deviation){
            if(UI_MODE.current(prefs) == UI_MODE.SIMPLE) {
                ((DeviationViewHolder) this.itemView).bind(deviation);
            } else {
                ((DeviationOneColumnViewHolder) this.itemView).bind(deviation);
            }
        }
    }
}
