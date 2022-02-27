package com.fxz.serversystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fxz.common.core.entity.system.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Fxz
 * @version 1.0
 * @date 2022-02-27 18:34
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

	/**
	 * 获取部门树
	 */
	Dept getDeptTree();

}
