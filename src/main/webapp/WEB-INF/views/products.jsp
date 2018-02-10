<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>
<main>
    <div class="container-fluid">
        <div class="row">
            <%@ include file="leftside.jsp" %>
            <div class="col-md-12 col-xs-12 col-lg-10">
                <div id="products">
                    <div class="page-header">
                        <h1>Продукты</h1>
                    </div>
                    <div class='right-button-margin'>
                        <a href='/rental/createproduct/' class='btn btn-primary pull-right'>
                            <span class='glyphicon glyphicon-plus'></span>Добавить
                        </a>
                    </div>
                    <div class="table-responsive">
                        <c:if test="${!empty products}">
                            <table id="productsTable" class="table table-hover table-bordered">
                                <thead>
                                    <tr>
                                        <!--<th>№</th>-->
                                        <th>Наименование</th>
                                        <th>Стоимость</th>
                                        <th>Количество</th>
                                        <th>Категория</th>
                                        <th>Действия</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${products}" var="product">
                                    <tr>
                                        <td>${product.title}</td>
                                        <td>${product.cost}</td>
                                        <td>${product.amount}</td>
                                        <td>${product.category.categoryName}</td>
                                        <td>
                                            <a href='/rental/info/${product.id}/' class='btn btn-primary left-margin'>
                                            <span class='glyphicon glyphicon-list'></span>
                                            Инфо
                                            </a>
                                            <a delete-id='${product.id}' class='btn btn-danger delete-object'>
                                            <span class='glyphicon glyphicon-remove'></span>
                                            Удалить
                                            </a>
                                            <a href='/rental/updateproduct/${product.id}/' class='btn btn-info left-margin'>
                                            <span class='glyphicon glyphicon-edit'></span>
                                            Редактировать
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            </table>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@ include file="footer.jsp" %>