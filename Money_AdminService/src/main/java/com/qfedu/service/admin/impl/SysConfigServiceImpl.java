package com.qfedu.service.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysConfig;
import com.qfedu.mapper.admin.SysConfigMapper;
import com.qfedu.service.admin.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper mapper;
    @Override
    public DataGridResult getPageList(Query query) {
        int offset = (int) query.get("offset");
        int limit = (int) query.get("limit");

        List<SysConfig> rows=mapper.selectByPage(offset,limit);
        Long total= mapper.selectCount();
        DataGridResult dataGridResult =new DataGridResult(rows,total);

        return dataGridResult;
    }

    @Override
    public void deletebatch(Long[] ids) {
        mapper.deleteBatch(ids);
    }

    @Override
    public SysConfig getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public void save(SysConfig sysConfig) {
        sysConfig.setStatus((byte)1);
        mapper.insert(sysConfig);
    }

    @Override
    public void update(SysConfig sysConfig) {
        mapper.update(sysConfig);
    }

    @Override
    public List<SysConfig> findByKeyPrefix(String keyprefix) {
        return mapper.selectByKeyPrefix(keyprefix);
    }
}
