package com.yyx.androidtestdemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yyx.androidtestdemo.activityDemo.MaterialDesignActivity;
import com.yyx.androidtestdemo.recyclerview.RecyclerViewActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Loading on 15/12/23.
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalViewHolder> {

    private final String TAG = "Test Log";

    private LayoutInflater inflater;

    private String[] mStringList;

    private Context mContext;

    public NormalRecyclerViewAdapter(Context context) {

        mContext = context;

        mStringList = context.getResources().getStringArray(R.array.item_array);

        Log.d(TAG, mStringList[0]);

        inflater = LayoutInflater.from(context);
    }

    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new NormalViewHolder(inflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {

        holder.mTextView.setText(mStringList[position]);
    }

    @Override
    public int getItemCount() {

        return mStringList == null ? 0 : mStringList.length;
    }

    class NormalViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text_view)
        TextView mTextView;

        public NormalViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                    Log.d(TAG,"current click : "+getLayoutPosition()+" last click : "+getOldPosition())
//                }
//            });


        }

        @OnClick(R.id.list_item)
        void itemOnClick() {

            Log.d(TAG, "current click : " + getLayoutPosition() + " last click : " + getOldPosition());

            switch (getLayoutPosition()){

                case 0:

//                    mContext.startActivity(new Intent(mContext, ActivityLanucherDemo.class));

                    String action = "com.yyx.mineActivity";
                    Intent intent = new Intent();

                    intent.setDataAndType(Uri.parse("file://123"),"media/3gpp");

//                    mContext.getPackageManager().resolveActivity(intent);
//                    intent.addCategory()

                    if(mContext.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)!= null){


                        mContext.startActivity(intent);

                    }


                    break;
                case 1:

                    mContext.startActivity(new Intent(mContext, MaterialDesignActivity.class));
                    break;

                case 2:

                    mContext.startActivity(new Intent(mContext, RecyclerViewActivity.class));
                    break;
            }

        }
    }
}
