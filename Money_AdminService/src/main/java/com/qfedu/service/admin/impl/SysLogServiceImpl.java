package com.qfedu.service.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysLog;
import com.qfedu.mapper.admin.SysLogMapper;
import com.qfedu.service.admin.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SysLogServiceImpl  implements SysLogService {

    @Autowired
    private SysLogMapper mapper;
    @Override
    public DataGridResult getPageList(Query query) {
        int offset = (int) query.get("offset");
        int limit = (int) query.get("limit");
        List<SysLog> rows=mapper.selectByPage(offset,limit);
        Long total=mapper.selectCount();
        DataGridResult dataGridResult = new DataGridResult(rows,total);
        return dataGridResult;

    }

    @Override
    public void save(SysLog sysLog) {
    mapper.insert(sysLog);
    }
}
