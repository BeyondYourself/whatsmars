package org.hongxi.whatsmars.earth.service.impl;

import org.hongxi.whatsmars.earth.common.pojo.Result;
import org.hongxi.whatsmars.earth.common.pojo.ResultCode;
import org.hongxi.whatsmars.earth.dao.OrganizationDao;
import org.hongxi.whatsmars.earth.service.OrganizationService;
import org.hongxi.whatsmars.earth.domain.pojo.Organization;
import org.hongxi.whatsmars.earth.domain.query.OrganizationQuery;
import org.hongxi.whatsmars.earth.domain.query.QueryResult;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by shenhongxi on 2016/4/6.
 */
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDao organizationDao;

    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public Result list(OrganizationQuery query) {
        Result result = new Result();
        try {
            QueryResult<Organization> qr = this.organizationDao.query(query);
            Collection<Organization> organizations = qr.getResultList();
            result.addModel("query", query);
            result.addModel("queryResult", qr);
            result.addModel("organizations", organizations);
        } catch (Exception e) {
            //logger.error("organization query error,", e);
            result.setResultCode(ResultCode.SYSTEM_ERROR);
        }
        return result;
    }
}
