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
		//判断对象是否为空
		if(null!=user){
			//判断邮箱是否已被使用
			if(	-1 != qu.checkEmail(user.getEmail()).getCode() ){
				ret.setCode(0);
			
				//判断用户姓名是否为空
				if(null!=user.getName() && ""!=user.getName()){
					ret.setCode(0);
				
					//判断密码是否为空
					if(null!=user.getPassword() && ""!=user.getPassword()){
						ret.setCode(0);
						
						//判断电话是否为空
						if(null!=user.getTel() && ""!=user.getTel()){
							userDao.addUser(user);
							ret.setCode(0);
							ret.setInfo("注册成功");
						}
						else{
							ret.setCode(-1);
							ret.setInfo("电话不能为空");
						}
					}
					else{
						ret.setCode(-1);
						ret.setInfo("密码不能为空");
					}
				}
				else{
					ret.setCode(-1);
					ret.setInfo("姓名不能为空");
				}
			}
			else{
				ret.setCode(-1);
				ret.setInfo("该邮箱已被使用");
			}
	
		}
		else{
			ret.setCode(-1);
			ret.setInfo("注册失败,缺少对象");
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
						ret.setInfo("登录失败！");
					}
				}else{
					ret.setCode(-1);
					ret.setInfo("登录密码不能为空！");
					logger.info("登录密码不能为空！");
				}
			}else{
				ret.setCode(-1);
				ret.setInfo("登录邮箱不能为空！");
			}
		}else{
			ret.setCode(-1);
			ret.setInfo("登录用户不能为空！");
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
			ret.setInfo("请输入邮箱");
		}
		else{
			List<User> list = userDao.queryUserByEmail(email);
			ret.setCode(0);
			ret.setInfo("查询成功");
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
//		user.setName("郑伟华");
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
