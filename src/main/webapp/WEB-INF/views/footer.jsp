<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="widget">
                    <address>
                        <strong>Автопрокат</strong><br>
                        г.Уфа ул.Ленина, 12<br>
                    </address>
                    <p>
                        <i class="icon-phone"></i> (8) 999-999-99-99 <br>
                        <i class="icon-envelope-alt"></i> email@mail.ru
                    </p>
                </div>
            </div>
        </div>
    </div>
</footer>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/main.js"></script>

<script>
    // JavaScript for deleting product
    $(document).on('click', '.delete-object', function () {

        var id = $(this).attr('delete-id');

        bootbox.confirm({
            message: "<h4>Вы уверены?</h4>",
            buttons: {
                confirm: {
                    label: '<span class="glyphicon glyphicon-ok"></span> Да',
                    className: 'btn-danger'
                },
                cancel: {
                    label: '<span class="glyphicon glyphicon-remove"></span> Нет',
                    className: 'btn-primary'
                }
            },
            callback: function (result) {

                if (result == true) {

                    $.post('/admin/deleteproduct/', {
                        object_id: id
                    }, function (data) {
                        location.reload();
                    }).fail(function () {
                        alert('Unable to delete.');
                    });
                }
            }
        });

        return false;
    });
</script>
<!--<script src="js/navbar.js"></script>-->
</body>
</html>