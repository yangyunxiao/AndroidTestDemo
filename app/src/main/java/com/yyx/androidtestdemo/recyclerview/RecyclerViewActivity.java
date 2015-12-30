package com.yyx.androidtestdemo.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.yyx.androidtestdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.fab_delete)
    FloatingActionButton fab_delete;

    private SampleRecyclerViewAdapter mAdapter;

    private LinearLayoutManager layoutManager;

    private final String TAG = "Recycler Demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toolbar.setTitle("RecyclerView Sample");

        layoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.addItemDecoration(new MineItemDivider(this));

        mAdapter = new SampleRecyclerViewAdapter(this);

        mRecyclerView.setAdapter(mAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int visiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition();

                Log.d(TAG,visiblePosition+"");

                mAdapter.insertData(visiblePosition+1);
            }
        });
    }

    @OnClick(R.id.fab_delete)
    void deleteItem(){

        int lastPosition = layoutManager.findLastCompletelyVisibleItemPosition();

        mAdapter.removeData(lastPosition-1);
    }

}
