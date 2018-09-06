package qin.xue.recyclerviewexpand.interfaces;

import qin.xue.recyclerviewexpand.beans.ExpandBeanOut;

/**
 * Created by qinxue on 2018/9/6.
 */

public interface OutItemClickListener {
    void onOutItemClick(ExpandBeanOut expandBeanOut, int position, boolean isExpand);
}
