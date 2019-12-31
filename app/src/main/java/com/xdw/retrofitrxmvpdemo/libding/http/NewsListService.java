package com.xdw.retrofitrxmvpdemo.libding.http;

import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import com.xdw.retrofitrxmvpdemo.libding.entity.news.JsonRootBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * @author WYH_Healer
 * @email 3425934925@qq.com
 * Created by xz on 2017/3/13.
 * Role:
 */
public interface NewsListService {


    String NETEAST_HOST = "http://c.m.163.com/";//网易爬虫
//    String NETEAST_HOST ="http://api.zhuishushenqi.com";//GetListRsp

    String CACHE_CONTROL_AGE = "max-age=0";

    // 头条TYPE
    String HEADLINE_TYPE = "headline";
    // 头条id
    String HEADLINE_ID = "T1348647909107";

    String BASE_URL = NETEAST_HOST;

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<JsonRootBean> getNewsList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type, @Path("id") String id,
            @Path("startPage") int startPage);


    //GetListRsp
    @GET("/cats/lv2/statistics/")
    Observable<GetListRsp> requestGetListRspList(@QueryMap Map<String, String> params);

}
