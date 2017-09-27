package com.zssy.sbwx.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractBaseAction {
    
    /**
     * action²Ù×÷³éÏóÀà
     * @throws BasicException 
     */
    public abstract String execute(Map session,HttpServletRequest request,HttpServletResponse response) throws Exception;
}
