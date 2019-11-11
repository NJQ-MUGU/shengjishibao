package com.orange.uitl;

public class Result {
        private Object list;
        private String status;
        private String msg;

        public Result(String status, String msg) {
            this.status = status;
            this.msg = msg;
        }

        public Result(String status, String msg, Object list) {
            this.status = status;
            this.msg = msg;
            this.list = list;
        }

        public Result() {
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Result(String status, Object list) {
            this.status = status;
            this.list = list;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getList() {
            return list;
        }

        public void setList(Object list) {
            this.list = list;
        }
    }
