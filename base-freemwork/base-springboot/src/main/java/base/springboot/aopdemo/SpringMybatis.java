package base.springboot.aopdemo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author Clay
 * @date 2019/7/8 17:50
 */
public class SpringMybatis {

//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean() {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource());
//
//        bean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
//
//        // 添加插件
//        bean.setPlugins(MybatisUtil.getInterceptor());
//
//        // 添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
//        bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//        return bean.getObject();
//    }
}
