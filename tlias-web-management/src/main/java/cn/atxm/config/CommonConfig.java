package cn.atxm.config;

import cn.atxm.utils.AliyunOSSOperator;
import cn.atxm.utils.AliyunOSSProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/12
 */
@Configuration
public class CommonConfig {
    @Bean
    public AliyunOSSOperator aliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties){
        return new AliyunOSSOperator(aliyunOSSProperties);
    }
}
