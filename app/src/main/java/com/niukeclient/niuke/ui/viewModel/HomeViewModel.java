package com.niukeclient.niuke.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.ViewModel;


import com.niukeclient.niuke.app.Injection;
import com.niukeclient.niuke.data.repository.HomeRepository;


import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

public class HomeViewModel extends BaseViewModel<HomeRepository> {
    //    private static final String MultiRecycleType_Head = "head";
//    private static final String MultiRecycleType_Left = "left";
//    private static final String MultiRecycleType_Right = "right";
    private HomeRepository homeRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
//        homeRepository = Injection.provideHomeRepository();
    }

//    //封装一个界面发生改变的观察者
//    public UIChangeObservable uc = new UIChangeObservable();
//
//    public class UIChangeObservable {
//        //下拉刷新完成
//        public SingleLiveEvent finishRefreshing = new SingleLiveEvent<>();
//        //上拉加载完成
//        public SingleLiveEvent finishLoadmore = new SingleLiveEvent<>();
//    }
//
//    //给RecyclerView添加ObservableList
//    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();
//    //RecyclerView多布局添加ItemBinding
//    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
//        @Override
//        public void onItemBind(ItemBinding itemBinding, int position, MultiItemViewModel item) {
//            //通过item的类型, 动态设置Item加载的布局
//            String itemType = (String) item.getItemType();
//            if (MultiRecycleType_Head.equals(itemType)) {
//                //设置头布局
//                itemBinding.set(BR.homeViewModel, R.layout.recommend_carousel);
//            } else if (MultiRecycleType_Left.equals(itemType)) {
//                //设置左布局
//                itemBinding.set(BR.homeViewModel, R.layout.recommend_navigation);
//            } else if (MultiRecycleType_Right.equals(itemType)) {
//                //设置右布局
//                itemBinding.set(BR.homeViewModel, R.layout.fragement_recommend);
//            }
//        }
//    });
//
//    //下拉刷新
//    public BindingCommand onRefreshCommand = new BindingCommand(new BindingAction() {
//        @Override
//        public void call() {
//            ToastUtils.showShort("下拉刷新");
////            requestNetWork();
//        }
//    });
//    //上拉加载
//    public BindingCommand onLoadMoreCommand = new BindingCommand(new BindingAction() {
//        @Override
//        public void call() {
//            if (observableList.size() > 50) {
//                ToastUtils.showLong("兄dei，你太无聊啦~崩是不可能的~");
////                uc.finishLoadmore.call();
//                return;
//            }
//            //模拟网络上拉加载更多
//            model.loadMore()
//                    .compose(RxUtils.schedulersTransformer()) //线程调度
//                    .doOnSubscribe(NetWorkViewModel.this) //请求与ViewModel周期同步
//                    .doOnSubscribe(new Consumer<Disposable>() {
//                        @Override
//                        public void accept(Disposable disposable) throws Exception {
//                            ToastUtils.showShort("上拉加载");
//                        }
//                    })
//                    .subscribe(new Consumer<DemoEntity>() {
//                        @Override
//                        public void accept(DemoEntity entity) throws Exception {
//                            for (DemoEntity.ItemsEntity itemsEntity : entity.getItems()) {
//                                NetWorkItemViewModel itemViewModel = new NetWorkItemViewModel(NetWorkViewModel.this, itemsEntity);
//                                //双向绑定动态添加Item
//                                observableList.add(itemViewModel);
//                            }
//                            //刷新完成收回
//                            uc.finishLoadmore.call();
//                        }
//                    });
//        }
//    });

}
