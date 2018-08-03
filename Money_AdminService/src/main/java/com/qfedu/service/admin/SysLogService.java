package com.qfedu.service.admin;

import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysLog;

public interface SysLogService {
    DataGridResult getPageList(Query query);
    void save(SysLog sysLog);
}
