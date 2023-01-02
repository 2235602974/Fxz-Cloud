/*
 * COPYRIGHT (C) 2022 Art AUTHORS(fxzcloud@gmail.com). ALL RIGHTS RESERVED.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.art.common.dataPermission.dept.service;

import com.art.common.core.entity.DeptDataPermissionRespEntity;
import com.art.common.core.exception.FxzException;
import com.art.common.core.result.ResultOpt;
import com.art.common.security.entity.FxzAuthUser;
import com.art.system.api.role.RoleServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 基于部门的数据权限 Framework Service
 *
 * @author fxz
 */
@Slf4j
@RequiredArgsConstructor
public class DeptDataPermissionService {

	private final RoleServiceApi roleServiceApi;

	/**
	 * 获得登陆用户的部门数据权限
	 * @param loginUser 登陆用户
	 * @return 部门数据权限
	 */
	public DeptDataPermissionRespEntity getDeptDataPermission(FxzAuthUser loginUser) {
		log.info("查询用户:{}的数据权限", loginUser.getUsername());

		ResultOpt<DeptDataPermissionRespEntity> opt = ResultOpt.ofNullable(roleServiceApi.getDataPermission());
		return opt.assertSuccess(r -> new FxzException(String.format("查询数据权限接口失败:%s", loginUser.getUsername())))
				.consumerData(d -> log.info("数据权限是:{}", d)).peek().getData();
	}

}
