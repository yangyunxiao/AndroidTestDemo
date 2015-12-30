package com.yyx.androidtestdemo.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yyx.androidtestdemo.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Loading on 15/12/28.
 */
public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<SampleRecyclerViewAdapter.SampleViewHolder> {

    private static final String TAG = "ADAPTER LOG";

    private final Context mContext;

    private final LayoutInflater mLayoutInflater;

    private List<DataModel> dataModelList;

    public SampleRecyclerViewAdapter(Context context) {

        this.mContext = context;

        mLayoutInflater = LayoutInflater.from(context);

        this.dataModelList = RecyclerDemo.getData(15);

    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new SampleViewHolder(mLayoutInflater.inflate(R.layout.item_text,parent,false),this);
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {

        holder.mTextView.setText(this.dataModelList.get(position).getText());
    }

    @Override
    public int getItemCount() {

        return this.dataModelList.size();
    }

    public void removeData(int position){

        this.dataModelList.remove(position);

        notifyItemRemoved(position);
    }

    public void insertData(int position){

        this.dataModelList.add(position,new DataModel("插入新的列表项< "+position+" >"));

        notifyItemInserted(position);
    }

    public static class SampleViewHolder extends  RecyclerView.ViewHolder{

        @Bind(R.id.text_view)
        TextView mTextView;

        private SampleRecyclerViewAdapter mAdapter;

        public SampleViewHolder(View itemView,SampleRecyclerViewAdapter adapter) {
            super(itemView);

            ButterKnife.bind(this,itemView);

            mAdapter = adapter;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d(TAG,getLayoutPosition()+"   "+ getPosition()+"   "+getAdapterPosition() );

                    int tagPosition = getLayoutPosition();

                    mAdapter.insertData(tagPosition);

                }
            });
        }
    }
}
