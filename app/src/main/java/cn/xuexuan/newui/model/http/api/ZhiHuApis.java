package cn.xuexuan.newui.model.http.api;

import cn.xuexuan.newui.model.bean.DailyBeforeListBean;
import cn.xuexuan.newui.model.bean.DailyListBean;
import cn.xuexuan.newui.model.bean.ZhiHuDetailBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Jant on 2017/4/17.
 */

public interface ZhiHuApis {

    String HOST = "http://news-at.zhihu.com/api/4/";

    /**
     * 最新日报
     * http://news-at.zhihu.com/api/4/news/latest
     * @return
     */
    @GET("news/latest")
    Observable<DailyListBean> getDailyList();


    /**
     * 往期日报
     * http://news-at.zhihu.com/api/4/news/before/20170416
     * @param date   20170416
     * @return
     */
    @GET("news/before/{date}")
    Observable<DailyBeforeListBean> getDailyBeforeList(@Path("date") String date);


    /**
     * 日报详情
     * http://news-at.zhihu.com/api/4/news/3892357
     * @param id 9360247
     * @return
     */
    @GET("news/{id}")
    Observable<ZhiHuDetailBean> getDetailInfo(@Path("id") long id);


    /**
     * 获取网页中的css文件，以字符串的形式返回
     * @param url
     * @return
     */
    @GET
    Observable<String> getNewsDetailCss (@Url String url);



}
