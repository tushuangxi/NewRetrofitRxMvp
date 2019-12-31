package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils;


import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import com.xdw.retrofitrxmvpdemo.libding.entity.news.JsonRootBean;

import java.util.Map;

import rx.Observable;

public class interfaceUtilsAll {

    //JsonRootBean
    public interface NewsListView {
        void getNewsListData(JsonRootBean list);
        void onSuccess(JsonRootBean showApiNews);
        void onError();
    }

    public interface NewsListModel {
        Observable<JsonRootBean> getNewsListData(int page);
    }

    //GetListRsp
    public interface GetListRspView {
        void onGetListRspSuccess(GetListRsp getListRsp);
        void onGetListRspError();
    }
    public interface GetListRspModel {
        Observable<GetListRsp> requestGetListRspList(Map<String, String> params);
    }
}
