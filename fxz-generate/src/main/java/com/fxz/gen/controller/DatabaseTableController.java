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

package com.fxz.gen.controller;

import com.fxz.common.core.param.PageParam;
import com.fxz.common.mp.result.PageResult;
import com.fxz.common.mp.result.Result;
import com.fxz.gen.entity.DatabaseTable;
import com.fxz.gen.service.impl.DatabaseTableServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库表信息
 *
 * @author Fxz
 * @version 1.0
 * @date 2022-03-04 9:21
 */
@RestController
@RequestMapping("/gen/table")
@RequiredArgsConstructor
public class DatabaseTableController {

	private final DatabaseTableServiceImpl databaseTableService;

	/**
	 * 分页查询基础表信息
	 * @param pageParam 分页参数
	 * @param param 查询参数
	 * @return 分页信息
	 */
	@GetMapping("/page")
	public Result<PageResult<DatabaseTable>> page(PageParam pageParam, DatabaseTable param, String dsName) {
		return Result.success(PageResult.success(databaseTableService.page(pageParam, param, dsName)));
	}

}
