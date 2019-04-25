package com.infoshareacademy.jjdd6.errorzy.statisticsData;

import freemarker.log.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class StatisticsDataInterceptor {

    Logger logger = Logger.getLogger(StatisticsDataInterceptor.class.getName());

    @AroundInvoke
    public Object interceptor(InvocationContext context) throws Exception {

        Object[] parameters = context.getParameters();


        logger.info("User choice has been saved");

        context.setParameters(parameters);
        return context.proceed();
    }

}