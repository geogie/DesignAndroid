package com.georgeren.designandroid;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.georgeren.designandroid.databinding.ActivityHomeBinding;
import com.georgeren.designandroid.model.Product;
import com.georgeren.designandroid.recycler.OnItemSelectedListener;
import com.georgeren.designandroid.recycler.ProductAdapter;
import com.georgeren.designandroid.recycler.ProductItemPaddingDecoration;

import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity {
    private final List<Product> fakeProducts = Product.createFakeProducts();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 通过 bind 初始化view（activity_home --> ActivityHomeBinding）
        ActivityHomeBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_home);

        initRecycler(binding.productsRecycler);
    }
    private void initRecycler(RecyclerView productsRecycler) {
        productsRecycler.setAdapter(new ProductAdapter(fakeProducts));// adapter
        productsRecycler.addItemDecoration(new ProductItemPaddingDecoration(this));// item padding，左右8dp
        productsRecycler.addOnItemTouchListener(new OnItemSelectedListener(this) {
            @Override
            public void onItemSelected(RecyclerView.ViewHolder holder, int position) {
                OrderDialogFragment.newInstance(fakeProducts.get(position)).show(getSupportFragmentManager(), null);
            }
        });
    }

    /**
     * 初始化字体
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
