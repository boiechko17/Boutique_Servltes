package com.boiechko.controller;

import com.boiechko.entity.Person;
import com.boiechko.service.implementations.JavaMailService;
import com.boiechko.service.implementations.PersonServiceImpl;
import com.boiechko.service.interfaces.PersonService;
import com.boiechko.utils.ConvertDateUtil;
import com.boiechko.utils.HashingPassword.HashPasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

@WebServlet("/registration")
public class RegistrationsServlet extends HttpServlet {

    private final PersonService personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String activationCode = request.getParameter("activationCode");

        if (activationCode != null) {

            final Person person = personService.getPersonByColumn("activationCode", activationCode);
            person.setActivationCode(null);

            if (personService.updatePerson(person)) {
                response.sendRedirect("/login");
            }

        } else {
            request.getRequestDispatcher("/jsp-pages/registration.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final String date = request.getParameter("date");
        final String email = request.getParameter("email");

        Person person = personService.getPersonByColumn("username", username);

        if (person.getUsername() == null) {

            final String hashedPassword = HashPasswordUtil.hashPassword(password);

            person = new Person(username, hashedPassword, ConvertDateUtil.convertDate(date), email, UUID.randomUUID().toString());

            if (personService.addPerson(person)) {

                JavaMailService.sendConfirmRegistrationEmail(person.getEmail(), "confirmRegistration", person);

            } else {
                response.sendError(SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.sendError(SC_FORBIDDEN);
        }
    }
}
