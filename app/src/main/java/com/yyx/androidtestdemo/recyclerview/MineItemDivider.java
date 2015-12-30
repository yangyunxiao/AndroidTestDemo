package com.yyx.androidtestdemo.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class MineItemDivider extends RecyclerView.ItemDecoration {

    //默认分隔条的Drawable资源的ID
    private static final int[] ATTRS = {android.R.attr.listDivider};
    //分隔条的Drawable对象
    private Drawable mDivider;

    public MineItemDivider(Context context) {

        TypedArray typedArray = context.obtainStyledAttributes(ATTRS);

        mDivider = typedArray.getDrawable(0);

        typedArray.recycle();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

        int left = parent.getPaddingLeft();

        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();

        for(int i = 0; i < childCount ; i++){

            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;

            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left,top,right,bottom);

            mDivider.draw(c);
        }
    }

}
