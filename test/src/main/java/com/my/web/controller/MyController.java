package com.my.web.controller;  
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.web.model.CommonVO;
import com.my.web.service.CommonService;
   
@Controller  
@RequestMapping("/bill")  
public class MyController {   
	
	@Autowired  
	CommonService service; 
    
	/**
	 * ��ѯ��֯����ȷ��
	 * library  construction
	 * @return
	 */
    @RequestMapping(value = "/queryOrg",method=RequestMethod.POST) 
    private @ResponseBody CommonVO queryOrg(@RequestBody CommonVO vo){
    	List<CommonVO> list= service.queryOrg(vo);
    	CommonVO vol = new CommonVO();
    	if(list == null || list.size() == 0){
    		vol.setOrgStatus("0");
            return vol;  
    	}else if(list.size() == 1){
    		vol = list.get(0);
    		vol.setOrgStatus("1");
            return vol;  
    	}else{
    		vol.setOrgStatus("2");
    		return  vol;
    	}
    }  
    /**
	 * ��ѯҪ�޸ĵ�������ȷ��
	 * @return
	 */
    @RequestMapping(value = "/queryData",method=RequestMethod.POST) 
    private @ResponseBody int queryData(@RequestBody CommonVO vo){ 
    	int num = service.queryData(vo);
    	return num;  
          
    } 
    /**
	 * ������ȷ����
	 * @return
	 */
    @RequestMapping(value = "/updateData",method=RequestMethod.POST) 
    private @ResponseBody int updateData(@RequestBody CommonVO vo){   
    	int num = service.updateData(vo);
    	return num;  
    } 
  
  
}  