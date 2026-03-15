package com.study.loginboard.model.dao;

import com.study.loginboard.model.dto.MemberDto;
import com.study.loginboard.util.DBUtil;

import java.sql.*;

public class MemberDao {


    public int register(MemberDto dto) {


        try {

            String sql = "insert into member (member_seq, name, id, password, jumin, nickname, email, phone, address, role, join_date, update_date, del_yn) values (member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, default, default, null, default)";

            Connection conn  = DBUtil.getConnection();
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getName());
            pstat.setString(2, dto.getId());
            pstat.setString(3, dto.getPassword());
            pstat.setString(4, dto.getJumin());
            pstat.setString(5, dto.getNickname());
            pstat.setString(6, dto.getEmail());
            pstat.setString(7, dto.getPhone());
            pstat.setString(8, dto.getAddress());

            int result = pstat.executeUpdate();

            DBUtil.close(conn, pstat, null);

            return result;


        } catch (Exception e) {
            e.printStackTrace();
        }


        return 0;
    }

    public int checkId(String id) {

        try {

            String sql = "select id from member where id = ?";

            Connection conn  = DBUtil.getConnection();
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);

            ResultSet rs = pstat.executeQuery();

            if(rs.next()) {
                DBUtil.close(conn, pstat, rs);

                return 0;
            }

            DBUtil.close(conn, pstat, rs);
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int checkNickname(String nickname) {
        try {

            String sql = "select id from member where nickname = ?";

            Connection conn  = DBUtil.getConnection();
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, nickname);

            ResultSet rs = pstat.executeQuery();

            if(rs.next()) {
                DBUtil.close(conn, pstat, rs);

                return 0;
            }

            DBUtil.close(conn, pstat, rs);
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
