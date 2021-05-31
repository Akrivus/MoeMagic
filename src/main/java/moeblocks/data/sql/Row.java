package moeblocks.data.sql;

import moeblocks.data.IModelEntity;
import net.minecraft.nbt.CompoundNBT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Row<E extends IModelEntity> {
    protected static final int DATABASE_ID  =  0;
    protected static final int POS          =  1;
    protected static final int POS_X        =  2;
    protected static final int POS_Y        =  3;
    protected static final int POS_Z        =  4;
    protected static final int PLAYER_UUID  =  5;
    private final Table table;
    private final List<Column> columns;
    private final String name;

    public Row(Table table) {
        this.table = table;
        this.columns = table.getColumns();
        this.name = table.getName();
    }

    public Row(Table table, ResultSet set) throws SQLException {
        this(table);
        for (int i = 0; i < this.columns.size(); ++i) {
            this.columns.get(i).setFromSet(i + 1, set);
        }
    }

    public Row(Table table, CompoundNBT compound) {
        this(table);
        this.read(compound);
    }

    public Row(Table table, E entity) {
        this(table);
        this.sync(entity);
    }

    public Column get(int i) {
        return this.columns.get(i);
    }

    public UUID getID() {
        return (UUID) this.get(DATABASE_ID).get();
    }

    public void insert() {
        this.table.update(String.format("INSERT INTO %s(%s) VALUES (%s);", this.name, this.getColumnNames(), this.getQuestionMarks()), this.getColumns());
    }

    public void update() {
        this.table.update(String.format("UPDATE %s SET %s WHERE (DatabaseID = '%s');", this.name, this.getDirtyColumnSetters(), this.getID()), this.getDirtyColumns());
    }

    public void delete() {
        this.table.update(String.format("DELETE FROM %s WHERE (DatabaseID = '%s');", this.name, this.getID()));
    }

    public void update(E entity) {
        this.sync(entity);
        this.update();
    }

    public void read(CompoundNBT compound) {
        for (Column column : this.getColumns()) {
            column.read(compound);
        }
    }

    public CompoundNBT write(CompoundNBT compound) {
        compound.putString("Table", this.name);
        for (Column column : this.getColumns()) {
            column.write(compound);
        }
        return compound;
    }

    public CompoundNBT write() {
        return this.write(new CompoundNBT());
    }

    public List<Column> getColumns() {
        return this.columns;
    }

    public List<Column> getColumns(int... indexes) {
        List<Column> columns = new ArrayList<>();
        for (int index : indexes) {
            columns.add(this.columns.get(index));
        }
        return columns;
    }

    public List<Column> getDirtyColumns() {
        List<Column> columns = new ArrayList<>();
        for (Column column : this.columns) {
            if (column.isDirty()) { columns.add(column); }
        }
        return columns;
    }

    private String getColumnNames(List<Column> columns) {
        String names = "";
        for (Column column : columns) { names += String.format("%s, ", column.getColumn()); }
        return names.substring(0, names.length() - 2);
    }

    private String getDirtyColumnNames() {
        return this.getColumnNames(this.getDirtyColumns());
    }

    private String getColumnNames() {
        return this.getColumnNames(this.getColumns());
    }

    private String getQuestionMarks(List<Column> columns) {
        String marks = "";
        for (Column column : columns) { marks += "?, "; }
        return marks.substring(0, marks.length() - 2);
    }

    private String getDirtyQuestionMarks() {
        return this.getColumnNames(this.getDirtyColumns());
    }

    private String getQuestionMarks() {
        return this.getQuestionMarks(this.getColumns());
    }

    private String getColumnSetters(List<Column> columns) {
        String names = "";
        for (Column column : columns) { names += String.format("%s = ?, ", column.getColumn()); }
        return names.substring(0, names.length() - 2);
    }

    private String getDirtyColumnSetters() {
        return this.getColumnSetters(this.getDirtyColumns());
    }

    private String getColumnSetters() {
        return this.getColumnSetters(this.getColumns());
    }

    public abstract void sync(E entity);

    public abstract void load(E entity);

    @Override
    public String toString() {
        return String.format("%s[%s]", this.table, this.get(DATABASE_ID).get());
    }
}
