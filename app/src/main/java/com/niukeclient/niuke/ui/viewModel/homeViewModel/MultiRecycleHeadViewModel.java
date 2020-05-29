package com.niukeclient.niuke.ui.viewModel.homeViewModel;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;

import com.niukeclient.niuke.R;

import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Create Author：goldze
 * Create Date：2019/01/25
 * Description：
 */

public class MultiRecycleHeadViewModel extends MultiItemViewModel<HomeViewModel> {
    public Drawable drawableImg;
    public ObservableField<String> oburl=new ObservableField<>("");
    public MultiRecycleHeadViewModel(@NonNull HomeViewModel viewModel,String url) {
        super(viewModel);
        //ImageView的占位图片，可以解决RecyclerView中图片错误问题
        drawableImg = ContextCompat.getDrawable(viewModel.getApplication(), R.mipmap.ic_launcher);
        oburl.set(url);
    }
    //图片地址：
//    public ObservableField<String> img=new ObservableField<>("https:\\/\\/static.oschina.net\\/uploads\\/space\\/2020\\/0520\\/150235_IOjL_3820517.png");
    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("我是头布局");
        }
    });
}
