<jsp:useBean id="user" scope="request" type="br.edu.utfpr.tsi.atividadejpa.model.User"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Engressos de: ${user.name}">
    <jsp:body>
        <a href="${pageContext.request.contextPath}/user_details?id=${user.id}">Usuário que mais do: ${user.name}</a>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Banda</th>
                <th scope="col">total</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sales}" var="ticket">
                <tr>
                    <th scope="row">${ticket.id}</th>
                    <th>${ticket.banda}</th>
                    <th>${ticket.amountSales}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:template>