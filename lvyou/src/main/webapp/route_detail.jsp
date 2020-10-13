<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2020/10/13
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>路线详情</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/route-detail.css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="js/getParameter.js"></script>
    <script type="text/javascript">
        $(function () {
            ///route_detail.jsp?rid=3
            var rid = getParameter("rid")
            // 当前页面需要取得 由【查看详情】传过来的rid
            $.get('routedetail/find?rid=' + rid, function (data) {
                // 发请求 给 routedetail/find?rid=3 可以获取rid对应的json数据
                if (200 == data.code) {
                    //console.log(data.data)
                    var route = data.data;
                    // 并json数据的值 赋给当前的标签 html()  $(id)
                    $("#category").html(route.category.cname)
                    $("#rname").html(route.rname)
                    $("#title").html(route.rname)
                    $("#introduce").html(route.routeIntroduce)
                    $("#sname").html('商家名称:' + route.seller.sname)
                    $("#consphone").html('商家电话' + route.seller.consphone)
                    $("#address").html('地址' + route.seller.address)
                    $("#price").html(route.price)
                    //图片
                    //左侧一张大图
                    $('#big_img').attr('src', route.rimage)
                    //右侧多张小图  前四张可见，第五张起，需要点击才可见
                    var alist = '';
                    //向上的箭头
                    alist += '<a class="up_img up_img_disable"></a>'

                    var list = route.imgList
                    for (var i = 0; i < list.length; i++) {
                        var routeImg = list[i]
                        //
                        var a = ''
                        if(i<4){ //前四张
                            a = '<a title="" class="little_img" data-bigpic="'+routeImg.bigPic+'" >\n' +
                                '                        <img src="'+routeImg.smallPic+'">\n' +
                                '                        </a>'
                        }else{
                            a = '<a title="" class="little_img" data-bigpic="'+routeImg.bigPic+'" style="display:none;" >\n' +
                                '                        <img src="'+routeImg.smallPic+'">\n' +
                                '                        </a>'
                        }

                        alist+=a //将多个a标签拼接
                    }

                    //向下的箭头
                    alist += '<a class="down_img down_img_disable" style="margin-bottom: 0;"></a>'


                    $('#small_imgs').html(alist)

                    //给小图添加事件
                    clickImgs()
                }

            }, "json")

        })
    </script>
</head>

<body>
<!--引入头部-->
<div id="header">
    <%@include file="header.jsp"%>
</div>
<!-- 详情 start -->
<div class="wrap">
    <div class="bread_box">
        <a href="index.jsp">首页</a>
        <span> &gt;</span>
        <a href="#" id="category">国内游</a><span> &gt;</span>
        <a href="#" id="rname">全国-曼谷6-7天自由行 泰国出境旅游 特价往返机票自由行二次确认</a>
    </div>
    <div class="prosum_box">
        <dl class="prosum_left">
            <dt>
                <img alt="" class="big_img" id="big_img" src="">
            </dt>
            <dd  id="small_imgs">

            </dd>
        </dl>
        <div class="prosum_right">
            <p class="pros_title" id="title">【尾单特卖】全国-曼谷6-7天自由行 泰国出境旅游 特价往返机票自由行二次确认</p>
            <p class="hot" id="introduce">1-2月出发，网付立享￥1099/2人起！爆款位置有限，抢完即止！</p>
            <div class="pros_other">
                <p id="sname">经营商家  ：途牛国旅</p>
                <p id="consphone">咨询电话 : 400-000-0000</p>
                <p id="address">地址 ： 我们要去BATJM</p>
            </div>
            <div class="pros_price">
                <p class="price"><strong id="price">¥2699.00</strong><span>起</span></p>
                <p class="collect">
                    <a class="btn"><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>

                    <a  class="btn already" disabled="disabled"><i class="glyphicon glyphicon-heart-empty"></i>点击收藏</a>
                    <span>已收藏100次</span>
                </p>
            </div>
        </div>
    </div>
    <div class="you_need_konw">
        <span>旅游须知</span>
        <div class="notice">
            <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

            <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

            <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

            <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

            <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
            <p>1、旅行社已投保旅行社责任险。建议游客购买旅游意外保险 <br>

            <p>2、旅游者参加打猎、潜水、海边游泳、漂流、滑水、滑雪、滑草、蹦极、跳伞、滑翔、乘热气球、骑马、赛车、攀岩、水疗、水上飞机等属于高风险性游乐项目的，敬请旅游者务必在参加前充分了解项目的安全须知并确保身体状况能适应此类活动；如旅游者不具备较好的身体条件及技能，可能会造成身体伤害。</p>

            <p>3、参加出海活动时，请务必穿着救生设备。参加水上活动应注意自己的身体状况，有心脏病、冠心病、高血压、感冒、发烧和饮酒及餐后不可以参加水上活动及潜水。在海里活动时，严禁触摸海洋中各种鱼类，水母，海胆，珊瑚等海洋生物，避免被其蛰伤。老人和小孩必须有成年人陪同才能参加合适的水上活动。在海边游玩时，注意保管好随身携带的贵重物品。</p>

            <p>4、根据中国海关总署的规定，旅客在境外购买的物品，在进入中国海关时可能需要征收关税。详细内容见《中华人民共和国海关总署公告2010年第54号文件》。</p>

            <p>5、建议出发时行李托运，贵重物品、常用物品、常用药品、御寒衣物等请随身携带，尽量不要托运。行李延误属于不可抗力因素，我司将全力协助客人跟进后续工作，但我司对此不承担任何责任。</p>
        </div>
    </div>
</div>
<!-- 详情 end -->

<!--引入头部-->
<div id="footer">
    <%@include file="footer.jsp"%>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!--导入布局js，共享header和footer-->

<script>
    function clickImgs() {
        //焦点图效果
        //点击图片切换图片
        $('.little_img').on('mousemove', function() {
            $('.little_img').removeClass('cur_img');
            var big_pic = $(this).data('bigpic');
            $('.big_img').attr('src', big_pic);
            $(this).addClass('cur_img');
        });
        //上下切换
        var picindex = 0;
        var nextindex = 4;
        $('.down_img').on('click',function(){
            var num = $('.little_img').length;
            if((nextindex + 1) <= num){
                $('.little_img:eq('+picindex+')').hide();
                $('.little_img:eq('+nextindex+')').show();
                picindex = picindex + 1;
                nextindex = nextindex + 1;
            }
        });
        $('.up_img').on('click',function(){
            var num = $('.little_img').length;
            if(picindex > 0){
                $('.little_img:eq('+(nextindex-1)+')').hide();
                $('.little_img:eq('+(picindex-1)+')').show();
                picindex = picindex - 1;
                nextindex = nextindex - 1;
            }
        });
        //自动播放
        // var timer = setInterval("auto_play()", 5000);
    }

    //自动轮播方法
    function auto_play() {
        var cur_index = $('.prosum_left dd').find('a.cur_img').index();
        cur_index = cur_index - 1;
        var num = $('.little_img').length;
        var max_index = 3;
        if ((num - 1) < 3) {
            max_index = num - 1;
        }
        if (cur_index < max_index) {
            var next_index = cur_index + 1;
            var big_pic = $('.little_img:eq(' + next_index + ')').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(' + next_index + ')').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        } else {
            var big_pic = $('.little_img:eq(0)').data('bigpic');
            $('.little_img').removeClass('cur_img');
            $('.little_img:eq(0)').addClass('cur_img');
            $('.big_img').attr('src', big_pic);
        }
    }
</script>
</body>

</html>
