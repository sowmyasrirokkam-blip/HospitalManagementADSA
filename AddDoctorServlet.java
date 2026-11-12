package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;
import services.DoctorService;

@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int doctorId = Integer.parseInt(
                request.getParameter("doctorId"));

        String name = request.getParameter("name");
        String specialization =
                request.getParameter("specialization");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String department =
                request.getParameter("department");

        Doctor doctor = new Doctor(
                doctorId,
                name,
                specialization,
                phone,
                email,
                department
        );

        DoctorService.addDoctor(doctor);

        response.setContentType("text/html");

        response.getWriter().println(
                "<html><body>"
                + "<h2>Doctor Added Successfully!</h2>"
                + "<p>Doctor ID: " + doctorId + "</p>"
                + "<p>Name: " + name + "</p>"
                + "<a href='doctors.html'>Back to Doctor Management</a>"
                + "</body></html>"
        );
    }
}