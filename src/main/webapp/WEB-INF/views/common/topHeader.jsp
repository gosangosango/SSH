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
        <!-- Title -->
        <title>BoBSafety - Safety first is Safety always</title>
        <!-- Meta -->
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="">
        <meta name="author" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <!-- Favicon -->
        <link href="favicon.ico" rel="shortcut icon">
        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="${ctx}/resources/assets/css/bootstrap.css" rel="stylesheet">
        <!-- Template CSS -->
        <link rel="stylesheet" href="${ctx}/resources/assets/css/animate.css" rel="stylesheet">
        <link rel="stylesheet" href="${ctx}/resources/assets/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="${ctx}/resources/assets/css/nexus.css?" rel="stylesheet">
        <link rel="stylesheet" href="${ctx}/resources/assets/css/responsive.css" rel="stylesheet">
        <link rel="stylesheet" href="${ctx}/resources/assets/css/custom.css" rel="stylesheet">
        <!-- Google Fonts-->
        <link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=PT+Sans" type="text/css" rel="stylesheet">
        <link href="http://fonts.googleapis.com/css?family=Roboto:400,300" rel="stylesheet" type="text/css">
    </head>
    <body>
    <c:set var="ctx">${pageContext.request.contextPath}</c:set>
        <div id="body-bg">
            <ul class="social-icons pull-right hidden-xs">
                <li class="social-rss">
                    <a href="#" target="_blank" title="RSS"></a>
                </li>
                <li class="social-twitter">
                    <a href="#" target="_blank" title="Twitter"></a>
                </li>
                <li class="social-facebook">
                    <a href="#" target="_blank" title="Facebook"></a>
                </li>
                <li class="social-googleplus">
                    <a href="#" target="_blank" title="GooglePlus"></a>
                </li>
            </ul>
            <div id="pre-header" class="container" style="height:340px">
            </div>
            <div id="header">
                <div class="container">
                    <div class="row">
                        <!-- Logo -->
                        <div style="float:right; margin-top:20px;">
            			<c:choose>
							<c:when test="${loginedUser eq null}" >
								<a href="${ctx}/showLogin.do" style="color:white; margin-left:5px; margin-right:5px">Login</a>/
								<a href="${ctx}/showSignUp.do" style="color:white; margin-left:5px; margin-right:5px">Join</a>
							</c:when>
							<c:otherwise>
								<a style="color:white; margin-right:5px;" href="${ctx}/logout.do">LogOut</a>   |
								<a href="${ctx}/showUpdateUser.do" class="badgeContainer" id="badge" style="color:white; margin-left:5px; margin-right:5px">MyPage</a>
							</c:otherwise>
						</c:choose>
					</div>
                        <div class="logo">
                            <a href="${ctx}/index.do" title="" >
                                <img src="${ctx}/resources/assets/img/logo.png" alt="Logo" width="270px" height="60px" style="margin-left:100px;"/>
                            </a>
                        </div>
                        <!-- End Logo -->
                    </div>
                </div>
            </div>
            <!-- Top Menu -->
            <div id="hornav" class="container no-padding">
                <div class="row">
                    <div class="col-md-12 no-padding">
                        <div class="text-center visible-lg">
                            <ul id="hornavmenu" class="nav navbar-nav">
                                <li>
                                    <a href="${ctx}/index.do" class="fa-home">Home</a>
                                </li>
                                <li>
                                    <a href="${ctx}/showDevices.do" class="fa-gears">Devices</a>
                                </li>
                                <li>
                                    <a href="${ctx}/showAboutUs.do" class="fa-font">AboutUs</a>
                                </li>
                                <li>
                                    <a href="${ctx}/showUpdateUser.do" class="fa-male">MyPage</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Top Menu -->
            <div id="post_header" class="container" style="height:100px">
            </div>
            <div id="content-top-border" class="container">
            </div>
            <!-- === END HEADER === -->
            
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
(function(d){
	  var i = "";
	  popUpWarning();
	  var int = window.setInterval(popUpWarning, 10000); //Update the badge ever 5 seconds
	  var badgeNum;    
	  function popUpWarning(){
		  $.ajax({
			  type:"GET",
	          url:"${pageContext.request.contextPath}/uncheckedData.do",
	          success:function(i){
	          	if(i != '0'){
	          		/*function popup_win1() { //크기 width400 height300 팝업창
	          			window.open("${pageContext.request.contextPath}/checkPopUp.do", "", "width=400, height=300");
	          		}
	          		*/
	          		alert("미확인 데이터 발생");
	          	}
	          	}
	      }) 
	    	
	  }
	})(document);
</script>
</body>
</html>