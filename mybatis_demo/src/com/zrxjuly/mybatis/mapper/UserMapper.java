package com.zrxjuly.mybatis.mapper;

import java.util.List;

import com.zrxjuly.mybatis.pojo.User;

/**
 * ʹ��Mapper��̬����
 * @author zhangrongxiang
 *
 */
public interface UserMapper {
	/**
	 * һ��ʹ��Mapper��̬������Ҫ��ѭ�ĸ�ԭ��
	 * 1.�ӿڷ����� == UserMapper.xml�е�id��.
	 * 2.����ֵ����Ҫ��UserMapper.xml�ļ��з�������һ��. 
	 * 3.�������������Ҫ��UserMapper.xml�ļ��е��������һ��.
	 * 4.UserMapper.xml�������ռ�󶨴˽ӿ�.
	 * 
	 * ����selectOne��selectList
	 * ��̬����������sqlSession.selectOne()��sqlSession.selectList()�Ǹ���mapper�ӿڷ����ķ���ֵ������
	 * �������list�����selectList������������ص������������selectOne������
	 * 
	 * mybatis�ٷ��Ƽ�ʹ��mapper����������mapper�ӿڣ�����Ա���ñ�дmapper�ӿ�ʵ���࣬ʹ��mapper������ʱ�������������ʹ��pojo��װ�����map���󣬱�֤dao��ͨ���ԡ�
	 */
	// ���ص����������selectOne����
	public User findUserById(Integer id);
	// ����list,����selectList����
	public List<User> findUserByUsername(String username);
}
