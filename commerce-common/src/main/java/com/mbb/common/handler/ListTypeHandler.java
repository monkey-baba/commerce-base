package com.mbb.common.handler;

import com.alibaba.fastjson.JSON;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class ListTypeHandler extends BaseTypeHandler<List> {

	@Override
	public void setNonNullParameter(final PreparedStatement ps, final int index, final List map,
	                                final JdbcType jdbcType) throws SQLException {
		ps.setString(index, map != null ? JSON.toJSONString(map) : null);
	}

	@Override
	public List getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
		return this.jsonToMap(rs.getString(columnName));
	}

	@Override
	public List getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
		return this.jsonToMap(rs.getString(columnIndex));
	}

	@Override
	public List getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		return this.jsonToMap(cs.getString(columnIndex));
	}

	private List jsonToMap(final String json) {
		if (StringUtils.isEmpty(json)) {
			return Collections.emptyList();
		}
		return JSON.parseArray(json);
	}

}
