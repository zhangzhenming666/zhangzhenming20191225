package com.bawei.zhangzhenming20191225.model.bean;

import java.util.List;

/**
 * 时间：2019/12/25
 * 作者：张振明
 * 类的作用：
 */
public class FlowBean {

    /**
     * msg : 响应成功
     * code : 200
     * tags : ["电脑截图快捷键","电脑显示屏不亮但是主机已开机","电脑开不了机怎么办","电脑蓝屏怎么解决","电脑黑屏按什么键恢复","电脑ip地址怎么看","电脑截屏快捷键是哪个","电脑开机后进不了系统","电脑买一送一不发货","电脑怎么连接wifi"]
     */

    private String msg;
    private int code;
    private List<String> tags;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
