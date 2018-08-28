package com.boal.wechat.model;

import com.boal.wechat.util.GsonFactory;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import org.apache.http.util.TextUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TemplateMessage extends BaseModel {

    private static final long serialVersionUID = 391703816459999848L;
    /**
     * 用户openId
     */
    private String touser;

    /**
     * 模板ID
     */
    @SerializedName("template_id")
    private String templateId;

    /**
     * 链接
     */
    private String url;

    @SerializedName("data")
    private List<Template> templates=new ArrayList<>();

    private Miniprogram miniprogram;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    public Miniprogram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(Miniprogram miniprogram) {
        this.miniprogram = miniprogram;
    }

    public static void main(String[] args) {
        Gson gson = GsonFactory.getGson();
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setTouser("openId");
        templateMessage.setTemplateId("id");
        templateMessage.setUrl("url");
        templateMessage.getTemplates().add(new Template("name1","value1"));
        templateMessage.getTemplates().add(new Template("name2","value2"));
        String customJSON = GsonFactory.getGson().toJson(templateMessage);
        System.out.println(customJSON);

    }

}
