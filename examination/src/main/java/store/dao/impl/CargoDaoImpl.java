package store.dao.impl;

import store.dao.CargoDao;
import store.pojo.Cargo;
import store.pojo.Store;
import store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class CargoDaoImpl implements CargoDao {

    public int addCargo(Cargo cargo) {
        String sql = "insert into cargos(id, name, price, amount, created_at, s_id) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cargo.getId());
            preparedStatement.setString(2, cargo.getName());
            preparedStatement.setDouble(3, cargo.getPrice());
            preparedStatement.setInt(4, cargo.getAmount());
            preparedStatement.setDate(5, new java.sql.Date(cargo.getCreatedDate().getTime()));
            preparedStatement.setString(6, cargo.getStoreId());
            m = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public List<Cargo> getCargoListByStoreId(String storeId) {
        List<Cargo> list = new ArrayList<Cargo>();
        String sql = "select * from cargos where s_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, storeId);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Cargo cargo = new Cargo();
                cargo.setId(rs.getString("id"));
                cargo.setName(rs.getString("name"));
                cargo.setPrice(rs.getDouble("price"));
                cargo.setAmount(rs.getInt("amount"));
                cargo.setCreatedDate(rs.getDate("created_at"));
                cargo.setStoreId(rs.getString("s_id"));
                list.add(cargo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return list;
    }

    public int deleteCargoById(String deleteId) {
        String sql = "delete from cargos where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deleteId);
            m = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }

    public Cargo loadCargo(String id) {
        String sql = "select * from cargos where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Cargo cargo = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                cargo = new Cargo();
                cargo.setId(rs.getString("id"));
                cargo.setName(rs.getString("name"));
                cargo.setCreatedDate(rs.getDate("created_at"));
                cargo.setStoreId(rs.getString("s_id"));
                cargo.setAmount(rs.getInt("amount"));
                cargo.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, rs);
        }
        return cargo;
    }

    public int updateCargo(Cargo cargo) {
        String sql = "update cargos set name=?, price=?, amount=?, created_at=?, s_id=? where id=?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int m = 0;
        try {
            connection = DBUtil.createConnectionWithDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cargo.getName());
            preparedStatement.setDouble(2, cargo.getPrice());
            preparedStatement.setInt(3, cargo.getAmount());
            preparedStatement.setDate(4, new java.sql.Date(cargo.getCreatedDate().getTime()));
            preparedStatement.setString(5, cargo.getStoreId());
            preparedStatement.setString(6, cargo.getId());
            m = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
        return m;
    }
}
