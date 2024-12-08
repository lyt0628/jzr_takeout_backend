package icu.lyt0628.jzr_takeout.repo.mapper.util;

import icu.lyt0628.jzr_takeout.service.domain.OrderStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderStatusTypeHandler extends BaseTypeHandler<OrderStatus> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrderStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public OrderStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        var value = rs.getString(columnName);
        return value == null ? null : OrderStatus.valueOf(value);
    }

    @Override
    public OrderStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        var value = rs.getString(columnIndex);
        return value == null ? null : OrderStatus.valueOf(value);
    }

    @Override
    public OrderStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        var value = cs.getString(columnIndex);
        return value == null ? null : OrderStatus.valueOf(value);
    }
}
