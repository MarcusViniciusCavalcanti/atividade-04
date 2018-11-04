<
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Shows">
    <jsp:body>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Banda</th>
                <th scope="col">data</th>
                <th scope="col">local</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${shows}" var="show">
                <tr>
                    <th scope="row">${show.id}</th>
                    <th><a href="${pageContext.request.contextPath}/user_show?id=${show.id}">${show.banda}</a></th>
                    <th>${show.date}</th>
                    <th>${show.eventLocale.city}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:template>