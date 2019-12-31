package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.model;


import com.xdw.retrofitrxmvpdemo.libding.entity.news.JsonRootBean;
import com.xdw.retrofitrxmvpdemo.libding.http.NewsListService;
import com.xdw.retrofitrxmvpdemo.libding.http.manager.NetManager;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;

import rx.Observable;

public class NewsListModelImpl implements interfaceUtilsAll.NewsListModel {
    @Override
    public Observable<JsonRootBean> getNewsListData(int page) {
        NewsListService newsService= NetManager.getInstance().create(NewsListService.class);
        return newsService.getNewsList(NewsListService.CACHE_CONTROL_AGE,NewsListService.HEADLINE_TYPE,NewsListService.HEADLINE_ID,page);
    }
}
