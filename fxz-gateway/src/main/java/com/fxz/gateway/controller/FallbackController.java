package com.fxz.gateway.controller;

import com.fxz.common.core.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Fxz
 * @version 1.0
 * @date 2021-12-07 11:27
 */
@RestController
public class FallbackController {

	@RequestMapping("fallback/{name}")
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Mono<Result<Void>> systemFallback(@PathVariable String name) {
		String response = String.format("访问%s超时或者服务不可用", name);
		return Mono.just(Result.failed(response));
	}

}
