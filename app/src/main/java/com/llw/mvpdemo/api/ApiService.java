package com.llw.mvpdemo.api;


import com.llw.mvpdemo.bean.GankResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * ApiService接口 统一管理应用所有的接口
 * @author gzy
 */
public interface ApiService {

    /**
     * 获取数据列表
     * @return GankResponse
     */
    @GET("/api/v2/data/category/Girl/type/Girl/page/1/count/10")
    Observable<GankResponse> getList();
}
