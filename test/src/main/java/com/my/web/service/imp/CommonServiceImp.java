package com.my.web.service.imp;  
  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.my.web.model.CommonVO;
import com.my.web.service.CommonService;
import com.my.web.source.DataSourceInstances;
import com.my.web.source.DataSourceSwitch;
  
public class CommonServiceImp implements CommonService{  
  
    private JdbcTemplate jdbcTemplate;     
  
    public JdbcTemplate getJdbcTemplate() {  
        return jdbcTemplate;  
    }  
  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
    }
    @SuppressWarnings("unchecked") 
	public List<CommonVO> queryOrg(final CommonVO vo) { 
    	DataSourceSwitch.setDataSourceType(DataSourceInstances.MYSQL); 
    	List<CommonVO> list1 = new ArrayList<CommonVO>();  
		String sql = "select * from t1 where id=?";
		list1=jdbcTemplate.query(sql, new PreparedStatementSetter() {  
			public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                ps.setString(1, vo.getOrgId());  
			}  
        }, new ResultSetExtractor() {  
            public Object extractData(ResultSet rs) throws SQLException, DataAccessException {  
                List<CommonVO> list = new ArrayList<CommonVO>();  
                while (rs.next()) {  
                	CommonVO co = new CommonVO();  
                	co.setOrgId(rs.getString("id"));
                	co.setOrgName(rs.getString("name"));
                	co.setExecStatus(rs.getString("code"));
                    list.add(co);  
                }  
                return list;  
            }  
        }); 
		return list1;
	}
	//jdbcTemplate.update("insert into t1 values(?,?,?)",new Object[]{"222","222","222"}); 
	public int queryData(CommonVO vo) {
		int i = jdbcTemplate.queryForInt("select count(*) from t1");   
		return i;
	}

	public int updateData(CommonVO vo) {
		int i = jdbcTemplate.update("update userinfo set bill_state=0 where bill_code in()");
		return i;
	}  
  
    
}  