package com.mmga.itemtouchhelper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;


public class MainActivity extends Activity {

    RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);

//        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(mAdapter, ItemTouchHelper.UP | ItemTouchHelper.DOWN,
//                ItemTouchHelper.LEFT);
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);



        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
                final int fromPos = source.getAdapterPosition();
                final int toPos = target.getAdapterPosition();
                mAdapter.mOnMove(fromPos, toPos);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                mAdapter.mOnSwiped(viewHolder);
            }
        };
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);


    }

}
