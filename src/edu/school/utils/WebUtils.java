package edu.school.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {

	public static  <T> T copyParamToBean(Map value, T bean){//ʹ�÷���������request.getParameter���ظ����룬�Ż�����
		try {

			System.out.println("ע��֮ǰ"+bean);
			BeanUtils.populate(bean,value);
			System.out.println("ע��֮��"+bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public static int parseInt(String sid,int defalultvalue) {//��String���͵�idת��Integer���͵�
		  try {
	            return Integer.parseInt(sid);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return defalultvalue;
	}


}
