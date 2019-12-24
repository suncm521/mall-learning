package com.hxf.mall.service;

/**
 * @author Suncm
 * @ClassName RedisService
 * @Description TODO
 * @Date 2019/12/24 10:06
 * @Version 1.0
 */
public interface RedisService {
    /*
     *存储数据
     **/
    void setData(String key,String value);

    /*
     *取数据
     **/
    String getData(String key);

    /*
     *设置超时时间
     **/
    boolean expire(String key,long expire);

    /*
     *删除数据
     **/
    void remove(String key);

    /*
     *自增操作
     **/
    Long increment(String key, long delta);
}
