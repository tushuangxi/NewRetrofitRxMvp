package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.presenter;

import com.andview.refreshview.utils.LogUtils;
import com.xdw.retrofitrxmvpdemo.libding.entity.news.JsonRootBean;
import com.xdw.retrofitrxmvpdemo.libding.http.manager.RxManager;
import com.xdw.retrofitrxmvpdemo.libding.http.manager.RxSubscriber;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.base.BasePresenter;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.model.NewsListModelImpl;

public class NewsListPresenterImpl extends BasePresenter<interfaceUtilsAll.NewsListView> {

    private NewsListModelImpl newsListInteractor;
    public NewsListPresenterImpl() {
        newsListInteractor=new NewsListModelImpl();
    }

    public void loadNewsData(int page) {
        mSubscription= RxManager.getInstance().doSubscribe(newsListInteractor.getNewsListData(page), new RxSubscriber<JsonRootBean>(true) {
            @Override
            protected void _onNext(JsonRootBean showApiNews) {
                LogUtils.i("走这里_onNext");
                if(showApiNews!=null){
                    mView.onSuccess(showApiNews);
                }

            }

            @Override
            protected void _onError() {
                LogUtils.i("走这里_onError");
                mView.onError();
            }
        });
    }


}
