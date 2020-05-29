package com.niukeclient.niuke.ui.viewModel.homeViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;


import com.niukeclient.niuke.BR;
import com.niukeclient.niuke.R;
import com.niukeclient.niuke.app.Injection;
import com.niukeclient.niuke.data.repository.HomeRepository;
import com.niukeclient.niuke.ui.viewModel.homeViewModel.MultiRecycleHeadViewModel;
import com.niukeclient.niuke.ui.viewModel.homeViewModel.MultiRecycleLeftItemViewModel;
import com.niukeclient.niuke.ui.viewModel.homeViewModel.MultiRecycleRightItemViewModel;


import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;


public class HomeViewModel extends BaseViewModel<HomeRepository> {
    private static final String MultiRecycleType_Head = "head";
    private static final String MultiRecycleType_Left = "left";
    private static final String MultiRecycleType_Right = "right";
    private HomeRepository homeRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application,Injection.provideHomeRepository());
        //模拟10个条目，数据源可以来自网络
        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                String url="http://192.168.10.62:8060/cat.jpg";
                MultiItemViewModel item = new MultiRecycleHeadViewModel(this,url);
                //条目类型为头布局
                item.multiItemType(MultiRecycleType_Head);
                observableList.add(item);
            } else {
                String text = "我是第" + i + "条";
                if (i==1) {
                    MultiItemViewModel item = new MultiRecycleLeftItemViewModel(this, text);
                    //条目类型为左布局
                    item.multiItemType(MultiRecycleType_Left);
                    observableList.add(item);
                } else {
                    MultiItemViewModel item = new MultiRecycleRightItemViewModel(this, text);
                    //条目类型为右布局
                    item.multiItemType(MultiRecycleType_Right);
                    observableList.add(item);
                }
            }
        }
    }

    //给RecyclerView添加ObservableList
    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MultiItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            String itemType = (String) item.getItemType();
            if (MultiRecycleType_Head.equals(itemType)) {
                //设置头布局
                itemBinding.set(BR.viewModelHeader, R.layout.item_multi_head);
            } else if (MultiRecycleType_Left.equals(itemType)) {
                //设置左布局
                itemBinding.set(BR.viewModelLeft, R.layout.item_multi_rv_left);
            } else if (MultiRecycleType_Right.equals(itemType)) {
                //设置右布局
                itemBinding.set(BR.viewModelRight, R.layout.item_multi_rv_right);
            }
        }
    });

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
