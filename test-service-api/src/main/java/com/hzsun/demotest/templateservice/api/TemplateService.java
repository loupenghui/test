/**
 * 
 */
package com.hzsun.demotest.templateservice.api;

import com.hzsun.demotest.commons.beans.PageBean;
import com.hzsun.demotest.commons.beans.PageResult;
import com.hzsun.demotest.dto.template.TemplateSettingDTO;
import com.hzsun.demotest.qo.TemplateSettingQuery;

import java.util.List;

/**
 * 模板服务接口
 * @ClassName TemplateService
 * @Description 
 * @Author ZhaoXD Koliy
 * @Date 2018年5月8日 下午5:12:17
 */

public interface TemplateService {

	/**
	 * 新增模板
	 * @param templatedto 模板对象
	 * @return
	 */
	int insertTemplate(TemplateSettingDTO templatedto);

	/**
	 * 查询模板信息
	 * @param query 模板给的一些限制条件字段
	 * @param pageBean
	 * @return
	 */
	PageResult<TemplateSettingDTO> selectTemplateByCondition(TemplateSettingQuery query, PageBean pageBean);

	List<TemplateSettingDTO> selectTemplateByCondition(TemplateSettingQuery query);

	/**
	 * 根据主键 查询模板是否已存在
	 * @param applicationid
	 * @param paychannelid
	 * @return
	 */
	TemplateSettingDTO selectTemplateByPrimaryKey(String applicationid, String paychannelid);

	/**
	 * 根据主键 修改模板信息
	 * @param templatedto
	 */
	void modifyTemplate(TemplateSettingDTO templatedto);

	/**
	 * 通过 templateid 删除模板
	 * @param templateids
	 */
	void deleteByTemplateId(String[] templateids);

}
