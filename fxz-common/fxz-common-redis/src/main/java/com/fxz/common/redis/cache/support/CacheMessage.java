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

package com.fxz.common.redis.cache.support;

import com.fxz.common.mq.redis.stream.AbstractStreamMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author fxz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheMessage extends AbstractStreamMessage implements Serializable {

	private static final long serialVersionUID = 3987211310442078199L;

	private String cacheName;

	private Object key;

	@Override
	public String getStreamKey() {
		return "cache:redis:caffeine:topic";
	}

}
