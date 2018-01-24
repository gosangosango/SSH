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
                        <div class="col-md-12">
                            
                            <div class="row">
                                <div class="col-md-6 animate fadeIn" >
                                <h2>Gps Tracking</h2>
                                    <div id="map" style="width:480px;height:380px;"></div>
         
                                </div>
                                <div class="col-md-6 margin-bottom-10 animate fadeInRight">
                                
                                <c:forEach items="${datas}" var="data" varStatus="sts">
                                    <h3 class="padding-top-10 pull-left" style="margin-top:35px;">${data.kind}
                                        <small>- ${data.receivedDate}</small>
                                    </h3>
                                    <div class="clearfix"></div>
                                    
                                </c:forEach>   
                                    
                                                                 
                                   
                                   
                                </div>
                            </div>
                            
                            
                            
                   
                        </div>
                    </div>
                </div>
            </div>
            <!-- === END CONTENT === -->
			<%@include file="common/bottomFooter.jsp"%>
            
            <c:forEach items="${datas}" var="data" varStatus="sts">
   				<input type="hidden" id="lat${sts.index+1}" value="${data.gpsLatitude}"></input>
   				<input type="hidden" id="lng${sts.index+1}" value="${data.gpsLongitude}"></input>            
   			</c:forEach>
            
            <!-- JS -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
    
    
    var lat1 = $('#lat1').val();
    
    



    var map;
    
      
      function initMap() {
    	  var lat1 = parseFloat($('#lat1').val());
          var lat2 = parseFloat($('#lat2').val());
          var lat3 = parseFloat($('#lat3').val());
          var lat4 = parseFloat($('#lat4').val());
          var lat5 = parseFloat($('#lat5').val());
          var lng1 = parseFloat($('#lng1').val());
          var lng2 = parseFloat($('#lng2').val());
          var lng3 = parseFloat($('#lng3').val());
          var lng4 = parseFloat($('#lng4').val());
          var lng5 = parseFloat($('#lng5').val());
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: lat1, lng: lng1},
          zoom: 14,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });
        
        var flightPlanCoordinates = [
                                      new google.maps.LatLng(lat1, lng1),
                                      new google.maps.LatLng(lat2, lng2),
                                      new google.maps.LatLng(lat3, lng3),
                                      new google.maps.LatLng(lat4, lng4),
                                      new google.maps.LatLng(lat5, lng5)
                                      ];
        var flightPath = new google.maps.Polyline({
              path: flightPlanCoordinates,
              strokeColor: "#FF0000",
              strokeOpacity: 1.0,
              strokeWeight: 2,
            icons : [{ 
                icon : {path : google.maps.SymbolPath.BACKWARD_CLOSED_ARROW}
              , offset  : '100%'
              , repeat : '100px'
           }]
        });
        
        var addLatlng1 = new google.maps.LatLng(lat1, lng1);
        var addLatlng2 = new google.maps.LatLng(lat2, lng2);
        var addLatlng3 = new google.maps.LatLng(lat3, lng3);
        var addLatlng4 = new google.maps.LatLng(lat4, lng4);
        var addLatlng5 = new google.maps.LatLng(lat5, lng5);

        var addMarker1 = new google.maps.Marker ({position: addLatlng1, title: 'Data.1'});
        var addMarker2 = new google.maps.Marker ({position: addLatlng2, title: 'Data.2'});
        var addMarker3 = new google.maps.Marker ({position: addLatlng3, title: 'Data.3'});
        var addMarker4 = new google.maps.Marker ({position: addLatlng4, title: 'Data.4'});
        var addMarker5 = new google.maps.Marker ({position: addLatlng5, title: 'Data.5'});

        addMarker1.setMap(map); 
        addMarker2.setMap(map); 
        addMarker3.setMap(map); 
        addMarker4.setMap(map); 
        addMarker5.setMap(map);
        




        flightPath.setMap(map);
        
      }
        
   
                                 
                                   
     
      
    </script>
    
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCyIR7D7-W8Z6hoN2eIvFkozZPijUEdf4c&callback=initMap"
    async defer></script>
            

    </body>
</html>
<!-- === END FOOTER === -->