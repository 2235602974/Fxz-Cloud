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

package com.fxz.common.captcha.config;

import com.anji.captcha.service.CaptchaCacheService;
import com.anji.captcha.service.impl.CaptchaServiceFactory;
import com.fxz.common.captcha.properties.AjCaptchaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 存储策略自动配置.
 *
 * @author fxz
 */
@Configuration(proxyBeanMethods = false)
public class AjCaptchaStorageAutoConfiguration {

	@Bean(name = "AjCaptchaCacheService")
	public CaptchaCacheService captchaCacheService(AjCaptchaProperties ajCaptchaProperties) {
		return CaptchaServiceFactory.getCache(ajCaptchaProperties.getCacheType().name());
	}

}
