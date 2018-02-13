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
                <h1>Добавить продукт</h1>
            </div>
            <div class='right-button-margin'>
                <a href='/rental/' class='btn btn-default pull-right'>Назад к списку</a>
            </div>

            <!--<form action="/admin/createproduct/" method="post">

                <table class='table table-hover table-responsive table-bordered'>

                    <tr>
                        <td>Наименование</td>
                        <td><input type='text' name='title' class='form-control' /></td>
                    </tr>

                    <tr>
                        <td>Стоимость</td>
                        <td><input type='text' name='cost' class='form-control' /></td>
                    </tr>

                    <tr>
                        <td>Количество</td>
                        <td><input type='text' name='amount' class='form-control' /></td>
                    </tr>

                    <tr>
                        <td>Категория</td>
                        <td>
                            <select class="form-control" id="selectCategory" name="category_id">
                                <option>Выберите категорию...</option>"
                                {foreach $categories as $category}
                                {if {$catId}=={$category['id']}}
                                <option value="{$category['id']}" selected>{$category['category_name']}</option>
                                {else}
                                <option value="{$category['id']}">{$category['category_name']}</option>
                                {/if}
                                {/foreach}
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <button type="submit" class="btn btn-primary">Добавить</button>
                        </td>
                    </tr>

                </table>
            </form>-->
            <form:form action="/rental/addproduct/" modelAttribute="product" method="post">
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