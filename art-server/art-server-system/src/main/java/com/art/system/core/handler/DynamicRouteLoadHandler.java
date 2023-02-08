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

package com.art.system.core.handler;

import com.art.common.mq.redis.core.RedisMQTemplate;
import com.art.system.api.route.mq.RouteMessage;
import com.art.system.service.RouteConfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Fxz
 * @version 0.0.1
 * @date 2022/8/20 14:17
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DynamicRouteLoadHandler implements ApplicationRunner {

	private final RouteConfService routeConfService;

	private final RedisMQTemplate redisMQTemplate;

	/**
	 * 加载路由信息到redis
	 */
	@Override
	public void run(ApplicationArguments args) {
		// 发送消息告诉网关加载路由信息
		redisMQTemplate.send(new RouteMessage(routeConfService.findAll()));
	}

}
