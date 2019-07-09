$(function () {
    validaterule();
});

$.validator.setDefaults({
    submitHandler: function () {
        login();
    }
});

function login() {
    debugger;
    // $.modal.loading($("#btnSubmit").data("loading"));
    var username = $.common.trim($("#username").val());
    var password = $.common.trim($("#password").val());
    $.post("/doLogin", {loginName: username, password: password}, function (data) {
        console.log(data);
    });
}

//验证
function validaterule() {
    var icon = "<i class='fa fa-times-circle'></i>";
    $("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            username: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            }
        }
    })
}