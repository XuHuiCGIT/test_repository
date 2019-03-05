$(function(){
    $("#login_bu").click(function () {
        // alert(515);
        // alert($(window).height())
        var username = $("#user_login").val();
        var password = $("#password_login").val();
        if(username=="" || password==""){
            alert("用户密码不能为空")
            return;
        }
        $.ajax({
            type:"get",
            url:"login?userName="+username+"&passWord="+password,
            dataType:"json",
            success:function (data) {
                // alert(data["state"].toString())

                // alert(data["user"].userid)
                if(data["state"].toString()=="YES"){
                    window.location.href = "manage";//用户密码正确，跳转管理界面
                    alert(data["user"])
                    sessionStorage.setItem("aa",JSON.stringify(data))//储存json对象需要先转化为文本信息
                }else if(data["state"].toString()=="NO"){
                    alert("用户密码错误")
                }
            }
        })
    })
});



//连接关闭回调方法
// websocket.onclose = function () {
//     linkedMsg("链接已经断开！");
// }
// /**链接信息*/
// function linkedMsg(msg){
//     $("#linkedMsg").html(msg);
// }

















