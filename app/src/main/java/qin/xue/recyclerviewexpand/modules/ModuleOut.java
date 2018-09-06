package qin.xue.recyclerviewexpand.modules;

import qin.xue.recyclerviewexpand.beans.ExpandBeanOut;

/**
 * Created by qinxue on 2018/9/6.
 */

public class ModuleOut extends BaseModule<ExpandBeanOut> {
    private boolean isExpand;
    private int id;

    public ModuleOut(ExpandBeanOut value, int id) {
        super(value);
        type = TYPE_OUT;
        this.id = id;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;

    }

    public int getId() {
        return id;
    }
}
