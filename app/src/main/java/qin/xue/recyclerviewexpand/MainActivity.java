package qin.xue.recyclerviewexpand;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import qin.xue.recyclerviewexpand.adapter.ExpandAdapter;
import qin.xue.recyclerviewexpand.beans.ExpandBeanOut;
import qin.xue.recyclerviewexpand.modules.BaseModule;
import qin.xue.recyclerviewexpand.modules.ModuleOut;

/**
 * Created by qinxue on 2018/9/6.
 */

public class MainActivity extends Activity {
    RecyclerView mRecyclerView;
    private List<BaseModule> beanOutList;

    private ExpandAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();
        adapter = new ExpandAdapter(beanOutList, this);
        mRecyclerView.setAdapter(adapter);
    }

    private void initData() {
        beanOutList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            beanOutList.add(new ModuleOut(new ExpandBeanOut("Out name " + i),i));
        }
    }

}
