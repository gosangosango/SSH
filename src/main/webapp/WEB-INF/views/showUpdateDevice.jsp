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
                        <!-- Register Box -->
                        <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                            <form class="signup-page" action="${ctx}/updateDevice.do" method="post">
                                <div class="signup-header">
                                    <h2>Update your device info</h2>

                                </div>
                                <label>Device Id</label>
                                <input class="form-control margin-bottom-20" type="text" value="${device.deviceId}" name="deviceId" id="deviceId"> 
                                <label>Device Name</label>
                                <input class="form-control margin-bottom-20" type="text" value="${device.deviceName}" name="deviceName" id="deviceName">
                                <label>Device User</label>
                                <input class="form-control margin-bottom-20" type="text" value="${device.deviceUser}" name="deviceUser" id="deviceUser">
                                <label>Device User P.H</label>
                                <input class="form-control margin-bottom-20" type="text" value="${device.deviceUserPH}" name="deviceUserPH" id="deviceUserPH">
                                
                                <hr>
                                <div class="row">
                                    <div class="col-lg-8">
                                      
                                    </div>
                                    <div class="col-lg-4 text-right">
                                        <button class="btn btn-primary" type="submit">Update</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- End Register Box -->
                    </div>
                </div>
            </div>
            <!-- === END CONTENT === -->
            <%@include file="common/bottomFooter.jsp"%>
    </body>
</html>
<!-- === END FOOTER === -->