package edu.school.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import edu.school.dao.AdminDao;
import edu.school.entity.Admin;
import edu.school.utils.C3p0Utils;

public class AdminDaoImpl implements AdminDao {
	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());

	
	//�����û����������ѯ
	public Admin queryByUsernameAndPassword(String username, String password) {
		 try {
	            return runner.query("select * from admin where username=? and password=?", new BeanHandler<Admin>(Admin.class),username,password);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//�׳������쳣
	        }
	}
	

	public int updatePwd(Admin record) {
		try {//ִ�и���
            runner.update("update admin set  password=? where id=?",
            		record.getPassword(),record.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }
        return 1;
	}

}
