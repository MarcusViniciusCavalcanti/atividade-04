<jsp:useBean id="user" scope="request" type="br.edu.utfpr.tsi.atividadejpa.model.User"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Detalhes do Usuário">
    <jsp:body>

        <div>
            <ul class="list-group">
                <li class="list-group-item">Nome: ${user.name}</li>
                <li class="list-group-item">Idade: ${user.age}</li>
            </ul>
        </div>

        <div>
            <ul class="list-group">
                <li class="list-group-item">
                    <p>Ingressos adiquiridos</p>
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Total</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Usuário</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${user.ticketShows}" var="ticket">
                            <tr>
                                <th scope="row">${ticket.id}</th>
                                <th>${ticket.amount}</th>
                                <th>${ticket.price}</th>
                                <th><a>${ticket.show.banda}</a></th>
                                <th><a>${ticket.show.eventLocale}</a></th>
                                <th>${ticket.show.date}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </li>
            </ul>
        </div>



    </jsp:body>
</t:template>