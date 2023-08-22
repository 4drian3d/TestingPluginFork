package org.kingxrp.external;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBase {
    private final HikariDataSource source;

    public DataBase(
            final String host,
            final int port,
            final String database,
            final String username,
            final String password
    ) {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);

        hikariConfig.addDataSourceProperty("cachePrepStmts", true);
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", 250);
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        hikariConfig.addDataSourceProperty("useServerPrepStmts", true);

        this.source = new HikariDataSource(hikariConfig);
    }

    public void disconnect() {
        this.source.close();
    }

    public ResultSet executeQuery(final String sql) {
        try (final Statement statement = this.source.getConnection().createStatement()) {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            return null;
        }
    }
}
