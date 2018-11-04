<jsp:useBean id="show" scope="request" type="br.edu.utfpr.tsi.atividadejpa.model.Show"/>
<jsp:useBean id="major_price" scope="request" type="br.edu.utfpr.tsi.atividadejpa.model.User"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Show da banda: ${show.banda}">

    <p>Usuário que mais doou: ${major_price.name}</p>
    <jsp:body>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Age</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <th scope="row"><a>${user.id}</a></th>
                    <th>${user.name}</th>
                    <th>${user.age}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:template>