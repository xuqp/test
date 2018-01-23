package com.my.web.source;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ������applicationContext �У��ֲ߳̾�����ThreadLocal contextHolder ���浱ǰ��Ҫ������Դ���ͣ���
 * DataSourceSwitch. setDataSourceType(DataSourceInstances.XXX)
 * ���浱ǰ��Ҫ������Դ���͵�ʱ��DataSources ��ӵ�ǰ�߳��в����̱߳���������Դ���ͣ��Ӷ�����ʹ�ú�������Դ
 * 
 * @author
 */
public class DataSources extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceSwitch.getDataSourceType();
	}
}