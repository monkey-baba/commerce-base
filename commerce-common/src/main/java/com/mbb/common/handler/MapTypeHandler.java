package com.mbb.common.handler;

import com.alibaba.fastjson.JSON;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class MapTypeHandler extends BaseTypeHandler<Map> {

	@Override
	public void setNonNullParameter(final PreparedStatement ps, final int index, final Map map,
	                                final JdbcType jdbcType) throws SQLException {
		ps.setString(index, map != null ? JSON.toJSONString(map) : null);
	}

	@Override
	public Map getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
		return this.jsonToMap(rs.getString(columnName));
	}

	@Override
	public Map getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
		return this.jsonToMap(rs.getString(columnIndex));
	}

	@Override
	public Map getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		return this.jsonToMap(cs.getString(columnIndex));
	}

	private Map jsonToMap(final String json) {
		if (StringUtils.isEmpty(json)) {
			return Collections.emptyMap();
		}
		return JSON.parseObject(json);
	}

}
