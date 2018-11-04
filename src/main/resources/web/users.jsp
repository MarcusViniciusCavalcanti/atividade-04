
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Usuários">
    <jsp:body>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">idade</th>
                    <th scope="col">Ingressos</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allusers}" var="user">
                    <tr>
                        <th scope="row">${user.id}</th>
                        <th>${user.name}</th>
                        <th>${user.age}</th>
                        <th><a href="${pageContext.request.contextPath}/tickets_per_user?id=${user.id}">total de ingressos pedidos: ${user.ticketShows}</a></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:template>