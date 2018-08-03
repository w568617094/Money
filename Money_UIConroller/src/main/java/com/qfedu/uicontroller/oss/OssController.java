package com.qfedu.uicontroller.oss;

import com.qfedu.core.util.FileUtils;
import com.qfedu.core.util.OSSUtil;
import com.qfedu.core.vo.R;
import com.qfedu.domain.oss.OSSPo;
import com.qfedu.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RestController
public class OssController {
    @Autowired
    private OSSUtil ossUtil;
    @Autowired
    private UserDetailService service;
    @PostMapping("/fileup")
    public R fileup(CommonsMultipartFile file){
        String fn=FileUtils.createFileName(file.getOriginalFilename());
        String url = ossUtil.fileUp(fn,file.getBytes());
        OSSPo po = new OSSPo();
        po.setObjname(fn);
        po.setOurl(url);
        po.setPeriod(-1L);
        service.save(po);
        return new R(0,url,null);
    }
}
