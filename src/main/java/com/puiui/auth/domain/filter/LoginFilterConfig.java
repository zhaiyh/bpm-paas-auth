package com.puiui.auth.domain.filter;

import java.util.List;

/**
 * Created by zhaiyinghao on 2016/1/26.
 */
public class LoginFilterConfig {

    public List<String> noFilter;
    public List<Jump> jump;

    public static class Jump {
        public String method;
        public String from;
        public String to;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }

    public List<String> getNoFilter() {
        return noFilter;
    }

    public void setNoFilter(List<String> noFilter) {
        this.noFilter = noFilter;
    }

    public List<Jump> getJump() {
        return jump;
    }

    public void setJump(List<Jump> jump) {
        this.jump = jump;
    }
}
