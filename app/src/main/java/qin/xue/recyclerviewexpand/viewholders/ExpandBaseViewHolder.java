package qin.xue.recyclerviewexpand.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by qinxue on 2018/9/6.
 */

public class ExpandBaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ExpandBaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public void update(T t) {

    }

    @Override
    public void onClick(View v) {

    }
}
