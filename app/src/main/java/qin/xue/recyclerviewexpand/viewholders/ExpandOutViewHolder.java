package qin.xue.recyclerviewexpand.viewholders;

import android.view.View;
import android.widget.TextView;

import qin.xue.recyclerviewexpand.R;
import qin.xue.recyclerviewexpand.beans.ExpandBeanOut;
import qin.xue.recyclerviewexpand.interfaces.OutItemClickListener;
import qin.xue.recyclerviewexpand.modules.ModuleOut;

/**
 * Created by qinxue on 2018/9/6.
 */

public class ExpandOutViewHolder extends ExpandBaseViewHolder<ModuleOut> {

    private TextView textView;
    private OutItemClickListener outItemClickListener;
    private ExpandBeanOut expandBeanOut;
    private ModuleOut moduleOut;

    public ExpandOutViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title);
    }

    @Override
    public void update(ModuleOut moduleOut) {
        super.update(moduleOut);
        this.moduleOut = moduleOut;
        expandBeanOut = moduleOut.getValue();
        textView.setText(expandBeanOut.getTitle());
    }

    public void setOutItemClickListener(OutItemClickListener outItemClickListener) {
        this.outItemClickListener = outItemClickListener;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (outItemClickListener != null) {
            outItemClickListener.onOutItemClick(expandBeanOut, getAdapterPosition(), moduleOut.isExpand());
        }
    }
}
