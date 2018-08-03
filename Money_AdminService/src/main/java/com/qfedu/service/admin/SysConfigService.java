package com.qfedu.service.admin;

import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysConfig;

import java.util.List;

public interface SysConfigService {
    DataGridResult getPageList(Query query);
    void deletebatch(Long[] ids);
    SysConfig getById(Long id);
    void save(SysConfig sysConfig);
    void update(SysConfig sysConfig);
    List<SysConfig> findByKeyPrefix(String keyprefix);
}
