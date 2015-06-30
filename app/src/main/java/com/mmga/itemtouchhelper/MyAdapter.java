package com.mmga.itemtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mmga on 2015/6/30.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> /*implements ItemTouchHelperAdapter*/{


    private String[] mData = {"one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen"};

    public ArrayList<String> mList = new ArrayList<>();


    public MyAdapter() {
        mList.addAll(Arrays.asList(mData));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.mTextView.setText(mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

//    drag的具体操作
    public void mOnMove(int fromPos,int toPos) {
        String prev = mList.remove(fromPos);
        mList.add(toPos > fromPos ? toPos - 1 : toPos, prev);
        notifyItemMoved(fromPos, toPos);
    }

//    swipe的具体操作
    public void mOnSwiped(RecyclerView.ViewHolder viewHolder) {
        mList.remove(viewHolder.getAdapterPosition());
        notifyItemRemoved(viewHolder.getAdapterPosition());
    }

//    @Override
//    public void onItemMove(int fromPosition, int toPosition) {
//        String prev = mList.remove(fromPosition);
//        mList.add(toPosition > fromPosition ? toPosition - 1 : toPosition, prev);
//        notifyItemMoved(fromPosition, toPosition);
//    }
//
//    @Override
//    public void onItemDismiss(int position) {
//        mList.remove(position);
//        notifyItemRemoved(position);
//    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }





}
