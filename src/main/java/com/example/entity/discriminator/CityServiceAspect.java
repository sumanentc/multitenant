package com.example.entity.discriminator;

import com.example.config.TenantContext;
import com.example.service.discriminator.CityService;
import org.aspectj.lang.JoinPoint;
import org.hibernate.Session;

//@Aspect
//@Component
public class CityServiceAspect {
    //@Before("execution(* com.example.service.discriminator.CityService.*(..))&& target(cityService) ")
    public void aroundExecution(JoinPoint pjp, CityService cityService) throws Throwable {
        org.hibernate.Filter filter = cityService.entityManager.unwrap(Session.class).enableFilter("tenantFilter");
        filter.setParameter("tenantId", TenantContext.getCurrentTenant());
        filter.validate();
    }
}
