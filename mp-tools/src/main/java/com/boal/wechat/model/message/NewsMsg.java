package com.boal.wechat.model.message;


import com.boal.wechat.util.StringUtils;

import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class NewsMsg extends BasicMsg {

    /**
     * 图文消息个数,限制为10条以内
     */
    private int count;
    /**
     * 多条图文消息信息,默认第一个item为大图,
     * </p>
     * 注意:如果图文数超过10,则将会无响应
     */
    private List<Article> articles;

    public NewsMsg() {
        super();
        this.msgType = "news";
    }


    public NewsMsg(BasicMsg msg) {
        this.msgType = "news";
    }

    public int getCount() {
        return count;
    }

    protected void setCount(int count) {
        this.count = count;
    }

    public List<Article> getArticles() {
//        if (!StringUtils.isEmpty(articles) && articles.size() > 10) {
//            this.articles = articles.subList(0, 10);
//            setCount(10);
//        }
//        else {
//            this.setCount(articles.size());
//        }
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }



}
