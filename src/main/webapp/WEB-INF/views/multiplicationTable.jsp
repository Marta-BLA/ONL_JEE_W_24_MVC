<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 10.04.2022
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 2px solid black;
            border-collapse: collapse;
        }

        td, th {
            padding: 15px;
            text-align: center;
            border: 1px solid gray;
            border-collapse: collapse;
        }

        th {
            background-color: gray;
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<table>
    <c:forEach begin="0" end="${rows}" var="row">
        <tr>
            <c:forEach begin="0" end="${cols}" var="col">
                <c:choose>
                    <c:when test="${row == 0 && col == 0}">
                        <th>
                                x
                        </th>
                    </c:when>
                    <c:when test="${row == 0}">
                        <th>
                            ${col}
                        </th>
                    </c:when>
                    <c:when test="${col == 0}">
                        <td>
                            ${row}
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>
                            ${col * row}
                        </td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
