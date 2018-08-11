package com.zzq58.mvps.bean;

import java.io.Serializable;

/**
 * @Author: iszengziqiang@163.com
 * @Date: 2018/8/11 下午4:11
 * @Desc: 使用gson进行处理。data里多数据没有异常。少数据也不会错。
 **/

public class IpBean implements Serializable {
    @Override
    public String toString() {
        return "IpBean{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * data : {"RemoteAddr":"121.33.6.228","ContextPath":"中国","time":1234567789009}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * RemoteAddr : 121.33.6.228
         * ContextPath : 中国
         * time : 1234567789009
         */

        private String RemoteAddr;
        private String ContextPath;
        private long time;

        public String getRemoteAddr() {
            return RemoteAddr;
        }

        public void setRemoteAddr(String RemoteAddr) {
            this.RemoteAddr = RemoteAddr;
        }

        public String getContextPath() {
            return ContextPath;
        }

        public void setContextPath(String ContextPath) {
            this.ContextPath = ContextPath;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "RemoteAddr='" + RemoteAddr + '\'' +
                    ", ContextPath='" + ContextPath + '\'' +
                    ", time=" + time +
                    '}';
        }
    }
}
