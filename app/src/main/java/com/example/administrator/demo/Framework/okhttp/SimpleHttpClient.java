package com.example.administrator.demo.Framework.okhttp;

/**
 * Created by Administrator on 2017/1/15.
 */
public class SimpleHttpClient {
    private SimpleHttpClient() {}
    public void enqueue(BaseCallback callback) {

    }

    public static Bulid newBulid() {
        return new Bulid();
    }

    public static class Bulid {
        private String url;
        private String method;

        private Bulid() {
            method = "GET";
        }

        public SimpleHttpClient bulid() {
            return new SimpleHttpClient();
        }

        public Bulid url(String url) {
            this.url = url;
            return this;
        }

        public Bulid get() {
            method = "GET";
            return this;
        }

        /**
         * form表单
         *
         * @return
         */
        public Bulid post() {
            method = "POST";
            return this;
        }

        /**
         * json参数
         *
         * @return
         */
        public Bulid json() {
            method = "POST";
            return this;
        }
    }
}
