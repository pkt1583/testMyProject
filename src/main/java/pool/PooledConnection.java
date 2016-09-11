package pool;

import sun.dc.pr.PRError;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

/**
 * Created by pankaj on 4/9/16.
 */
public class PooledConnection<T extends Connection> implements Connection {

    private final PooledConnectionDelegate pooledConnectionDelegate = new PooledConnectionDelegate();

    private BlockingQueue<PooledConnection<T>> connnectionPool;
    private T actualConnection;

    public PooledConnection(BlockingQueue<PooledConnection<T>> connnectionPool, T actualConnection) {
        this.connnectionPool = connnectionPool;
        this.actualConnection = actualConnection;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return pooledConnectionDelegate.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return pooledConnectionDelegate.prepareStatement(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return pooledConnectionDelegate.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return pooledConnectionDelegate.nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {

        pooledConnectionDelegate.setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return pooledConnectionDelegate.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {

        pooledConnectionDelegate.commit();
    }

    @Override
    public void rollback() throws SQLException {

        pooledConnectionDelegate.rollback();
    }

    @Override
    public void close() throws SQLException {

        pooledConnectionDelegate.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return pooledConnectionDelegate.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return pooledConnectionDelegate.getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {

        pooledConnectionDelegate.setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return pooledConnectionDelegate.isReadOnly();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {

        pooledConnectionDelegate.setCatalog(catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
        return pooledConnectionDelegate.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {

        pooledConnectionDelegate.setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return pooledConnectionDelegate.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return pooledConnectionDelegate.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {

        pooledConnectionDelegate.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return pooledConnectionDelegate.createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return pooledConnectionDelegate.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return pooledConnectionDelegate.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return pooledConnectionDelegate.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

        pooledConnectionDelegate.setTypeMap(map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {

        pooledConnectionDelegate.setHoldability(holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
        return pooledConnectionDelegate.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return pooledConnectionDelegate.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return pooledConnectionDelegate.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {

        pooledConnectionDelegate.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {

        pooledConnectionDelegate.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return pooledConnectionDelegate.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return pooledConnectionDelegate.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return pooledConnectionDelegate.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return pooledConnectionDelegate.prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return pooledConnectionDelegate.prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return pooledConnectionDelegate.prepareStatement(sql, columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return pooledConnectionDelegate.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return pooledConnectionDelegate.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return pooledConnectionDelegate.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return pooledConnectionDelegate.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return pooledConnectionDelegate.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {

        pooledConnectionDelegate.setClientInfo(name, value);
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {

        pooledConnectionDelegate.setClientInfo(properties);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return pooledConnectionDelegate.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return pooledConnectionDelegate.getClientInfo();
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return pooledConnectionDelegate.createArrayOf(typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return pooledConnectionDelegate.createStruct(typeName, attributes);
    }

    @Override
    public void setSchema(String schema) throws SQLException {

        pooledConnectionDelegate.setSchema(schema);
    }

    @Override
    public String getSchema() throws SQLException {
        return pooledConnectionDelegate.getSchema();
    }

    @Override
    public void abort(Executor executor) throws SQLException {

        pooledConnectionDelegate.abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

        pooledConnectionDelegate.setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return pooledConnectionDelegate.getNetworkTimeout();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return pooledConnectionDelegate.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return pooledConnectionDelegate.isWrapperFor(iface);
    }
}
