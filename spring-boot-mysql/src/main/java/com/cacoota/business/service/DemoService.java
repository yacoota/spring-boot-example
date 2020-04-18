package com.cacoota.business.service;


import com.cacoota.business.model.Demo;
import com.cacoota.business.model.DemoExample;
import com.cacoota.framework.base.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DemoService extends BaseService<Demo, DemoExample> {

    List<Demo> select(DemoExample example);

    PageInfo<Demo> selectPageHelper(DemoExample example, int pageNum, int pageSize);

}
