package com.georgeren.designandroid.recycler;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.georgeren.designandroid.R;
import com.georgeren.designandroid.databinding.ItemProductBinding;
import com.georgeren.designandroid.model.Product;

import java.util.List;

/**
 * Created by georgeRen on 2017/9/11.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // item_product-->ItemProductBinding
        final ItemProductBinding productBinding = ItemProductBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);

        return new ProductViewHolder(productBinding);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.bind(products.get(position));// data-->view
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductBinding binding;

        ProductViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Product product) {
            binding.setProduct(product);// data-variable-product
            binding.imgProduct.setBackground(createProductBackground(product));// 背景色
            binding.imgProduct.setImageResource(product.image);// 图片
        }

        /**
         * 修改 GradientDrawable 颜色
         * @param product
         * @return
         */
        @NonNull
        private GradientDrawable createProductBackground(Product product) {
            final GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(
                    itemView.getContext(), R.drawable.bg_product);

            gradientDrawable.setColor(ContextCompat.getColor(
                    itemView.getContext(), product.color));

            gradientDrawable.setSize(itemView.getWidth(), getDrawableHeight());// 宽高：宽不变，高改变
            gradientDrawable.mutate();// 改变
            return gradientDrawable;
        }

        /**
         * 获取drawable高度
         * 偶数208dp
         * 奇数160dp
         * @return
         */
        private int getDrawableHeight() {
            final Context context = itemView.getContext();

            return getAdapterPosition() % 2 == 0
                    ? context.getResources().getDimensionPixelOffset(R.dimen.product_regular_height)
                    : context.getResources().getDimensionPixelOffset(R.dimen.product_large_height);
        }
    }
}
