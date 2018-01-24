<!-- === BEGIN HEADER === -->
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html lang="en">
    <!--<![endif]-->
    <head>
        <!-- Meta -->
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="google-signin-client_id" content="818581326403-dl0cnf5fu6r42lml3drt6ubph4uako8m.apps.googleusercontent.com">
        
    </head>
    
    <body>
    	<c:set var="ctx">${pageContext.request.contextPath}</c:set>
    	<%@include file="common/topHeader.jsp"%>

            <!-- === BEGIN CONTENT === -->
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                            <!-- Login Box -->
                            <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                                <form class="login-page" action="${ctx}/login.do" method="post">
                                    <div class="login-header margin-bottom-30">
                                        <h2>Login to your account</h2>
                                    </div>
                                    <div class="input-group margin-bottom-20">
                                        <span class="input-group-addon">
                                            <i class="fa fa-user"></i>
                                        </span>
                                        <input placeholder="Username" class="form-control" type="text" id="id" name="id">
                                    </div>
                                    <div class="input-group margin-bottom-20">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                        <input placeholder="Password" class="form-control" type="password" id="password" name="password">
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label class="checkbox">
                                                <input type="checkbox">Stay signed in</label>
                                        </div>
                                       
                                        <div class="col-md-6">
                                            <button class="btn btn-primary pull-right" type="submit">Login</button>
                                            
                                        </div>
                                        
                                    </div>
                                    
                                  
									<br>
									<!-- 네이버 로그인 화면으로 이동 시키는 URL -->
									<!-- 네이버 로그인 화면에서 ID, PW를 올바르게 입력하면 callback 메소드 실행 요청 -->
									<div id="naver_id_login" style="text-align:center"><a href="${naver_url}"><img width="223" src="${ctx}/resources/assets/img/naver_Bn_Green.png"/></a></div>
									<br>
									<!-- 구글 로그인 화면으로 이동 시키는 URL -->
									<!-- 구글 로그인 화면에서 ID, PW를 올바르게 입력하면 oauth2callback 메소드 실행 요청-->
									<div id="google_id_login" style="text-align:center"><a href="${google_url}"><img width="230" src="${ctx}/resources/assets/img/sign-in-with-google.png"/></a></div>





                                    
                                    
                                </form>
                            </div>
                            <!-- End Login Box -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- === END CONTENT === -->
        	<%@include file="common/bottomFooter.jsp"%>
        	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
        	<script src="https://apis.google.com/js/platform.js" async defer></script>
        	<script type="text/javascript" src="${ctx}/resources/assets/js/google_sing_in.js" type="text/javascript"></script>
    </body>
</html>
<!-- === END FOOTER === -->