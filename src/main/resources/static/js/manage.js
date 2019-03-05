$(function(){
    //初始化管理界面的高度，根据当前屏幕变化
    var nowHeight = $(window).height();//获取当前屏幕的可视高度
    $(".mag_left").css("height",nowHeight);
    $(".mag_right").css("height",nowHeight);
    // alert($(".left_title").text())
    var data = JSON.parse(sessionStorage.getItem("aa"));//获取上个页面储存的值，进行解析展示
    //下面进行页面的动态展示
    $(".mag_uname").text(data["user"].userName)//姓名
    $(".mag_pname").text(data["user"].postName)//职位
    //循环获取该用户的功能模块
    var magArr = data["manage"]
    var magLen = data["manage"].length
    for (var i = 0 ; i<magLen;i++){
        // alert(magArr[i].manageId)
        // alert(magArr[i].manageName)
        //这里面进行功能模块的动态加载
        $(".mag_left").append("<div style='width: 100%;margin: auto;margin-top: 2%'>"+
        "<input class='magBut' id='"+magArr[i].manageId+"' type='button' style='background-color: antiquewhite;font-size: 30px;color: burlywood;font-weight: bold;text-align: center;width: 100%;margin: auto' value='"+magArr[i].manageName+"' />"+
            "</div>")
    }
    $(".magBut").click(function () {//点击哪一个功能变换背景色，其他没点的保持不变。
        $(".magBut").css("background-color","antiquewhite")
        $(this).css("background-color","dimgrey")
        //并给这个功能加上一个ajax请求
    })
    //管理模块的点击事件
    $("#1").click(function () {
        $.ajax({
            type:"get",
            url:"manage/magStaff",
            dataType:"json",
            success:function (data) {
                // alert(data[0].userName)
                // console.log((data))
                //吧用户信息封装到表单里面
                //先把这个下面页面初始化为空
                $("#mag_down").html("");
                var dataInfo;

                for(var i = 0;i<data.length;i++){
                    var up = "";
                    var down = "";
                    if(data[i].downdown == "Y"){
                        up = "<input class='postBu' type='button' value='降职' style='width: 60%;height: 100%;margin: auto' post='down' />"
                    }
                    if(data[i].upup == "Y"){
                        down = "<input class='postBu' type='button' value='升职' style='width: 60%;height: 100%;margin: auto' post='up' />"
                    }
                    dataInfo = dataInfo +
                        "<tr userId='"+data[i].userId+"' postId='"+data[i].userPost+"'>"+
                        "<td>"+(i+1)+"</td>"+
                        "<td>"+data[i].userName+"</td>"+
                        "<td>"+data[i].postName+"</td>"+
                        "<td>"+up+"</td>"+
                        "<td>"+down+"</td>"+
                        "</tr>"
                }
                $("#mag_down").append("<table style='width: 80%;margin: auto;margin-top: 5%;text-align: center;border: 3px black solid;'>" +
                    "            <tr>" +
                    "                <th>编号</th>" +
                    "                <th>员工姓名</th>" +
                    "                <th>员工职位</th>" +
                    "                <th colspan='2'>职位管理</th>" +
                    "            </tr>" + dataInfo+
                    "        </table>");
                $("table tr td,table tr th").css("border","1px black solid")
                //给升值或者降职加点击事件
                $(".postBu").click(function () {
                    var dataPost;
                    var indexUser = $(this).parent().parent().index();//
                    // console.log("indexUser=="+indexUser)
                    var udPost = $(this).attr("post")
                    // console.log("ud=="+ud)
                    var user_id = $("table").find("tr").eq(indexUser).attr("userId")
                    var post_id = $("table").find("tr").eq(indexUser).attr("postId")
                    dataPost = {
                        ud:udPost,
                        userId:user_id,
                        postId:post_id
                    }
                    // console.log(dataPost)
                    $.ajax({
                        type:"post",
                        url:"manage/upordown",
                        data:dataPost,
                        success:function (data) {
                            if(data=="YES"){
                                alert("职位设置成功")
                                $('#1').trigger("click");//再次执行以下点击事件
                            }
                        }
                    })
                })
            }
        })
    })
    //打分
    $("#2").click(function () {
        $.ajax({
            type:"get",
            url:"manage/mark",
            dataType:"json",
            success:function (data) {
                console.log(data)
                //先把这个下面页面初始化为空
                $("#mag_down").html("");
                var dataInfo;

                for(var i = 0;i<data.length;i++){
                    var up = "";
                    var down = "";
                    if(data[i].mark == null){
                        up = "<input class='u_mark' onkeyup=\"value=value.replace(/[^\\d]/g,'')\" onbeforepaste=\"clipboardData.setData('text',clipboardData.getData('text').replace(/[^\\d]/g,''))\">"
                        down = "<input class='YBu' type='button' value='确定' style='width: 60%;height: 100%;margin: auto' post='up' />"

                    }else {
                        up = "<input type='text' disabled value='"+data[i].mark+"' style='width: 60%;height: 100%;margin: auto' post='down' />"
                    }
                    dataInfo = dataInfo +
                        "<tr userId='"+data[i].userId+"' postId='"+data[i].parentId+"'>"+
                        "<td>"+(i+1)+"</td>"+
                        "<td>"+data[i].userName+"</td>"+
                        "<td>"+data[i].postName+"</td>"+
                        "<td>"+up+"</td>"+
                        "<td>"+down+"</td>"+
                        "</tr>"
                }
                $("#mag_down").append("<table style='width: 80%;margin: auto;margin-top: 5%;text-align: center;border: 3px black solid;'>" +
                    "            <tr>" +
                    "                <th>编号</th>" +
                    "                <th>员工姓名</th>" +
                    "                <th>员工职位</th>" +
                    "                <th colspan='2'>本月考核分数</th>" +
                    "            </tr>" + dataInfo+
                    "        </table>");
                $("table tr td,table tr th").css("border","1px black solid")
                $(".YBu").click(function () {
                    var markUser = $(".u_mark").val()
                    if(markUser==null || markUser==""){
                        alert("分数不能为空")
                        return;
                    }
                    if(markUser.length<=2 || (markUser.length==3 && markUser==100)){

                    }else{
                        alert("分数必须在100以内")
                        return;
                    }
                    var indexUser = $(this).parent().parent().index();//
                    var user_id = $("table").find("tr").eq(indexUser).attr("userId")
                    var post_id = $("table").find("tr").eq(indexUser).attr("postId")
                    var dataPost;
                    dataPost = {
                        mark:markUser,
                        userId:user_id,
                        postParentId:post_id
                    }
                    console.log(dataPost)
                    //发请求插入分数数据
                    $.ajax({
                        type:"post",
                        url:"manage/playMark",
                        data:dataPost,
                        success:function (data) {
                            if(data=="YES"){
                                alert("打分成功")
                                $('#2').trigger("click");//再次执行以下点击事件
                            }
                        }
                    })
                })
            }
        })
    })
});