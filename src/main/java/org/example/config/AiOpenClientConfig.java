package org.example.config;

import cn.huacloud.platform.sdk.client.AIOpenClient;
import cn.huacloud.platform.sdk.config.NerConfig;
import cn.huacloud.platform.sdk.thread.BatchExecutorConfig;
import com.easyopen.sdk.client.OpenClient;
import com.easyopen.sdk.common.OpenConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


/**
 * @program: AiHBase
 * @description:
 * @author: hux
 * @create: 2019-12-31 09:04
 **/
public class AiOpenClientConfig {

    @Value("${aiOpenClient.url}")
    private String url;

    @Value("${aiOpenClient.appKey}")
    private String appKey;

    @Value("${aiOpenClient.secret}")
    private String secret;

    @Bean
    public AIOpenClient aiOpenClient() {
        // 详细定制 NER 调用配置
        NerConfig nerConfig = new NerConfig();
        // NER 内部调用线程池最大连接数，根据硬件资源进行配置，不宜过大，能吃满硬件资源即可，过大会导致 tensorflow serving 503错误，默认20
        nerConfig.setMaxThread(5);
        // http接口线程信号量限制，默认2，保证服务端处理没有空档期即可，最大不要超过4个
        nerConfig.setSemaphoreCount(1);
        BatchExecutorConfig executorConfig = new BatchExecutorConfig();
        // 批量调用超时时间，默认3分钟，如果识别文书过长，或者同时识别的模型码值比较多，可以设置久一些，这里设置为15分钟
        executorConfig.setTimeoutSecond(24 * 60 * 60);
        // 批量调用重试次数，默认重试3次
        executorConfig.setDefaultRetry(3);
        nerConfig.setBatchExecutorConfig(executorConfig);
        OpenConfig openConfig = new OpenConfig();
        // sdk 连接超时时间
        openConfig.setConnectTimeoutSeconds(24 * 60 * 60);
        // sdk 读取超时时间
        openConfig.setReadTimeoutSeconds(24 * 60 * 60);
        OpenClient openClient = new OpenClient("http://172.16.121.31:7416/api", "test", "123456", openConfig);
        return new AIOpenClient(openClient, nerConfig);
    }
}
