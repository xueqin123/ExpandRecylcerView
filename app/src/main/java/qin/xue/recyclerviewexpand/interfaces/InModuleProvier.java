package qin.xue.recyclerviewexpand.interfaces;

import java.util.List;

import qin.xue.recyclerviewexpand.modules.ModuleIn;

/**
 * Created by qinxue on 2018/9/6.
 */

public interface InModuleProvier {
    List<ModuleIn> getCurrentModuleInList(int position);
}
