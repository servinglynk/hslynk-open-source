<?xml version="1.0" encoding="UTF-8" ?>
<%@page language="java" contentType="text/xml; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@page import="javax.sql.DataSource" %><%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%
    String version = "${pom.version}";
    String version_status = "NOT_OK";
%>

<Results>
    <ComponentResult>
        <ComponentName>version</ComponentName>
        <Output><%=version %></Output>
    </ComponentResult>
    <ComponentResult>
        <ComponentName>database</ComponentName>
        <Status>ok</Status>
    </ComponentResult>
</Results>