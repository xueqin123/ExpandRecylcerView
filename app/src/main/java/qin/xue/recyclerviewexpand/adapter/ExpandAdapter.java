package qin.xue.recyclerviewexpand.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import qin.xue.recyclerviewexpand.R;
import qin.xue.recyclerviewexpand.beans.ExpandBeanIn;
import qin.xue.recyclerviewexpand.beans.ExpandBeanOut;
import qin.xue.recyclerviewexpand.interfaces.InItemClickListener;
import qin.xue.recyclerviewexpand.interfaces.InModuleProvier;
import qin.xue.recyclerviewexpand.interfaces.OutItemClickListener;
import qin.xue.recyclerviewexpand.modules.BaseModule;
import qin.xue.recyclerviewexpand.modules.ModuleIn;
import qin.xue.recyclerviewexpand.modules.ModuleOut;
import qin.xue.recyclerviewexpand.viewholders.ExpandBaseViewHolder;
import qin.xue.recyclerviewexpand.viewholders.ExpandInViewHolder;
import qin.xue.recyclerviewexpand.viewholders.ExpandOutViewHolder;

/**
 * Created by qinxue on 2018/9/6.
 */

public class ExpandAdapter extends RecyclerView.Adapter<ExpandBaseViewHolder> implements OutItemClickListener, InItemClickListener, InModuleProvier {
    private List<BaseModule> modules;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<ModuleIn> currentExpand;
    private int lastPosition = -1;
    private int currentId = -1;

    public ExpandAdapter(List<BaseModule> list, Context context) {
        modules = list;
        modules.add(new ModuleIn(new ExpandBeanIn("last")));
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ExpandBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ExpandBaseViewHolder baseViewHolder = null;
        switch (viewType) {
            case BaseModule.TYPE_IN:
                View viewIn = mLayoutInflater.inflate(R.layout.recycler_view_in_item, parent, false);
                ExpandInViewHolder expandInViewHolder = new ExpandInViewHolder(viewIn);
                expandInViewHolder.setInItemClickListener(this);
                baseViewHolder = expandInViewHolder;
                break;
            case BaseModule.TYPE_OUT:
                View viewOut = mLayoutInflater.inflate(R.layout.recycler_view_out_item, parent, false);
                ExpandOutViewHolder outViewHolder = new ExpandOutViewHolder(viewOut);
                outViewHolder.setOutItemClickListener(this);
                baseViewHolder = outViewHolder;
                break;
            default:
                break;
        }
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(ExpandBaseViewHolder holder, int position) {
        holder.update(modules.get(position));
    }

    @Override
    public int getItemCount() {
        return modules.size();
    }

    @Override
    public int getItemViewType(int position) {
        return modules.get(position).getType();
    }

    @Override
    public void onOutItemClick(ExpandBeanOut expandBeanOut, int position, boolean isExpand) {
        ModuleOut moduleOut = (ModuleOut) modules.get(position);
        moduleOut.setExpand(!isExpand);
        if (moduleOut.getId() == currentId || currentId == -1) {
            if (moduleOut.isExpand()) {
                currentExpand = getCurrentModuleInList(position);
                currentId = moduleOut.getId();
                modules.addAll(position + 1, currentExpand);
                notifyItemRangeInserted(position + 1, currentExpand.size());
                lastPosition = position;
            } else {
                modules.removeAll(currentExpand);
                notifyItemRangeRemoved(lastPosition, currentExpand.size());
                currentExpand = null;
                lastPosition = -1;
                currentId = -1;
            }
        } else {
            modules.removeAll(currentExpand);
            notifyItemRangeRemoved(lastPosition, currentExpand.size());
            if (position > lastPosition) {
                position -= currentExpand.size();
            }
            currentExpand = getCurrentModuleInList(position);
            modules.addAll(position + 1, currentExpand);
            notifyItemRangeInserted(position + 1, currentExpand.size());
            lastPosition = position;
        }
    }

    @Override
    public void onInItemClick(ExpandBeanIn beanIn) {
        Toast.makeText(mContext, "onInItemClick()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public List<ModuleIn> getCurrentModuleInList(int position) {
        List<ModuleIn> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ModuleIn(new ExpandBeanIn("nameIn " + i)));
        }
        return list;
    }
}
