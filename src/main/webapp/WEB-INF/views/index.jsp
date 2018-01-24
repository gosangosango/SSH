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
                <div class="container no-padding">
                    <div class="row">
                        <!-- Carousel Slideshow -->
                        <div id="carousel-example" class="carousel slide" data-ride="carousel">
                            <!-- Carousel Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example" data-slide-to="1"></li>
                                <li data-target="#carousel-example" data-slide-to="2"></li>
                            </ol>
                            <div class="clearfix"></div>
                            <!-- End Carousel Indicators -->
                            <!-- Carousel Images -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="${ctx}/resources/assets/img/slideshow/slides1.jpg" width="1246px" height="274px">
                                </div>
                                <div class="item">
                                    <img src="${ctx}/resources/assets/img/slideshow/slides2.jpg" width="1246px" height="274px">
                                </div>
                                <div class="item">
                                    <img src="${ctx}/resources/assets/img/slideshow/slides3.jpg" width="1246px" height="274px">
                                </div>
                            </div>
                            <!-- End Carousel Images -->
                            <!-- Carousel Controls -->
                            <a class="left carousel-control" href="#carousel-example" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                            <!-- End Carousel Controls -->
                        </div>
                        <!-- End Carousel Slideshow -->
                    </div>
                </div>
                <div class="container background-gray-lighter">
                    <div class="row margin-vert-40">
                        <div class="col-md-4">
                            <div class="col-md-4">
                                <i class="fa-clock-o fa-5x color-primary"></i>
                            </div>
                            <div class="col-md-8">
                                <h2 class="margin-top-5 margin-bottom-0">179</h2>
                                <p>월 평균 근로시간</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="col-md-4">
                                <i class="fa-tachometer fa-5x color-primary"></i>
                            </div>
                            <div class="col-md-8">
                                <h2 class="margin-top-5 margin-bottom-0">16,981K</h2>
                                <p>산업 종사자 수</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="col-md-4">
                                <i class="fa-users fa-5x color-primary"></i>
                            </div>
                            <div class="col-md-8">
                                <h2 class="margin-top-5 margin-bottom-0">21,055</h2>
                                <p>연간 사망자 수</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container background-white">
                    <div class="row margin-vert-30">
                        <!-- Main Text -->
                        <div class="col-md-12">
                            <h2 class="text-center">Welcome to BoBSafety</h2>
                            <p class="text-center">저희 BoBSafety는 나날이 발전이 되어가는 기술과 문명속에도 불구하고 줄어들지 않는 재해실태에 대한 솔루션을 제공하기위해 항상 노력합니다.</p>
                            <p class="text-center">실시간으로 근로자들을 모니터링하고 위급상황이 발생하였을 시 빠르게 대처 가능하도록 다양한 정보들을 제공합니다. 
                            <br>사람이 우선이되는 기술 BoBSafety과 함께하세요.</p>
                        </div>
                        <!-- End Main Text -->
                    </div>
                </div>
                <div class="container background-gray-lighter">
                    <div class="row padding-vert-20">
                        <div class="col-md-1">
                        </div>
                        <div class="col-md-10">
                            <!-- Portfolio -->
                            <ul class="portfolio-group">
                                <!-- Portfolio Item -->
                           
                                <!-- //Portfolio Item// -->
                                <!-- Portfolio Item -->
                                <li class="portfolio-item col-sm-6 col-xs-6 padding-20">
                                    <a href="http://www.segye.com/newsView/20170108001393">
                                        <figure class="animate fadeInRight">
                                            <img alt="image2" src="${ctx}/resources/assets/img/frontpage/news1.jpg">
                                            <figcaption>
                                                <h3>제주시 공사장 사고</h3>        
                                            </figcaption>
                                        </figure>
                                    </a>
                                </li>
                                <!-- //Portfolio Item// -->
                                <!-- Portfolio Item -->
                                <li class="portfolio-item col-sm-6 col-xs-6 padding-20">
                                    <a href="http://www.yonhapnews.co.kr/bulletin/2016/06/01/0200000000AKR20160601029255060.HTML">
                                        <figure class="animate fadeInLeft">
                                            <img alt="image3" src="${ctx}/resources/assets/img/frontpage/news2.jpg">
                                            <figcaption>
                                                <h3>지하철 공사장 폭발사고</h3>
                                            </figcaption>
                                        </figure>
                                    </a>
                                </li>
                                <!-- //Portfolio Item// -->
                                <!-- Portfolio Item -->
                                <li class="portfolio-item col-sm-6 col-xs-6 padding-20">
                                    <a href="http://www.insight.co.kr/newsRead.php?ArtNo=79696">
                                        <figure class="animate fadeInRight">
                                            <img alt="image4" src="${ctx}/resources/assets/img/frontpage/news3.jpg">
                                            <figcaption>
                                                <h3>철교 내진 보강공사 추락 사고</h3>
                                            </figcaption>
                                        </figure>
                                    </a>
                                </li>
                                <!-- //Portfolio Item// -->
                                <!-- Portfolio Item -->
                                <li class="portfolio-item col-sm-6 col-xs-6 padding-20">
                                    <a href="http://www.hani.co.kr/arti/society/society_general/759876.html">
                                        <figure class="animate fadeInLeft">
                                            <img alt="image5" src="${ctx}/resources/assets/img/frontpage/news4.jpg">
                                            <figcaption>
                                                <h3>신세계 건설현장 배관사고</h3>
                                            </figcaption>
                                        </figure>
                                    </a>
                                </li>
                                
                            </ul>
                            <!-- End Portfolio -->
                        </div>
                        <div class="col-md-1">
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