package com.imooc.o2o.dao.split;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

/**
 * @author erpljq
 * @date 2018/6/21
 */
@Slf4j
@Intercepts({@Signature(type = Executor.class,method = "update", args = {MappedStatement.class, Object.class}),
    @Signature(type = Executor.class, method = "query",args =
            {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class DynamicDataSourceInterceptor implements Interceptor{

    private static final String REGEX = ".*insert\\u0002.*|.*delete\\u0020.*|.*update\\0020.*";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //判断当前执行的有没有事务
        boolean synchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();
        Object[] objects = invocation.getArgs();
        MappedStatement ms = (MappedStatement)objects[0];
        String lookupKey = DynamicDataSourceHolder.DB_MASTER;
        if (synchronizationActive != true){
            //读方法
            if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)){
                // selectKey 为自增id查询注解(select last_insert_id())方法, 就使用主库
                if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)){
                    lookupKey = DynamicDataSourceHolder.DB_MASTER;
                }else {
                    BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                    String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replace("[\\t\\n\\r]"," ");
                    if (sql.matches(REGEX)){
                        lookupKey = DynamicDataSourceHolder.DB_MASTER;
                    }else {
                        lookupKey = DynamicDataSourceHolder.DB_SLAVE;
                    }
                }
            }
        }else {
            lookupKey = DynamicDataSourceHolder.DB_MASTER;
        }
        log.debug("设置方法[{}] use[{}] Strategy,SqlCommanType[{}]..",ms.getId(),lookupKey,ms.getSqlCommandType().name());
        DynamicDataSourceHolder.setDbType(lookupKey);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor){
            return Plugin.wrap(target,this);
        }else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
