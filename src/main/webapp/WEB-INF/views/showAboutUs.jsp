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
    <c:set var="ctx">${pageContext.request.contextPath}</c:set>
    <%@include file="common/topHeader.jsp"%>
    <body>
            <!-- === BEGIN CONTENT === -->
            <div id="content">
                <div class="container background-white">
                    <div class="row margin-vert-30">
                        <div class="col-md-12">
                            <h2 class="margin-vert-20">About Us</h2>
                            <div class="row margin-bottom-30">
                                <div class="col-md-4 animate fadeInLeft">
                                    <p>Commodo id natoque malesuada sollicitudin elit suscipit. Curae suspendisse mauris posuere accumsan massa posuere lacus convallis tellus interdum. Amet nullam fringilla nibh nulla convallis ut venenatis purus lobortis.</p>
                                    <p class="margin-bottom-30">Lorem Ipsum is simply dummy text of Lorem the printing and typesettings. Aliquam dictum nulla eu varius porta. Maecenas congue dui id posuere fermentum. Sed fringilla sem sed massa ullamcorper, vitae rutrum justo sodales.
                                        Cras sed iaculis enim. Sed aliquet viverra nisl a tristique. Curabitur vitae mauris sem. Pellentesque iaculis nibh leo, mattis aliquet arcu tincidunt at.</p>
                                </div>
                                
                            	<div>
                            		<img style="margin-left:100px; width:500px; height:300px;" src="${ctx}/resources/assets/img/aboutUs.jpg">
                            	</div>
                               
                            </div>
                            
                            <hr class="margin-bottom-50">
  							<div class="col-md-8 animate fadeIn" style="width:900px;">
                                    <!-- Person Details -->
                                    <div style="width:25.00%;" class="col-md-4 col-sm-4 person-details margin-bottom-30">
                                        <figure>
                                            <img src="assets/img/theteam/image1.jpg" alt="image1">
                                            <figcaption>
                                                <h3 class="margin-bottom-10">Jongchan An
                                                    <small>- Programmer</small>
                                                </h3>
                                                <span>Nullam id dolor id nibh ultricies vehicula ut id elit.</span>
                                            </figcaption>
                                            <ul class="list-inline person-details-icons">
                                                <li>
                                                        <h6 style="text-align:center; font-size:2px; color:white;">gosangosango@gmail.com</h6>
                                                </li>
                                                
                                            </ul>
                                        </figure>
                                    </div>
                                    
                                    <div style="width:25.00%;" class="col-md-4 col-sm-4 person-details margin-bottom-30">
                                        <figure>
                                            <img src="assets/img/theteam/image1.jpg" alt="image1">
                                            <figcaption>
                                                <h3 class="margin-bottom-10">Gosan Yoon
                                                    <small>- Programmer</small>
                                                </h3>
                                                <span>Nullam id dolor id nibh ultricies vehicula ut id elit.</span>
                                            </figcaption>
                                            <ul class="list-inline person-details-icons">
                                                <li>
                                                        <h6 style="text-align:center; font-size:2px; color:white;">gosangosango@gmail.com</h6>
                                                </li>
                                                
                                            </ul>
                                        </figure>
                                    </div>
                                    
                                    <div style="width:25.00%;" class="col-md-4 col-sm-4 person-details margin-bottom-30">
                                        <figure>
                                            <img src="assets/img/theteam/image1.jpg" alt="image1">
                                            <figcaption>
                                                <h3 class="margin-bottom-10">Jinhyeok Choi
                                                    <small>- Programmer</small>
                                                </h3>
                                                <span>Nullam id dolor id nibh ultricies vehicula ut id elit.</span>
                                            </figcaption>
                                            <ul class="list-inline person-details-icons">
                                                <li>
                                                        <h6 style="text-align:center; font-size:2px; color:white;">gosangosango@gmail.com</h6>
                                                </li>
                                                
                                            </ul>
                                        </figure>
                                    </div>
                                    
                                    <div style="width:25.00%;" class="col-md-4 col-sm-4 person-details margin-bottom-30">
                                        <figure>
                                            <img src="assets/img/theteam/image1.jpg" alt="image1">
                                            <figcaption>
                                                <h3 class="margin-bottom-10">Soyoon Jo
                                                    <small>- Programmer</small>
                                                </h3>
                                                <span>Nullam id dolor id nibh ultricies vehicula ut id elit.</span>
                                            </figcaption>
                                            <ul class="list-inline person-details-icons">
                                                <li>
                                                        <h6 style="text-align:center; font-size:2px; color:white;">gosangosango@gmail.com</h6>
                                                </li>
                                                
                                            </ul>
                                        </figure>
                                    </div>
                                    
                                   
                                </div>
                            
                        </div>
                    </div>
                </div>
            </div>
            <!-- === END CONTENT === -->
            <!-- === BEGIN FOOTER === -->
         <%@include file="common/bottomFooter.jsp"%>
    </body>
</html>
<!-- === END FOOTER === -->