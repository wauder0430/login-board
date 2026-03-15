package com.study.loginboard.controller;

import com.study.loginboard.model.dao.MemberDao;
import com.study.loginboard.model.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDao dao = new MemberDao();
        request.setCharacterEncoding("UTF-8");

        // 1. 폼 데이터 받기
        String name     = request.getParameter("name");
        String id       = request.getParameter("id");
        String password = request.getParameter("password");
        String jumin    = request.getParameter("jumin");
        String nickname  = request.getParameter("nickname");
        String email    = request.getParameter("email");
        String phone    = request.getParameter("phone");
        String address  = request.getParameter("address");

        // 2. DTO에 담기
        MemberDto dto = new MemberDto();
        dto.setName(name);
        dto.setId(id);
        dto.setPassword(password);
        dto.setJumin(jumin);
        dto.setNickname(nickname);
        dto.setEmail(email);
        dto.setPhone(phone);
        dto.setAddress(address);

        // 3. DAO 호출
        int result = dao.register(dto);

        // 4. 결과 처리
        if (result > 0) {
            response.sendRedirect("index.jsp");
        } else {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('회원가입에 실패했습니다.');");
            out.println("history.back();");
            out.println("</script>");
        }

    }
}
