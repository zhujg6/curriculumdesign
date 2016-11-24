package com.secondcar.servicesImpl;




import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;
import com.secondcar.bean.User;
import com.secondcar.comm.BeanFactoryUtil;
import com.secondcar.comm.Constants;
import com.secondcar.comm.JsonPluginsUtil;
import com.secondcar.comm.ResultInfo;
import com.secondcar.dao.UserDao;
import com.secondcar.mail.InitMail;
import com.secondcar.mail.Mail;
import com.secondcar.mail.MailUtil;
import com.secondcar.query.QueryUser;
import com.secondcar.services.UserService;

public class UserServiceImpl implements UserService {

	
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	private static UserDao userDao = (UserDao) BeanFactoryUtil.getBean("userDao");
	
	public ResultInfo addUser(User user) {
		ResultInfo ret = new ResultInfo();
		QueryUser qu = new QueryUser();
		//�ж϶����Ƿ�Ϊ��
		if(null!=user){
			//�ж������Ƿ��ѱ�ʹ��
			if(	-1 != qu.checkEmail(user.getEmail()).getCode() ){
				ret.setCode(0);
			
				//�ж��û������Ƿ�Ϊ��
				if(null!=user.getName() && ""!=user.getName()){
					ret.setCode(0);
				
					//�ж������Ƿ�Ϊ��
					if(null!=user.getPassword() && ""!=user.getPassword()){
						ret.setCode(0);
						
						//�жϵ绰�Ƿ�Ϊ��
						if(null!=user.getTel() && ""!=user.getTel()){
							userDao.addUser(user);
							ret.setCode(0);
							ret.setInfo("ע��ɹ�");
						}
						else{
							ret.setCode(-1);
							ret.setInfo("�绰����Ϊ��");
						}
					}
					else{
						ret.setCode(-1);
						ret.setInfo("���벻��Ϊ��");
					}
				}
				else{
					ret.setCode(-1);
					ret.setInfo("��������Ϊ��");
				}
			}
			else{
				ret.setCode(-1);
				ret.setInfo("�������ѱ�ʹ��");
			}
	
		}
		else{
			ret.setCode(-1);
			ret.setInfo("ע��ʧ��,ȱ�ٶ���");
		}
		return ret;
	}

	public ResultInfo login(User user) {
		ResultInfo ret = new ResultInfo();
		if(user != null){
			if(user.getEmail()!=null && user.getEmail()!=""){
				if(user.getPassword()!=null && user.getPassword()!=""){
					User newuser =userDao.checkLogin(user);
					if(newuser!=null){
						ret.setCode(0);
						ret.setObj(newuser);
						Mail mail = InitMail.init(newuser.getEmail());
						MailUtil.send(mail);
					}else{
						ret.setCode(-1);
						ret.setInfo("��¼ʧ�ܣ�");
					}
				}else{
					ret.setCode(-1);
					ret.setInfo("��¼���벻��Ϊ�գ�");
					logger.info("��¼���벻��Ϊ�գ�");
				}
			}else{
				ret.setCode(-1);
				ret.setInfo("��¼���䲻��Ϊ�գ�");
			}
		}else{
			ret.setCode(-1);
			ret.setInfo("��¼�û�����Ϊ�գ�");
		}
		return ret;
	}

	public ResultInfo updateUserInfo(User user) {
		return null;
	}

	public ResultInfo queryUserInfoByEmail(String email) {
		ResultInfo ret = new ResultInfo();
		if(null==email || ""==email){
			ret.setCode(-1);
			ret.setInfo("����������");
		}
		else{
			List<User> list = userDao.queryUserByEmail(email);
			ret.setCode(0);
			ret.setInfo("��ѯ�ɹ�");
			ret.setObj(list);
			logger.info(JsonPluginsUtil.beanListToJson(list));
		}
		return ret;
	}
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		User user = new User();
//		user.setEmail("915018368@qq.com");
//		user.setPassword("");
//		userService.login(user);
//		user.setName("֣ΰ��");
		user.setEmail("929558536@qq.com");
//		user.setPassword("janem1030");
//		user.setTel("13074333920");
//		user.setCreateTime(new Date());
//		user.setUpdateTime(new Date());
//		user.setRoleId(Constants.PERMISSION_ADMIN);
		
//		logger.info(userService.addUser(user).getInfo());
//		logger.info(userService.queryUserInfoByEmail(user.getEmail()).getInfo());
		
	userService.queryUserInfoByEmail(user.getEmail());
	
		
	}
}
