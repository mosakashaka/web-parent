package org.mosakashaka.web.base.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({Object.class})
@MappedJdbcTypes({JdbcType.OTHER})
public class JsonTypeHandler<T> extends BaseTypeHandler<T> {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> type;

    public JsonTypeHandler(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    private T parse(String json) {
        try {
            if ((json == null) || (json.length() == 0)) {
                return null;
            }
            return objectMapper.readValue(json, this.type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public T getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return parse(rs.getString(columnName));
    }

    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parse(rs.getString(columnIndex));
    }

    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parse(cs.getString(columnIndex));
    }

    public void setNonNullParameter(PreparedStatement ps, int columnIndex, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(columnIndex, toJsonString(parameter));
    }
}
