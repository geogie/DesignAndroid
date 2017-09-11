package com.georgeren.designandroid.recycler;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.georgeren.designandroid.R;

/**
 * Created by georgeRen on 2017/9/11.
 * 左右间距8dp
 */

public class ProductItemPaddingDecoration extends RecyclerView.ItemDecoration {
    private final Rect paddingRect;

    public ProductItemPaddingDecoration(Context context) {
        final int padding = (int) context.getResources().getDimension(R.dimen.product_margin);
        paddingRect = new Rect(padding, 0, padding, 0);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(paddingRect);
    }
}
