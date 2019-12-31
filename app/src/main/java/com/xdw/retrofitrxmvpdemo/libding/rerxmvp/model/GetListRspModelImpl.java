package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.model;

import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import com.xdw.retrofitrxmvpdemo.libding.entity.news.JsonRootBean;
import com.xdw.retrofitrxmvpdemo.libding.http.NewsListService;
import com.xdw.retrofitrxmvpdemo.libding.http.manager.NetManager;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;

import java.util.Map;

import rx.Observable;

public class GetListRspModelImpl implements interfaceUtilsAll.GetListRspModel {
    @Override
    public Observable<GetListRsp> requestGetListRspList(Map<String, String> params) {
        NewsListService newsService= NetManager.getInstance().create(NewsListService.class);
        return newsService.requestGetListRspList(params);
    }

}
