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
                    <div class="row margin-vert-40">
 
                        <div class="col-md-9">
                        
                        
                        <c:forEach items="${devices}" var="device" varStatus="sts">
                            <div class="row">
                                <!-- Testimonials - Default Full Width -->
                                <div class="col-md-12">
                                    <div class="carousel slide testimonials" id="testimonials1">
                                        
                                        <div class="carousel-inner">
                                            
                                                <div class="col-md-12">
                                                  
                                                    <div class="testimonial-info">
                                                        
                                                        <span class="testimonial-author">
                                                        ${device.deviceUser}  ${device.deviceUserPH}
                                                            
                                                            <em>
                                                                ${device.deviceName} [${device.deviceId}]
                                                                <div style="float:right;">
                                                                <a href="${ctx}/deleteDevice.do?deviceId=${device.deviceId}">
                                                                <span class="glyphicon glyphicon-remove" style="float:right;"></span>
                                                                </a>
                                                                  <a href="${ctx}/showData.do?deviceId=${device.deviceId}">
                                                                <span class="glyphicon glyphicon-search" style="margin-right:40px;"></span>
                                                                </a>
                                                                <a href="${ctx}/showUpdateDevice.do?deviceId=${device.deviceId}">
                                                                <span class="glyphicon glyphicon-cog"  style="margin-right:40px;"></span>
                                                                </a>
                                                              
                                                                </div>
                                                            </em>
                                                        </span>
                                                    </div>
                                                </div>
                                                <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Testimonials - default full width -->
                            </div>
                            <hr class="margin-top-20">
                            
                            </c:forEach>
                            
                            <a href="${ctx}/showRegistDevice.do">
                                <button type="button" class="btn btn-primary">Regist Device</button>
                       		</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- === END CONTENT === -->
   			<%@include file="common/bottomFooter.jsp"%>
    </body>
</html>
<!-- === END FOOTER === -->