package com.crawl;

import com.crawl.zhihu.ZhiHuHttpClient;

/**
 * 爬虫入口
 */
public class Main {
    public static void main(String args []){
        //ProxyHttpClient.getInstance().startCrawl();
        ZhiHuHttpClient.getInstance().startCrawl();
    }
}
