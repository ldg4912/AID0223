package com.imooc.miaosha.extend;

import org.thymeleaf.context.AbstractContext;
import org.thymeleaf.context.IContextExecutionInfo;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.VariablesMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SpringWebContextUtil extends AbstractContext implements IWebContext {


    @Override
    protected IContextExecutionInfo buildContextExecutionInfo(String s) {
        return null;
    }

    @Override
    public HttpServletRequest getHttpServletRequest() {
        return null;
    }

    @Override
    public HttpServletResponse getHttpServletResponse() {
        return null;
    }

    @Override
    public HttpSession getHttpSession() {
        return null;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public VariablesMap<String, String[]> getRequestParameters() {
        return null;
    }

    @Override
    public VariablesMap<String, Object> getRequestAttributes() {
        return null;
    }

    @Override
    public VariablesMap<String, Object> getSessionAttributes() {
        return null;
    }

    @Override
    public VariablesMap<String, Object> getApplicationAttributes() {
        return null;
    }
}
