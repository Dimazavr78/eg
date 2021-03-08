package org.company.app.data.manager;

import org.company.app.data.entity.ClientEntity;
import org.company.app.data.entity.DTPEntity;
import org.company.app.util.MysqlDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DtpEntityManager {
    private MysqlDatabase database;

    public DtpEntityManager(MysqlDatabase database) {
        this.database = database;
    }

    public void addDtp(DTPEntity dtp) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "INSERT INTO situations_weather(service,area,area_radius,time_of_detect,Situations_weathercol,tip,count_cars ) values(?,?,?,?,?,?,?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setString(1, String.valueOf(dtp.getStatus()));
            s.setString(2, dtp.getArea());
            s.setString(3, String.valueOf(dtp.getArea_radius()));
            s.setTimestamp(4, new Timestamp(dtp.getTime_of_detect().getTime()));
            s.setString(5, dtp.getSituations_weathercol());
            s.setString(6, String.valueOf(dtp.getTip()));
            s.setString(7, String.valueOf(dtp.getKordFild()));

            s.executeUpdate();

            ResultSet keys = s.getGeneratedKeys();
            if (keys.next()) {
                dtp.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("Car not added");
        }

    }
    public List<DTPEntity> getAll() throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM situations_weather";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<DTPEntity> clients = new ArrayList<>();
            while(resultSet.next()) {
                clients.add(new DTPEntity(
                        resultSet.getInt("id_sit_weather"),
                        resultSet.getString("service").charAt(0),
                        resultSet.getString("tip").charAt(0),
                        resultSet.getString("area"),
                        resultSet.getString("area_radius"),
                        resultSet .getTimestamp("time_of_detect"),
                        resultSet.getString("Situations_weathercol"),
                        resultSet.getString("road_quality"),
                        resultSet.getString("count_cars")
                ));
            }
            return clients;
        }
    }
    public int deleteById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "DELETE FROM Client WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            return s.executeUpdate();
        }
    }

    public int delete(DTPEntity client) throws SQLException
    {
        return deleteById(client.getId());
    }

    public int update(DTPEntity client) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "UPDATE situations_weather SET service=?, area=?, area_radius=?, time_of_detect=?, Situations_weathercol=?, road_quality=?, count_cars=? WHERE id_sit_weather=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, String.valueOf(client.getStatus()));
            s.setString(2, client.getArea());
            s.setString(3, client.getArea_radius());
            s.setTimestamp(4, new Timestamp(client.getTime_of_detect().getTime()));
            s.setString(5, client.getSituations_weathercol());
            s.setString(6, client.getRoad_quality());
            s.setString(7, client.getKordFild());
            s.setInt(8, client.getId());

            return s.executeUpdate();
        }
    }


}
