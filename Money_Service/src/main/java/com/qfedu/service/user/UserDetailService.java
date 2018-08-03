package com.qfedu.service.user;

import com.qfedu.core.vo.R;
import com.qfedu.domain.oss.OSSPo;
import com.qfedu.domain.user.UserDetail;

import java.util.List;

public interface UserDetailService {
    R save(int uid);

    R update(UserDetail detail);
    UserDetail queryByUid(int uid);
    List<UserDetail> queryByFlag(int fag);
    R realNameAuth(int uid);
    R save(OSSPo po);
}
