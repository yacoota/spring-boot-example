package com.cacoota.business.service.impl;


import com.cacoota.business.mapper.DemoMapper;
import com.cacoota.business.model.Demo;
import com.cacoota.business.model.DemoExample;
import com.cacoota.business.service.DemoService;
import com.cacoota.framework.base.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class DemoServiceImpl extends BaseServiceImpl<Demo, DemoExample> implements DemoService {

    @Autowired
    private DemoMapper mapper;

    @Override
    protected void setBaseMapper() {
        super.mapper = mapper;
    }

    @Override
    public PageInfo<Demo> selectPageHelper(DemoExample example, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(mapper.selectByExampleWithBLOBs(example));
    }

    @Override
    @Transactional
    public int insert(Demo demo) {
        return super.insert(demo);
    }

}
