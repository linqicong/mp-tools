package com.boal.wechat.model.message;


import com.boal.wechat.util.StringUtils;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
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



    public NewsMsg() {
        super();
        this.msgType = "news";
    }
    @SerializedName("news")
    private ParamContent paramContent = new ParamContent();


    public ParamContent getParamContent() {
        return paramContent;
    }

    public static class ParamContent {
        /**
         * 图文消息个数,限制为10条以内
         */
        private int count;
        /**
         * 多条图文消息信息,默认第一个item为大图,
         * </p>
         * 注意:如果图文数超过10,则将会无响应
         */
        private List<Article> articles = new ArrayList<>();

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }
    public int getCount() {
        return this.paramContent.count;
    }

    public void setCount(int count) {
        this.paramContent.count = count;
    }

    public List<Article> getArticles() {
        return this.paramContent.articles;
    }

    public void setArticles(List<Article> articles) {
        this.paramContent.articles = articles;
    }


}
