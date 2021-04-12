package moeblocks.data.sql;

import moeblocks.init.MoeData;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.ReportedException;
import net.minecraft.world.server.ServerWorld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Table<R extends Row> {
    private final List<Column> columns = new ArrayList<>();
    private final String name;
    private ServerWorld world;
    private Connection connection;

    public Table(String name, Column... columns) {
        this.name = name;
        this.addColumn(new Column.AsUUID(this, "DatabaseID", "PRIMARY_KEY"));
        this.addColumn(new Column.AsPosition(this, "Pos"));
        this.addColumn(new Column.AsUUID(this, "PlayerUUID"));
        for (Column column : columns) {
            this.addColumn(column);
        }
    }

    public void setWorld(ServerWorld world) {
        this.world = world;
    }

    public List<Column> getColumns() {
        return new ArrayList<>(this.columns);
    }

    public void addColumn(Column column) {
        this.columns.add(column);
        column.afterAdd(this);
    }

    public String getName() {
        return this.name;
    }

    public List<R> select(String SQL, List<Column> columns) {
        ArrayList<R> query = new ArrayList<>();
        try (PreparedStatement sql = this.open(SQL)) {
            for (int i = 1; i <= columns.size(); ++i) { columns.get(i - 1).forSet(i, sql); }
            System.out.println(sql);
            ResultSet set = sql.executeQuery();
            while (set.next()) { query.add(this.getRow(set)); }
            this.shut();
        } catch (SQLException e) {
            this.rescue(e);
        } finally {
            return query;
        }
    }

    public List<R> select(String SQL) {
        return this.select(SQL, new ArrayList<>());
    }

    public R find(UUID uuid) {
        List<R> query = this.select(String.format("SELECT * FROM %s WHERE (DatabaseID = '%s') LIMIT 1;", this.name, uuid));
        return query.isEmpty() ? null : query.get(0);
    }

    public void update(String SQL, List<Column> columns) {
        try (PreparedStatement sql = this.open(SQL)) {
            for (int i = 1; i <= columns.size(); ++i) { columns.get(i - 1).forSet(i, sql); }
            System.out.println(sql);
            sql.executeUpdate();
            this.shut();
        } catch (SQLException e) {
            this.rescue(e);
        }
    }

    public void update(String SQL) {
        this.update(SQL, new ArrayList<>());
    }

    public void create() {
        String columns = "";
        for (Column column : this.columns) { columns += String.format("%s %s %s,", column.getColumn(), column.getType(), column.getExtra()); }
        columns = columns.substring(0, columns.length() - 1);
        try (PreparedStatement sql = this.open(String.format("CREATE TABLE IF NOT EXISTS %s (%s);", this.name, columns))) {
            System.out.println(sql);
            sql.execute();
            this.shut();
        } catch (SQLException e) {
            this.rescue(e);
        }
    }

    public void create(ServerWorld world) {
        this.setWorld(world);
        this.create();
    }

    public abstract R getRow(ResultSet set) throws SQLException;

    private PreparedStatement open(String SQL) throws SQLException {
        this.connection = MoeData.get(this.world).getConnection();
        return this.connection.prepareStatement(SQL);
    }

    private void shut() throws SQLException {
        MoeData.get(this.world).free(this.connection);
    }

    private void rescue(SQLException e) {
        throw new ReportedException(new CrashReport("DB failed.", e));
    }
}
