package com.my.web.service;

import java.util.List;

import com.my.web.model.CommonVO;

public interface CommonService {  
	List<CommonVO> queryOrg(CommonVO vo);    
    int queryData(CommonVO vo);    
    int updateData(CommonVO vo);    
}