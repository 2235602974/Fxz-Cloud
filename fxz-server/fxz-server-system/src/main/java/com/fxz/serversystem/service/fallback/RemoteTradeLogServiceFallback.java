package com.fxz.serversystem.service.fallback;

import com.fxz.common.core.entity.system.TradeLog;
import com.fxz.serversystem.service.IRemoteTradeLogService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author fxz
 */
@Slf4j
@Component
public class RemoteTradeLogServiceFallback implements FallbackFactory<IRemoteTradeLogService> {

	@Override
	public IRemoteTradeLogService create(Throwable throwable) {
		return tradeLog -> {
			log.info("调用失败:", throwable);
			throw new RuntimeException();
		};
	}

}