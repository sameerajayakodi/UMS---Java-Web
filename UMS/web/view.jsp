<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="UMSPakage.UserOperation"%>
<%@page import="UMSPakage.User"%>


<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
          <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp,container-queries"></script>
    </head>
    <body class="bg-slate-900 text-white font-mono">
        <h1 class="text-blue-400 font-bold text-xl"><a href="index.html">Add New User</a></h1>
            <h1 class="text-amber-400 font-bold text-2xl">Welcome To User Management System</h1>
            <h2 class="text-white font-semibold text-md">All User Details</h2>
        
<table border='1' width='100%' class="border border-slate-500  table-fixed">
    <tr class="bg-blue-700">
        <td>ID</td>
        <td>Book Name</td>
        <td>Author</td>
        <td>Price</td>
         <td>Edit Book</td>
        <td>Delete Book</td>
    </tr>
    <% 
        List<User> list = UserOperation.viewAllUsers();
        for(User user : list){
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getEmail()%></td>
        <td><%= user.getPassword()%></td>
        <td><%= user.getPhone()%></td>
        <td><a href="edit.jsp?id=<%= user.getId() %> " class=" pl-2 pr-2 bg-emerald-600 hover:bg-emerald-700 text-gray-800 font-semibold  border border-gray-400 rounded shadow text-white">Edit User</a></td>
        <td><a href="deleteServlet?id=<%= user.getId() %>" class="pl-2 pr-2 bg-rose-600 hover:bg-rose-700 text-gray-800 font-semibold  border border-gray-400 rounded shadow text-white">Delete User</a></td>
        
    </tr>
    <% 
        }
    %>
</table>

    </body>
</html>
