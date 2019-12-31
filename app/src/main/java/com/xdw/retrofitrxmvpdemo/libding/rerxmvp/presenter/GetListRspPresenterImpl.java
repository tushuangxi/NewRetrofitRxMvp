package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.presenter;

import com.andview.refreshview.utils.LogUtils;
import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import com.xdw.retrofitrxmvpdemo.libding.entity.news.JsonRootBean;
import com.xdw.retrofitrxmvpdemo.libding.http.manager.RxManager;
import com.xdw.retrofitrxmvpdemo.libding.http.manager.RxSubscriber;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.base.BasePresenter;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.model.GetListRspModelImpl;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.model.NewsListModelImpl;

import java.util.Map;

public class GetListRspPresenterImpl extends BasePresenter<interfaceUtilsAll.GetListRspView> {

    private GetListRspModelImpl newsListInteractor;
    public GetListRspPresenterImpl() {
        newsListInteractor=new GetListRspModelImpl();
    }

    public void loadNewsData(Map<String, String> params) {
        mSubscription= RxManager.getInstance().doSubscribe(newsListInteractor.requestGetListRspList(params), new RxSubscriber<GetListRsp>(true) {
            @Override
            protected void _onNext(GetListRsp getListRsp) {
                LogUtils.i("走这里_onNext");
                if(getListRsp!=null){
                    mView.onGetListRspSuccess(getListRsp);
                }

            }

            @Override
            protected void _onError() {
                LogUtils.i("走这里_onError");
                mView.onGetListRspError();
            }
        });
    }


}
