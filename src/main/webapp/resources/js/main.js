$("#loginModal").on('show.bs.modal', function () {
        //alert("Модальное окно было успешно закрыто.");
        $('#inputLogin').val("");
        $('#inputPassword').val("");
    });
    
function login() {
    /**/$('#loginModal').modal('hide');
    //$('#loginForm').submit();
    $("#loginModal").on('hidden.bs.modal', function () {
        //alert("Модальное окно было успешно закрыто.");
        $('#loginForm').submit();
    });
    
}

var height = $('#products').outerHeight(true);
//alert(height);
$("#leftside").outerHeight(height);
//alert($("#leftside").height());
