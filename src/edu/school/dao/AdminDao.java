package edu.school.dao;

import edu.school.entity.Admin;

public interface AdminDao {
    public Admin queryByUsernameAndPassword(String username, String password);//���ݹ���Ա�˺ź���������¼
    public int updatePwd(Admin record);//����id����
}
