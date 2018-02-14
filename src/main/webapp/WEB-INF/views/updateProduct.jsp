<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<main style="height:100%">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>Редактировать продукт</h1>
            </div>
            <div class='right-button-margin'>
                <a href='/rental/' class='btn btn-default pull-right'>Назад к списку</a>
            </div>


            <form:form action="/rental/updateproduct/" modelAttribute="product" method="post">
                <table class='table table-hover table-responsive table-bordered'>
                    <tr>
                        <td>Наименование</td>
                        <form:hidden path="id"/>
                        <td><form:input path="title" cssClass="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Стоимость</td>
                        <td><form:input path="cost" cssClass="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Количество</td>
                        <td><form:input path="amount" cssClass="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Категория</td>
                        <td><form:select path="category.id" items = "${categories}" cssClass="form-control"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="submit" class="btn btn-primary">Добавить</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</main>
<%@ include file="footer.jsp" %>