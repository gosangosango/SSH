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
    </head>
    <body>
    <c:set var="ctx">${pageContext.request.contextPath}</c:set>
    <%@include file="common/topHeader.jsp"%>
            <!-- === BEGIN CONTENT === -->
            <div id="content">
                <div class="container background-white">
                    <div class="row margin-vert-30">
                        <!-- Main Column -->
                        <div class="col-md-9">
                            <!-- Main Content -->
                            <div class="headline">
                                <h2>Recent Data</h2>
                            </div>
                            <p>서버로 전송된 데이터중 가장 최근의 5개를 나타냅니다<br>
                                                                           전송된 날짜, 디바이스ID, 불안정 상태 데이터 종류, 위도, 경도 순으로 표시됩니다

                            </p>
                            <br>
                            <!-- Contact Form -->
                            <form>
                            <c:forEach items="${dataList}" var="data" varStatus="sts">
                                <label>Date&Time : ${data.receivedDate}</label>
                                <div class="row margin-bottom-20">
                                    <div class="col-md-6 col-md-offset-0">
                                       DeviceId:${data.deviceId}<br>   Kind:${data.kind}<br>   Latitude:${data.latitude}<br>   Longitude:${data.longitude}
                                    </div>
                                </div>
                            </c:forEach>
                            </form>
                            <!-- End Contact Form -->
                            <!-- End Main Content -->
                        </div>
                        <!-- End Main Column -->
                        
                    </div>
                </div>
            </div>
            <!-- === END CONTENT === -->
         	<%@include file="common/bottomFooter.jsp"%>
    </body>
</html>
<!-- === END FOOTER === -->