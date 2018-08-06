/**
 * 
 */
package com.sog.service;

import java.util.List;



import com.sog.entity.Logs;

/**
 * @ClassName LogsDaoImpl
 * @Description 
 * @Author 杨云凯
 * @Date 2018年6月30日 下午1:51:16
 */
public interface LogsServiceDaoI  extends BaseServiceI<Logs>{

	List<Logs> GetIdLogs(int id) throws Exception;

}
