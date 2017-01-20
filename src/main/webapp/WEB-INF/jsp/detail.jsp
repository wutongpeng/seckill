<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>秒杀详情页</title>
    <%@include file="common/head.jsp"%>
  </head>
  <body>
        <div class="container">
             <div class="panel panel-default text-center">
                  <div class="panel-heading">
                      <h1>${seckill.name}</h1>
                  </div>
                  <div class="panel-body">
                      <h2 class="text-danger">
                          <span class="glyphicon glyphicon-time"></span>
                          <span class="glyphicon" id="seckill-box"></span>
                      </h2>
                  </div>
             </div>
        </div>
        <!-- 登录弹出层，输入电话 -->
        <div id="killPhoneModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title text-center">
                            <span class="glyphicon glyphicon-phone"></span>秒杀电话
                        </h3>
                    </div>

                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-8 col-xs-offset-2">
                                <input type="text" name="killPhone" id="killPhoneKey"
                                    placeholder="填写手机号" class="form-control"/>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <!-- 验证信息-->
                        <span id="killPhoneMessage" class="glyphicon"></span>
                        <button type="button" id="killPhoneBtn" class="btn btn-success">
                            <span class="glyphicon glyphicon-phone"></span>
                            Submit
                        </button>
                    </div>
                </div>
            </div>
        </div>
  </body>
  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

  <!-- jQuery cookie -->
  <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
  <!-- jquery.countdown -->
  <script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.js"></script>

  <script src="/resources/script/seckill.js" type="text/javascript"></script>

  <script type="text/javascript">
      $(function () {
          seckill.detail.init({
              seckillId : ${seckill.seckillId},
              startTime : ${seckill.startTime.time},
              endTime : ${seckill.endTime.time}
          });
      });
  </script>

</html>
