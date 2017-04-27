package com.koumanwei.androiddemo.mvp.news.model;

import com.koumanwei.androiddemo.R;
import com.koumanwei.androiddemo.mvp.news.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 2017-04-27 下午2:30
 *
 * @author koumanwei
 * @version 1.0
 */

public class NewsModelImpl implements NewsModel {
    @Override
    public List<NewsBean> getNewsData() {
        return getNewsFromNetwork();
    }

    private List<NewsBean> getNewsFromNetwork() {
        List<NewsBean> list = new ArrayList<>();
        list.add(new NewsBean("iphone 5s 大降价", "iPhone5s是美国苹果公司在2013年9月推出的一款手机，在9月20日于12个国家以及地区首发iPhone 5s，首次包括中国大陆，首周销量突破900万部", 453, R.mipmap.iphone0));
        list.add(new NewsBean("iphone 6 值得购买吗", "北京时间2014年9月10日凌晨1点，苹果公司在加州库比蒂诺德安萨学院的弗林特艺术中心正式发布其新一代产品 iPhone 6。9月12日开启预定，9月19日上市", 367, R.mipmap.iphone1));
        list.add(new NewsBean("iphone 7 漏洞百出", "iPhone7iPhone 7 Plus的电池容量只有2900mAh，相比iPhone 6 Plus上的2915mAh在容量上还小那么一点点，却能建立在更强悍的A10 Fusion处理器上多提供超过一个小时的续航时间,iPhone 7 Plus使用双摄像头", 12349, R.mipmap.iphone2));
        list.add(new NewsBean("iphone 8 横空出世", "iPhone8是美国苹果公司在2013年9月推出的一款手机，在9月20日于12个国家以及地区首发iPhone 5s，首次包括中国大陆，首周销量突破900万部", 876, R.mipmap.iphone3));
        list.add(new NewsBean("iphone 4 经典之作", "iPhone4是美国苹果公司在2013年9月推出的一款手机，在9月20日于12个国家以及地区首发iPhone 5s，首次包括中国大陆，首周销量突破900万部", 34, R.mipmap.iphone0));
        list.add(new NewsBean("iphone SE 无性价比可言", "iPhoneSE是美国苹果公司在2013年9月推出的一款手机，在9月20日于12个国家以及地区首发iPhone 5s，首次包括中国大陆，首周销量突破900万部", 3985, R.mipmap.iphone1));
        list.add(new NewsBean("iphone 9 史上最完美的手机", "iPhone9是美国苹果公司在2013年9月推出的一款手机，在9月20日于12个国家以及地区首发iPhone 5s，首次包括中国大陆，首周销量突破900万部", 1984, R.mipmap.iphone2));
        list.add(new NewsBean("iphone 4s 大众首选", "iPhone 4s在硬件和软件方面都有了较大的提升，其最大的亮点在于全新siri智能语音助手和iCloud云端服务。硬件方面，搭载苹果A5双核处理器，正面配有3.5英寸IPS玻璃硬屏，分辨率为960×640像素，背照式镜头像素提升至800万", 1002, R.mipmap.iphone3));
        return list;
    }
}
