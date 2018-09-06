package qin.xue.recyclerviewexpand.viewholders;

import android.view.View;
import android.widget.TextView;

import qin.xue.recyclerviewexpand.R;
import qin.xue.recyclerviewexpand.beans.ExpandBeanIn;
import qin.xue.recyclerviewexpand.interfaces.InItemClickListener;
import qin.xue.recyclerviewexpand.modules.ModuleIn;

/**
 * Created by qinxue on 2018/9/6.
 */

public class ExpandInViewHolder extends ExpandBaseViewHolder<ModuleIn> {

    private InItemClickListener inItemClickListener;
    private TextView textView;
    private ExpandBeanIn beanIn;

    public ExpandInViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title);
    }

    @Override
    public void update(ModuleIn moduleIn) {
        super.update(moduleIn);
        beanIn = moduleIn.getValue();
        textView.setText(beanIn.getTitle());
    }

    @Override
    public void onClick(View v) {
        if (inItemClickListener != null) {
            inItemClickListener.onInItemClick(beanIn);
        }
    }

    public void setInItemClickListener(InItemClickListener inItemClickListener) {
        this.inItemClickListener = inItemClickListener;
    }

}
