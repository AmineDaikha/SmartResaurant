package BddPackage;

import Models.Provider;
import Models.ProviderJob;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProviderJobOperation extends BDD<ProviderJob> {
    @Override
    public boolean insert(ProviderJob o) {
        //INSERT INTO `PROVIDER_jOB`(`ID`, `TYPE`) VALUES ([value-1],[value-2])
        boolean ins = false;
        String query = "INSERT INTO `PROVIDER_jOB`(`TYPE`) VALUES (?)";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1,o.getName());
            int insert = preparedStmt.executeUpdate();
            if(insert != -1) ins = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ins;
    }

    @Override
    public boolean update(ProviderJob o1, ProviderJob o2) {
        boolean upd = false;
        String query = "UPDATE `PROVIDER_jOB` SET `TYPE`=? WHERE `ID` = ? ";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1,o1.getName());
            preparedStmt.setInt(   2,o2.getId());
            int update = preparedStmt.executeUpdate();
            if(update != -1) upd = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return upd;    }

    @Override
    public boolean delete(ProviderJob o) {
        boolean del = false;
        String query = "DELETE FROM `PROVIDER_jOB` WHERE ID = ? ";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1,o.getId());
            int delete = preparedStmt.executeUpdate();
            if(delete != -1) del = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return del;
    }

    @Override
    public boolean isExist(ProviderJob o) {
        return false;
    }

    @Override
    public ArrayList<ProviderJob> getAll() {
        ArrayList<ProviderJob> list = new ArrayList<>();
        String query = "SELECT * FROM `PROVIDER_jOB`";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()){
                ProviderJob providerJob = new ProviderJob();
                providerJob.setId(resultSet.getInt("ID"));
                providerJob.setName(resultSet.getString("TYPE"));
                list.add(providerJob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
