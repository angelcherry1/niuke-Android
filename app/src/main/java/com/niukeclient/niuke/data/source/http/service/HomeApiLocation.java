package com.niukeclient.niuke.data.source.http.service;

/**
 * @creaty by :lixiaobiao
 * @date:on 2020/5/21 0021
 * @Describe :xxxxx
 */
public class HomeApiLocation {

    //获取直播房间列表
    //http://open.douyucdn.cn/api/RoomApi/live/{分类 ID 戒者分类别名}
    public static final String roomList="api/RoomApi/live/";

    //http://open.douyucdn.cn/api/RoomApi/live获取所有直播列表
    public static final String allRoom="api/RoomApi/live";

    //颜值房间列表
    public static final String faceScoreRoomList="api/RoomApi/live/201";

    //获取直播房间详情信息/api/RoomApi/room/{房间 Id 或者房间别名}
    public static final String details="api/RoomApi/room/";

    //获取所有分类 /api/RoomApi/game
    public static final String allCategory="api/RoomApi/game";

    //****************************************************************
    //旧base地址
    public static final String baseUrl_capi = "http://capi.douyucdn.cn/";
    //*********************首页****************************
    //栏目>类别>房间
    //轮播图
    public static final String getCarousel = "api/v1/slide/6";
    //首页最热
    public static final String getHomeHotColumn = "/api/v1/getbigDataRoom";
    //热门类别列表
    public static final String getRecommendHotCate = "api/v1/getHotCate";
    //栏目列表
    public static final String getCateList = "/api/v1/getColumnList";
    //获取栏目中的类别列表
    public static final String getCate = "/api/v1/getColumnDetail";
    //**********************************************************
    public static final String baseUrl_m="https://m.douyu.com/";
    //通过roomId获取视频播放地址
    public static final String getVideoUrl="html5/live";
}