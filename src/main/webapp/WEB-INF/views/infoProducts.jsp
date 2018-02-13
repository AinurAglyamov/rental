<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>
<main style="height:100%">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>${product.title}</h1>
            </div>
            <div class='right-button-margin'>
                <a href='/rental/category/${product.category.id}/' class='btn btn-default pull-right'>Назад к списку</a>
            </div>

            <table id="infoTable" class='table table-hover table-responsive table-bordered'>

                <tr>
                    <td>Наименование</td>
                    <td>${product.title}</td>
                </tr>

                <tr>
                    <td>Стоимость</td>
                    <td>${product.cost}</td>
                </tr>

                <tr>
                    <td>Количество</td>
                    <td>${product.amount}</td>
                </tr>


                <tr>
                    <td>Категория</td>
                    <td>${product.category.categoryName}</td>
                </tr>
                <!---->
            </table>

        </div>
    </div>
</main>
<%@ include file="footer.jsp" %>