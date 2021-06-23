package com.llw.mvpdemo.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.llw.mvpdemo.R;
import com.llw.mvpdemo.bean.GankResponse;

import java.util.List;

/**
 * 列表适配器
 *
 * @author gzy
 */
public class GankListAdapter extends BaseQuickAdapter<GankResponse.DataBean, BaseViewHolder> {

    public GankListAdapter(int layoutResId, @Nullable List<GankResponse.DataBean> data) {
        super(layoutResId, data);
    }

    public interface OnItemClickLitener {
        void onItemClick(GankResponse.DataBean item);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    protected void convert(BaseViewHolder helper, GankResponse.DataBean item) {
        String imgUrl = item.getImages().get(0);

        Glide.with(mContext).load((imgUrl != null && !imgUrl.isEmpty()) ? imgUrl : "").into((ImageView) helper.getView(R.id.image));
        helper.setText(R.id.desc, item.getDesc());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int pos = helper.getLayoutPosition();
                mOnItemClickLitener.onItemClick(item);
            }
        });
    }


}
