
package com.study.loginboard.controller;

import com.study.loginboard.model.dao.MemberDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checknickname")
public class CheckNickname extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDao dao = new MemberDao();

        // 1. JSP에서 보낸 id 파라미터 받기
        String nickname = request.getParameter("nickname");

        // 2. DB 중복 확인
        int result = dao.checkNickname(nickname);

        // 3. JSON 형식으로 응답 (JSP의 fetch가 이걸 받음)
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("{\"result\":" + result + "}");

    }
}
