<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">

        <meta name="description" content="趣传">
        <meta name="keywords" content="趣传">

        <title>趣传文章管理</title>
            
        <!-- CSS -->
        <link href="${path }/plugs/super/css/bootstrap.min.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/animate.min.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/font-awesome.min.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/form.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/calendar.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/style.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/icons.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/generics.css" rel="stylesheet"> 
    </head>
    <body id="skin-blur-violate">

        <header id="header" class="media">
            <a href="" id="menu-toggle"></a> 
            <a class="logo pull-left" href="javascript:;">首页</a>
            
            <div class="media-body">
            	
                <div class="media" id="top-menu">
                 	 <div id="time" class="pull-right">
                        <span id="hours"></span>
                        :
                        <span id="min"></span>
                        :
                        <span id="sec"></span>
                    </div>
                </div>
            </div>
        </header>
        
        <div class="clearfix"></div>
        
        <section id="main" class="p-relative" role="main">
            
            <!-- Sidebar -->
            <aside id="sidebar">
                
                <!-- Sidbar Widgets -->
                <div class="side-widgets overflow">
                    <!-- Profile Menu -->
                    <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                        <a href="" data-toggle="dropdown">
                            <img class="profile-pic animated" src="${path }/plugs/super/img/profile-pic.jpg" alt="">
                        </a>
                        <ul class="dropdown-menu profile-menu">
                            <li><a href="${path }/admin/system/logout">注销</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                        </ul>
                        <h4 class="m-0">${sysUser.username }</h4>
                    </div>
                    
                    <!-- Calendar -->
                    <div class="s-widget m-b-25">
                        <div id="sidebar-calendar"></div>
                    </div>
                </div>
                
                <!-- Side Menu -->
                <ul class="list-unstyled side-menu">
                    <li class="active">
                        <a class="sa-side-home" href="javascript:;" data-url="${path }/admin/system/index">
                            <span class="menu-item">首页</span>
                        </a>
                    </li>
                    <li>
                        <a class="sa-side-typography" href="javascript:;" data-url="${path }/admin/task/index">
                            <span class="menu-item">文章</span>
                        </a>
                    </li>
                </ul>

            </aside>
        
            <!-- Content -->
            <section id="content" class="container">
                
            </section>

            <!-- Older IE Message -->
            <!--[if lt IE 9]>
                <div class="ie-block">
                    <h1 class="Ops">Ooops!</h1>
                    <p>You are using an outdated version of Internet Explorer, upgrade to any of the following web browser in order to access the maximum functionality of this website. </p>
                    <ul class="browsers">
                        <li>
                            <a href="https://www.google.com/intl/en/chrome/browser/">
                                <img src="${path }/plugs/super/img/browsers/chrome.png" alt="">
                                <div>Google Chrome</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://www.mozilla.org/en-US/firefox/new/">
                                <img src="${path }/plugs/super/img/browsers/firefox.png" alt="">
                                <div>Mozilla Firefox</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://www.opera.com/computer/windows">
                                <img src="${path }/plugs/super/img/browsers/opera.png" alt="">
                                <div>Opera</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://safari.en.softonic.com/">
                                <img src="${path }/plugs/super/img/browsers/safari.png" alt="">
                                <div>Safari</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://windows.microsoft.com/en-us/internet-explorer/downloads/ie-10/worldwide-languages">
                                <img src="${path }/plugs/super/img/browsers/ie.png" alt="">
                                <div>Internet Explorer(New)</div>
                            </a>
                        </li>
                    </ul>
                    <p>Upgrade your browser for a Safer and Faster web experience. <br/>Thank you for your patience...</p>
                </div>   
            <![endif]-->
        </section>
        
        <!-- Javascript Libraries -->
        
        <!-- custom globle constant -->
        <script type="text/javascript">
        	var site_path = "${path }";
        </script>
        
        <!-- jQuery -->
        <script src="${path }/plugs/super/js/jquery.min.js"></script> <!-- jQuery Library -->
        <script src="${path }/plugs/super/js/jquery-ui.min.js"></script> <!-- jQuery UI -->
        <script src="${path }/plugs/super/js/jquery.easing.1.3.js"></script> <!-- jQuery Easing - Requirred for Lightbox + Pie Charts-->

        <!-- Bootstrap -->
        <script src="${path }/plugs/super/js/bootstrap.min.js"></script>

        <!--  Form Related -->
        <script src="${path }/plugs/super/js/input-mask.min.js"></script> <!-- Input Mask -->
        <script src="${path }/plugs/super/js/validation/validate.min.js"></script> <!-- jQuery Form Validation Library -->
        <script src="${path }/plugs/super/js/validation/validationEngine.min.js"></script> <!-- jQuery Form Validation Library - requirred with above js -->
        <script src="${path }/plugs/super/js/select.min.js"></script> <!-- Custom Select -->
		<script src="${path }/plugs/super/js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
		<script src="${path }/plugs/super/js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->
		<script src="${path }/plugs/super/js/fileupload.min.js"></script> <!-- File Upload -->
		<script src="${path }/plugs/super/js/autosize.min.js"></script> <!-- Textare autosize -->
		
		<!-- Text Editor -->
        <script src="${path }/plugs/super/js/editor2.min.js"></script> <!-- WYSIWYG Editor -->

        <!-- UX -->
        <script src="${path }/plugs/super/js/scroll.min.js"></script> <!-- Custom Scrollbar -->
        
        <!-- Qiniu -->
        <script src="${path }/plugs/qiniu/plupload.full.min.js"></script> 
        <script src="${path }/plugs/qiniu/qiniu.js"></script> 

        <!-- Other -->
        <script src="${path }/plugs/super/js/calendar.min.js"></script> <!-- Calendar -->
        <script src="${path }/plugs/super/js/feeds.min.js"></script> <!-- News Feeds -->
         <script src="${path }/js/format_date.js"></script> <!-- News Feeds -->
        
        <script type="text/javascript">
        $(document).ready(function(){
            /* --------------------------------------------------------
        	Sidebar + Menu
            -----------------------------------------------------------*/
            (function(){
                /* Menu Toggle */
                $('body').on('click touchstart', '#menu-toggle', function(e){
                    e.preventDefault();
                    $('html').toggleClass('menu-active');
                    $('#sidebar').toggleClass('toggled');
                    //$('#content').toggleClass('m-0');
                });
                 
                /* Active Menu */
                $('#sidebar .menu-item').hover(function(){
                    $(this).closest('.dropdown').addClass('hovered');
                }, function(){
                    $(this).closest('.dropdown').removeClass('hovered');
                });

                /* Prevent */
                $('.side-menu .dropdown > a').click(function(e){
                    e.preventDefault();
                });
        	

            })();
            
            /* --------------------------------------------------------
        	Calendar
            -----------------------------------------------------------*/
            (function(){
                //Sidebar
                if ($('#sidebar-calendar')[0]) {
                    var date = new Date();
                    var d = date.getDate();
                    var m = date.getMonth();
                    var y = date.getFullYear();
                    $('#sidebar-calendar').fullCalendar({
                        editable: false,
                        events: [],
                        header: {
                            left: 'title'
                        },
                        monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                        monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                        dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
                        dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"]
                    });
                }

                /* --------------------------------------------------------
            	Content widget
                -----------------------------------------------------------*/
                if ($('#calendar-widget')[0]) {
                    $('#calendar-widget').fullCalendar({
                        header: {
                            left: 'title',
                            right: 'prev, next',
                            //right: 'month,basicWeek,basicDay'
                        },
                        editable: true,
                        events: [
                            {
                                title: 'All Day Event',
                                start: new Date(y, m, 1)
                            },
                            {
                                title: 'Long Event',
                                start: new Date(y, m, d-5),
                                end: new Date(y, m, d-2)
                            },
                            {
                                title: 'Repeat Event',
                                start: new Date(y, m, 3),
                                allDay: false
                            },
                            {
                                title: 'Repeat Event',
                                start: new Date(y, m, 4),
                                allDay: false
                            }
                        ]
                    });
                }

            })();
            
            /* --------------------------------------------------------
            Date Time Widget
            -----------------------------------------------------------*/
            (function(){
                var monthNames = [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ];
                var dayNames= ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]

                // Create a newDate() object
                var newDate = new Date();

                // Extract the current date from Date object
                newDate.setDate(newDate.getDate());

                // Output the day, date, month and year
                $('#date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());

                setInterval( function() {

                    // Create a newDate() object and extract the seconds of the current time on the visitor's
                    var seconds = new Date().getSeconds();

                    // Add a leading zero to seconds value
                    $("#sec").html(( seconds < 10 ? "0":"" ) + seconds);
                },1000);

                setInterval( function() {

                    // Create a newDate() object and extract the minutes of the current time on the visitor's
                    var minutes = new Date().getMinutes();

                    // Add a leading zero to the minutes value
                    $("#min").html(( minutes < 10 ? "0":"" ) + minutes);
                },1000);

                setInterval( function() {

                    // Create a newDate() object and extract the hours of the current time on the visitor's
                    var hours = new Date().getHours();

                    // Add a leading zero to the hours value
                    $("#hours").html(( hours < 10 ? "0" : "" ) + hours);
                }, 1000);
            })();

            
            /* --------------------------------------------------------
        	load index
            -----------------------------------------------------------*/
        	(function(){
        		$("#content").load($(".side-menu li a:first").attr("data-url"));
        	})();
        	
        	/* --------------------------------------------------------
        	menu click 
            -----------------------------------------------------------*/
        	(function(){
        		$(".side-menu li a").click(function(){
        			var t = this;
        			$("#content").load($(t).attr("data-url"));
        			$(".side-menu li").each(function(){
        				$(this).removeClass("active");
        				$(t).parent().addClass("active");
        				$(".logo").text($(t).find("span").text());
        			});
        		});
        	})();
        });
        </script>
    </body>
</html>
